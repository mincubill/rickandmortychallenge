package com.acubillos.rickandmortychallenge.core.usecase;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByIdGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByIdUseCase;
import com.acubillos.rickandmortychallenge.modelmock.entity.LocationMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetLocationByIdUseCaseImplTest {

    @Mock
    private GetLocationByIdGateway locationGateway;

    private GetLocationByIdUseCase locationUseCase;

    @BeforeEach
    void setUp() {
        locationUseCase = new GetLocationByIdUseCaseImpl(locationGateway);
    }

    @Test
    void should_return_a_location() {
        String expectedLocationName = "Earth (C-137)";
        Location locationMock = LocationMock.createOrigin();

        Mockito.when(locationGateway.get(1))
                .thenReturn(locationMock);

        Location actual = locationUseCase.get(1);

        Assertions.assertEquals(expectedLocationName, actual.getName());
    }
}