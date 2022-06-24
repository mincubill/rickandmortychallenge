package com.acubillos.rickandmortychallenge.core.usecase;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetCharacterByIdGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetCharacterByIdUseCase;

public class GetCharacterByIdUseCaseImpl implements GetCharacterByIdUseCase {

    private final GetCharacterByIdGateway gateway;

    public GetCharacterByIdUseCaseImpl(GetCharacterByIdGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Character get(int id) {
        return gateway.get(id);
    }
}
