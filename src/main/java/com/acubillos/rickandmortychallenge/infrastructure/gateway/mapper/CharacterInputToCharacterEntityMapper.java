package com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.CharacterInput;
import org.springframework.stereotype.Component;

@Component
public class CharacterInputToCharacterEntityMapper {
    public Character convert(CharacterInput input) {
        return new Character(
                input.getId(),
                input.getName(),
                input.getStatus(),
                input.getSpecies(),
                input.getType(),
                input.getGender(),
                input.getEpisode(),
                new Location(
                        input.getOrigin().getId(),
                        input.getOrigin().getName(),
                        input.getOrigin().getType(),
                        input.getOrigin().getDimension(),
                        input.getOrigin().getUrl(),
                        input.getOrigin().getResidents()

                ),
                new Location(
                        input.getLocation().getId(),
                        input.getLocation().getName(),
                        input.getLocation().getType(),
                        input.getLocation().getDimension(),
                        input.getLocation().getUrl(),
                        input.getLocation().getResidents()
                )
        );
    }

}
