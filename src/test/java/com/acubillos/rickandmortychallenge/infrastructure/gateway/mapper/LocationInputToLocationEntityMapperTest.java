package com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.LocationInput;
import com.acubillos.rickandmortychallenge.modelmock.input.LocationInputMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LocationInputToLocationEntityMapperTest {

    LocationInputToLocationEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new LocationInputToLocationEntityMapper();
    }

    @Test
    void should_return_a_location_entity_from_input() {
        String expectedName = "Earth (C-137)";
        LocationInput input = LocationInputMock.createsOrigin();

        Location actual = mapper.convert(input);

        Assertions.assertEquals(expectedName, actual.getName());

    }

}