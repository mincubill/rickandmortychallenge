package com.acubillos.rickandmortychallenge.infrastructure.gateway;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByUrlGateway;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InternalErrorException;
import com.acubillos.rickandmortychallenge.infrastructure.exception.NotFoundException;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper.LocationInputToLocationEntityMapper;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.LocationInput;
import com.acubillos.rickandmortychallenge.modelmock.entity.LocationMock;
import com.acubillos.rickandmortychallenge.modelmock.input.LocationInputMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class GetLocationByUrlFromApiTest {

    @Mock
    private LocationInputToLocationEntityMapper mapper;
    @Mock
    private RestTemplate restTemplate;

    GetLocationByUrlGateway locationGateway;

    @BeforeEach
    void setUp() {
        locationGateway = new GetLocationByUrlFromApi(mapper, restTemplate);
    }

    @Test
    void should_return_a_location_from_external_api() {
        String expectedName = "Citadel of Ricks";
        String restUrl = "https://rickandmortyapi.com/api/Location/1";
        LocationInput inputMock = LocationInputMock.createsLocation();
        Location locationMock = LocationMock.createLocation();

        Mockito.when(restTemplate.getForObject(restUrl, LocationInput.class))
                .thenReturn(inputMock);

        Mockito.when(mapper.convert(inputMock))
                .thenReturn(locationMock);

        Location actual = locationGateway.get(restUrl);

        Assertions.assertEquals(expectedName, actual.getName());

    }

    @Test
    void should_return_an_empty_location_from_external_api() {
        String expectedName = "";
        String restUrl = "";

        Location actual = locationGateway.get(restUrl);

        Assertions.assertEquals(expectedName, actual.getName());

    }

    @Test
    void should_throw_Not_Found_Exception() {
        String restUrl = "https://rickandmortyapi.com/api/location/0";

        Mockito.when(restTemplate.getForObject(restUrl, LocationInput.class))
                .thenThrow(HttpClientErrorException
                        .create(HttpStatus.NOT_FOUND,
                                "Not found",
                                null,
                                null,
                                null));

        Assertions.assertThrows(NotFoundException.class,
                () -> {
                    locationGateway.get(restUrl);
                });
    }

    @Test
    void should_throws_Not_Handled_Exception() {
        String restUrl = "not an url";

        Mockito.when(restTemplate.getForObject(restUrl, LocationInput.class))
                .thenThrow(HttpClientErrorException
                        .create(HttpStatus.INTERNAL_SERVER_ERROR,
                                "Not found",
                                null,
                                null,
                                null));

        Assertions.assertThrows(InternalErrorException.class,
                () -> {
                    locationGateway.get(restUrl);
                });
    }

}