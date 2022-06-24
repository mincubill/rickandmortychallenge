package com.acubillos.rickandmortychallenge.infrastructure.controller;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetCharacterByIdUseCase;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByUrlUseCase;
import com.acubillos.rickandmortychallenge.infrastructure.controller.mapper.CharacterEntityToCharacterOutputMapper;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InvalidIdException;
import com.acubillos.rickandmortychallenge.openapi.api.CharactersApi;
import com.acubillos.rickandmortychallenge.openapi.model.CharactersOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController implements CharactersApi {

    private final GetCharacterByIdUseCase characterUseCase;
    private final GetLocationByUrlUseCase locationUseCase;
    private final CharacterEntityToCharacterOutputMapper characterMapper;

    public CharacterController(GetCharacterByIdUseCase characterUseCase, GetLocationByUrlUseCase locationUseCase, CharacterEntityToCharacterOutputMapper characterMapper) {
        this.characterUseCase = characterUseCase;
        this.locationUseCase = locationUseCase;
        this.characterMapper = characterMapper;
    }

    @Override
    public ResponseEntity<CharactersOutput> charactersIdGet(String id) {
        try {
            Character character = characterUseCase.get(Integer.parseInt(id));
            Location origin = locationUseCase.get(character.getOrigin().getUrl());
            character.setOrigin(origin);
            return ResponseEntity.ok(characterMapper.convert(character));
        } catch (NumberFormatException ex) {
            throw new InvalidIdException("The ID must be numeric");
        }
    }
}
