package com.acubillos.rickandmortychallenge.modelmock.input;

import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.LocationInput;

import java.util.ArrayList;

public class LocationInputMock {
    public static LocationInput createsOrigin() {
        LocationInput input = new LocationInput();
        input.setId(1);
        input.setName("Earth (C-137)");
        input.setType("Planet");
        input.setDimension("Dimension C-137");
        input.setUrl("https://rickandmortyapi.com/api/location/1");
        input.setResidents(new ArrayList<>());
        input.setCreated("2017-11-10T12:42:04.162Z");
        return input;
    }

    public static LocationInput createsLocation() {
        LocationInput input = new LocationInput();
        input.setId(3);
        input.setName("Citadel of Ricks");
        input.setType("Space station");
        input.setDimension("unknown");
        input.setUrl("https://rickandmortyapi.com/api/location/3");
        input.setResidents(new ArrayList<>());
        input.setCreated("2017-11-10T13:08:13.191Z");
        return input;
    }
}
