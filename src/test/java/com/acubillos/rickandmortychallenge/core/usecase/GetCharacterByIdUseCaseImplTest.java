package com.acubillos.rickandmortychallenge.core.usecase;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetCharacterByIdGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetCharacterByIdUseCase;
import com.acubillos.rickandmortychallenge.modelmock.entity.CharacterMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetCharacterByIdUseCaseImplTest {
    @Mock
    private GetCharacterByIdGateway characterGateway;

    private GetCharacterByIdUseCase characterUseCase;

    @BeforeEach
    void setUp() {
        characterUseCase = new GetCharacterByIdUseCaseImpl(characterGateway);
    }

    @Test
    void should_return_a_character() {
        String expectedName = "Rick Sanchez";
        Character characterMock = CharacterMock.createACharacter();

        Mockito.when(characterGateway.get(1))
                .thenReturn(characterMock);

        Character actual = characterUseCase.get(1);

        Assertions.assertEquals(expectedName, actual.getName());
    }

}