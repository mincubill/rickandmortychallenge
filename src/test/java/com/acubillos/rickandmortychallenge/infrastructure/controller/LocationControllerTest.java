package com.acubillos.rickandmortychallenge.infrastructure.controller;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByIdUseCase;
import com.acubillos.rickandmortychallenge.infrastructure.controller.mapper.LocationEntityToLocationOutputEntityMapper;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InvalidIdException;
import com.acubillos.rickandmortychallenge.modelmock.entity.LocationMock;
import com.acubillos.rickandmortychallenge.modelmock.output.LocationOutputMock;
import com.acubillos.rickandmortychallenge.openapi.api.LocationsApi;
import com.acubillos.rickandmortychallenge.openapi.model.LocationOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class LocationControllerTest {

    @Mock
    private GetLocationByIdUseCase locationUseCase;
    @Mock
    private LocationEntityToLocationOutputEntityMapper mapper;

    private LocationsApi controller;

    @BeforeEach
    void setUp() {
        controller = new LocationController(locationUseCase, mapper);
    }

    @Test
    void should_return_a_location_output_from_controller() {
        String locationIdToGet = "1";
        String expectedName = "Earth (C-137)";
        Location entity = LocationMock.createOrigin();
        LocationOutput output = LocationOutputMock.createOrigin();

        Mockito.when(locationUseCase.get(Integer.parseInt(locationIdToGet)))
                .thenReturn(entity);

        Mockito.when(mapper.convert(entity))
                .thenReturn(output);

        ResponseEntity<LocationOutput> actual = controller.locationsIdGet(locationIdToGet);

        Assertions.assertEquals(actual.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(expectedName, actual.getBody().getName());
    }

    @Test
    void should_throw_invalid_id_exception() {
        String locationIdToGet = "a";

        Assertions.assertThrows(InvalidIdException.class,
                () -> {
                    controller.locationsIdGet(locationIdToGet);
                });
    }
}