package com.acubillos.rickandmortychallenge.infrastructure.controller;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetCharacterByIdUseCase;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByUrlUseCase;
import com.acubillos.rickandmortychallenge.infrastructure.controller.mapper.CharacterEntityToCharacterOutputMapper;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InvalidIdException;
import com.acubillos.rickandmortychallenge.modelmock.entity.CharacterMock;
import com.acubillos.rickandmortychallenge.modelmock.entity.LocationMock;
import com.acubillos.rickandmortychallenge.modelmock.output.CharacterOutputMock;
import com.acubillos.rickandmortychallenge.openapi.api.CharactersApi;
import com.acubillos.rickandmortychallenge.openapi.model.CharactersOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
class CharacterControllerTest {
    @Mock
    private GetCharacterByIdUseCase characterUseCase;
    @Mock
    private GetLocationByUrlUseCase locationUseCase;
    @Mock
    private CharacterEntityToCharacterOutputMapper mapper;

    private CharactersApi controller;

    @BeforeEach
    void setUp(){
        controller = new CharacterController(characterUseCase, locationUseCase, mapper);
    }

    @Test
    void should_return_a_character_output_from_controller(){
        String characterIdToGet = "1";
        String expectedName = "Rick Sanchez";
        Character characterEntity = CharacterMock.createACharacter();
        Location locationEntity = LocationMock.createOrigin();
        CharactersOutput characterOutput = CharacterOutputMock.createCharacter();
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(characterUseCase.get(Integer.parseInt(characterIdToGet)))
                .thenReturn(characterEntity);

        Mockito.when(locationUseCase.get(characterEntity.getOrigin().getUrl()))
                .thenReturn(locationEntity);

        Mockito.when(mapper.convert(characterEntity))
                .thenReturn(characterOutput);

        ResponseEntity<CharactersOutput> actual = controller.charactersIdGet(characterIdToGet);

        Assertions.assertEquals(actual.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(expectedName, actual.getBody().getName());
    }

    @Test
    void should_throw_invalid_id_exception(){
        String characterIdToGet = "a";

        Assertions.assertThrows(InvalidIdException.class,
                () -> {
                    controller.charactersIdGet(characterIdToGet);
                });
    }

}