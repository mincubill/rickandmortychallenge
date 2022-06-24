package com.acubillos.rickandmortychallenge.infrastructure.gateway;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetCharacterByIdGateway;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InternalErrorException;
import com.acubillos.rickandmortychallenge.infrastructure.exception.NotFoundException;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper.CharacterInputToCharacterEntityMapper;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.CharacterInput;
import com.acubillos.rickandmortychallenge.modelmock.entity.CharacterMock;
import com.acubillos.rickandmortychallenge.modelmock.input.CharacterInputMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class GetCharacterByIdFromApiTest {
    @Mock
    private CharacterInputToCharacterEntityMapper mapper;
    @Mock
    private RestTemplate restTemplate;

    private GetCharacterByIdGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = new GetCharacterByIdFromApi(mapper, restTemplate);
        ReflectionTestUtils.setField(gateway,
                "externalRickAndMortyApiUrl",
                "https://rickandmortyapi.com/api/character/");
    }

    @Test
    void should_return_a_character_from_external_api() {
        Character characterEntityMock = CharacterMock.createACharacter();
        CharacterInput characterInputMock = CharacterInputMock.createACharacterMock();
        String restUrl = "https://rickandmortyapi.com/api/character/1";
        String expectedName = "Rick Sanchez";

        Mockito.when(restTemplate.getForObject(restUrl, CharacterInput.class))
                .thenReturn(characterInputMock);

        Mockito.when(mapper.convert(characterInputMock))
                .thenReturn(characterEntityMock);

        Character actual = gateway.get(1);

        Assertions.assertEquals(expectedName, actual.getName());
    }

    @Test
    void should_throw_Not_Found_Exception() {
        String restUrl = "https://rickandmortyapi.com/api/character/0";

        Mockito.when(restTemplate.getForObject(restUrl, CharacterInput.class))
                .thenThrow(HttpClientErrorException
                        .create(HttpStatus.NOT_FOUND,
                                "Not found",
                                null,
                                null,
                                null));

        Assertions.assertThrows(NotFoundException.class,
                () -> {
                    gateway.get(0);
                });
    }

    @Test
    void should_throws_Not_Handled_Exception() {
        String restUrl = "not an url";

        Mockito.when(restTemplate.getForObject(restUrl, CharacterInput.class))
                .thenThrow(HttpClientErrorException
                        .create(HttpStatus.INTERNAL_SERVER_ERROR,
                                "Not found",
                                null,
                                null,
                                null));

        Assertions.assertThrows(InternalErrorException.class,
                () -> {
                    gateway.get(1);
                });
    }
}