package com.acubillos.rickandmortychallenge.infrastructure.controller.mapper;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.modelmock.entity.LocationMock;
import com.acubillos.rickandmortychallenge.openapi.model.LocationOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LocationEntityToLocationOutputEntityMapperTest {

    private LocationEntityToLocationOutputEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new LocationEntityToLocationOutputEntityMapper();
    }

    @Test
    void should_return_a_location_output_from_entity() {
        String expectedName = "Earth (C-137)";
        Location entity = LocationMock.createOrigin();

        LocationOutput actual = mapper.convert(entity);

        Assertions.assertEquals(expectedName, actual.getName());
    }
}