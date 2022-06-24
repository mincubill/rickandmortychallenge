package com.acubillos.rickandmortychallenge.core.usecase;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByIdGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByIdUseCase;

public class GetLocationByIdUseCaseImpl implements GetLocationByIdUseCase {

    private final GetLocationByIdGateway gateway;

    public GetLocationByIdUseCaseImpl(GetLocationByIdGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Location get(int id) {
        return gateway.get(id);
    }
}
