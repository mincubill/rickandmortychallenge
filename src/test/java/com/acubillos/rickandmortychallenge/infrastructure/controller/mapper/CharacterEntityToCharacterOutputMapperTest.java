package com.acubillos.rickandmortychallenge.infrastructure.controller.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.modelmock.entity.CharacterMock;
import com.acubillos.rickandmortychallenge.openapi.model.CharactersOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharacterEntityToCharacterOutputMapperTest {

    private CharacterEntityToCharacterOutputMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new CharacterEntityToCharacterOutputMapper();
    }

    @Test
    void should_return_a_character_output_from_entity() {
        String expectedName = "Rick Sanchez";
        Character entity = CharacterMock.createACharacter();

        CharactersOutput actual = mapper.convert(entity);

        Assertions.assertEquals(expectedName, actual.getName());

    }
}