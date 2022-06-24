package com.acubillos.rickandmortychallenge.infrastructure.gateway;

import com.acubillos.rickandmortychallenge.core.entity.Character;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetCharacterByIdGateway;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InternalErrorException;
import com.acubillos.rickandmortychallenge.infrastructure.exception.NotFoundException;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.mapper.CharacterInputToCharacterEntityMapper;
import com.acubillos.rickandmortychallenge.infrastructure.gateway.model.CharacterInput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class GetCharacterByIdFromApi implements GetCharacterByIdGateway {

    @Value("${externalRickAndMortyApiUrlCharacter}")
    private String externalRickAndMortyApiUrl;
    private final CharacterInputToCharacterEntityMapper mapper;
    private final RestTemplate restTemplate;

    public GetCharacterByIdFromApi(CharacterInputToCharacterEntityMapper mapper, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public Character get(int id) {
        try {
            String url = externalRickAndMortyApiUrl.concat(String.valueOf(id));
            CharacterInput input = restTemplate.getForObject(url, CharacterInput.class);
            return mapper.convert(input);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException("Character not found");
        } catch (Exception ex) {
            throw new InternalErrorException("Whoops, idk u tell me - " + ex.getMessage());
        }
    }
}
