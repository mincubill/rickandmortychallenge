package com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces;

import com.acubillos.rickandmortychallenge.core.entity.Location;

public interface GetLocationByUrlGateway {
    Location get(String url);
}
