package com.acubillos.rickandmortychallenge.core.usecase;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByUrlGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByUrlUseCase;


public class GetLocationByUrlUseCaseImpl implements GetLocationByUrlUseCase {

    private final GetLocationByUrlGateway gateway;

    public GetLocationByUrlUseCaseImpl(GetLocationByUrlGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Location get(String url) {
        return gateway.get(url);
    }
}
