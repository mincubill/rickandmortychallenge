package com.acubillos.rickandmortychallenge.infrastructure.controller.exception;

import com.acubillos.rickandmortychallenge.infrastructure.exception.InternalErrorException;
import com.acubillos.rickandmortychallenge.infrastructure.exception.InvalidIdException;
import com.acubillos.rickandmortychallenge.infrastructure.exception.NotFoundException;
import com.acubillos.rickandmortychallenge.openapi.model.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Errors> errorHandler(NotFoundException exception) {
        return new ResponseEntity<>(new Errors().message(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<Errors> errorHandler(InvalidIdException exception) {
        return new ResponseEntity<>(new Errors().message(exception.getMessage()), HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<Errors> errorHandler(InternalErrorException exception) {
        return new ResponseEntity<>(new Errors().message(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
