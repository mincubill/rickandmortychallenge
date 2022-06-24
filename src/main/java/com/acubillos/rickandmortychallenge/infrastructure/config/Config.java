package com.acubillos.rickandmortychallenge.infrastructure.config;

import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetCharacterByIdGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByIdGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.gatewayinterfaces.GetLocationByUrlGateway;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetCharacterByIdUseCase;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByIdUseCase;
import com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces.GetLocationByUrlUseCase;
import com.acubillos.rickandmortychallenge.core.usecase.GetCharacterByIdUseCaseImpl;
import com.acubillos.rickandmortychallenge.core.usecase.GetLocationByIdUseCaseImpl;
import com.acubillos.rickandmortychallenge.core.usecase.GetLocationByUrlUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public GetCharacterByIdUseCase getCharacterByIdUseCase(GetCharacterByIdGateway gateway) {
        return new GetCharacterByIdUseCaseImpl(gateway);
    }

    @Bean
    public GetLocationByUrlUseCase getLocationByUrlUseCase(GetLocationByUrlGateway gateway) {
        return new GetLocationByUrlUseCaseImpl(gateway);
    }

    @Bean
    public GetLocationByIdUseCase getLocationByIdUseCase(GetLocationByIdGateway gateway) {
        return new GetLocationByIdUseCaseImpl(gateway);
    }


}
