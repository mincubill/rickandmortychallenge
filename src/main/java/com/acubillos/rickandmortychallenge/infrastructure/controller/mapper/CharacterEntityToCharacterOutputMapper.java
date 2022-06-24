package com.acubillos.rickandmortychallenge.infrastructure.controller.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.openapi.model.CharactersOutput;
import org.springframework.stereotype.Component;

@Component
public class CharacterEntityToCharacterOutputMapper {
    public CharactersOutput convert(Character input) {
        CharactersOutput output = new CharactersOutput();
        output.setId(input.getId());
        output.setName(input.getName());
        output.setStatus(input.getStatus());
        output.setSpecies(input.getSpecies());
        output.setType(input.getType());
        output.setEpisodeCount(input.getEpisodeCount().size());
        output.setOrigin(new LocationEntityToLocationOutputEntityMapper().convert(input.getOrigin()));
        return output;
    }
}
