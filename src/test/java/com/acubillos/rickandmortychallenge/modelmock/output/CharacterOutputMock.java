package com.acubillos.rickandmortychallenge.modelmock.output;

import com.acubillos.rickandmortychallenge.openapi.model.CharactersOutput;

public class CharacterOutputMock {
    public static CharactersOutput createCharacter() {
        CharactersOutput output = new CharactersOutput();
        output.setId(1);
        output.setName("Rick Sanchez");
        output.setStatus("Alive");
        output.setSpecies("Human");
        output.setType("");
        output.setEpisodeCount(51);
        output.setOrigin(LocationOutputMock.createOrigin());
        return output;
    }
}
