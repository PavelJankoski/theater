package com.wpproject.theater.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidUserIdException extends RuntimeException{
    public InvalidUserIdException(){
        super(InvalidUserIdException.class.getSimpleName());
    }

}
