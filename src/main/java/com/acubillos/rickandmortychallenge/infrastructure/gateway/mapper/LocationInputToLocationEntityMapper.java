package com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.LocationInput;
import org.springframework.stereotype.Component;

@Component
public class LocationInputToLocationEntityMapper {
    public Location convert(LocationInput input) {
        return new Location(
                input.getId(),
                input.getName(),
                input.getType(),
                input.getDimension(),
                input.getUrl(),
                input.getResidents()
        );
    }

}
