package com.acubillos.rickandmortychallenge.modelmock.output;

import com.acubillos.rickandmortychallenge.openapi.model.LocationOutput;

import java.util.ArrayList;

public class LocationOutputMock {
    public static LocationOutput createOrigin() {
        LocationOutput output = new LocationOutput();
        output.setName("Earth (C-137)");
        output.setUrl("https://rickandmortyapi.com/api/location/1");
        output.setDimension("Dimension C-137");
        output.setResidents(new ArrayList<>());
        return output;
    }
}
