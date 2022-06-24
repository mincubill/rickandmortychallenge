package com.acubillos.rickandmortychallenge.infrastructure.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }
}
