package com.acubillos.rickandmortychallenge.infrastructure.controller.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.openapi.model.LocationOutput;
import org.springframework.stereotype.Component;

@Component
public class LocationEntityToLocationOutputEntityMapper {
    public LocationOutput convert(Location input) {
        LocationOutput output = new LocationOutput();
        output.setName(input.getName());
        output.setUrl(input.getUrl());
        output.dimension(input.getDimension());
        output.setResidents(input.getResidents());
        return output;
    }
}
