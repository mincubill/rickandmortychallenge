package com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces;

import com.acubillos.rickandmortychallenge.core.entity.Character;

public interface GetCharacterByIdGateway {
    Character get(int id);
}
