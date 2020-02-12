package com.wpproject.theater.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidShowNameException extends RuntimeException {
    public InvalidShowNameException(){
        super(InvalidShowNameException.class.getSimpleName());
    }
}
