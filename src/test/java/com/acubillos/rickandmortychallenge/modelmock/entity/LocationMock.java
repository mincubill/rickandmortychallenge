package com.acubillos.rickandmortychallenge.modelmock.entity;

import com.acubillos.rickandmortychallenge.core.entity.Location;

import java.util.ArrayList;

public class LocationMock {
    public static Location createOrigin() {
        return new Location(
                1,
                "Earth (C-137)",
                "Planet",
                "Dimension C-137",
                "https://rickandmortyapi.com/api/location/1",
                new ArrayList<>()
        );
    }

    public static Location createLocation() {
        return new Location(
                3,
                "Citadel of Ricks",
                "Space station",
                "unknown",
                "https://rickandmortyapi.com/api/location/3",
                new ArrayList<>()
        );
    }

    public static Location createEmptyLocation() {
        return new Location(
                0,
                "",
                "",
                "",
                "",
                new ArrayList<>()
        );
    }
}
