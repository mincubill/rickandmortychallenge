package com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.CharacterInput;
import com.acubillos.rickandmortychallenge.modelmock.input.CharacterInputMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CharacterInputToCharacterEntityMapperTest {

    private CharacterInputToCharacterEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new CharacterInputToCharacterEntityMapper();
    }

    @Test
    void should_return_a_character_entity_from_input() {
        String expectedName = "Rick Sanchez";
        CharacterInput input = CharacterInputMock.createACharacterMock();

        Character actual = mapper.convert(input);

        Assertions.assertEquals(expectedName, actual.getName());
    }
}