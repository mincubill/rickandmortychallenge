package com.acubillos.rickandmortychallenge.infrastructure.controller;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByIdUseCase;
import com.acubillos.rickandmortychallenge.infrastructure.controller.mapper.LocationEntityToLocationOutputEntityMapper;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InvalidIdException;
import com.acubillos.rickandmortychallenge.openapi.api.LocationsApi;
import com.acubillos.rickandmortychallenge.openapi.model.LocationOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController implements LocationsApi {

    private final GetLocationByIdUseCase locationUseCase;
    private final LocationEntityToLocationOutputEntityMapper mapper;

    public LocationController(GetLocationByIdUseCase locationUseCase, LocationEntityToLocationOutputEntityMapper mapper) {
        this.locationUseCase = locationUseCase;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<LocationOutput> locationsIdGet(String id) {
        try {
            Location location = locationUseCase.get(Integer.parseInt(id));
            return ResponseEntity.ok(mapper.convert(location));
        } catch (NumberFormatException ex) {
            throw new InvalidIdException("The ID must be numeric");
        }
    }
}
