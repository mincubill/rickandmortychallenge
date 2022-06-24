package com.acubillos.rickandmortychallenge.core.interfaces.usecaseinterfaces;

import com.acubillos.rickandmortychallenge.core.entity.Location;

public interface GetLocationByUrlUseCase {
    Location get(String url);
}
