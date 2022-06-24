package com.acubillos.rickandmortychallenge.infrastructure.gateway;

import com.acubillos.rickandmortychallenge.core.entity.Location;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByUrlGateway;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InternalErrorException;
import com.acubillos.rickandmortychallenge.infrastructure.exception.NotFoundException;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper.LocationInputToLocationEntityMapper;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.LocationInput;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class GetLocationByUrlFromApi implements GetLocationByUrlGateway {

    private final LocationInputToLocationEntityMapper mapper;
    private final RestTemplate restTemplate;

    public GetLocationByUrlFromApi(LocationInputToLocationEntityMapper mapper, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public Location get(String url) {
        try {
            if (url.equals("") || url == null) {
                return new Location(0, "", "", "", "", new ArrayList<String>());
            }
            LocationInput input = restTemplate.getForObject(url, LocationInput.class);
            return mapper.convert(input);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException("Location not found");
        } catch (Exception ex) {
            throw new InternalErrorException("Whoops, idk u tell me - " + ex.getMessage());
        }
    }

}
