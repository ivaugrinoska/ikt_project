package com.example.ikt_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException()  {
        super("Invalid credentials exception");
    }
}
