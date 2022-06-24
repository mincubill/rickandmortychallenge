package com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces;

import com.acubillos.rickandmortychallenge.core.entity.Character;

public interface GetCharacterByIdUseCase {
    Character get(int id);
}
