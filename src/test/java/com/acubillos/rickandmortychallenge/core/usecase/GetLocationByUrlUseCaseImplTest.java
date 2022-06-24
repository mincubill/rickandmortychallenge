package com.acubillos.rickandmortychallenge.core.usecase;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByUrlGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByUrlUseCase;
import com.acubillos.rickandmortychallenge.modelmock.entity.LocationMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetLocationByUrlUseCaseImplTest {
    @Mock
    private GetLocationByUrlGateway locationGateway;

    private GetLocationByUrlUseCase locationUseCase;

    @BeforeEach
    void setUp() {
        locationUseCase = new GetLocationByUrlUseCaseImpl(locationGateway);
    }

    @Test
    void should_return_a_location() {
        String expectedLocationName = "Earth (C-137)";
        String restUrl = "https://rickandmortyapi.com/api/location/1";
        Location locationMock = LocationMock.createOrigin();


        Mockito.when(locationGateway.get(restUrl))
                .thenReturn(locationMock);

        Location actual = locationUseCase.get(restUrl);

        Assertions.assertEquals(expectedLocationName, actual.getName());
    }

}