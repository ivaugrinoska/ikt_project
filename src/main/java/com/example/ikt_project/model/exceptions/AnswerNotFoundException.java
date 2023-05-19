package com.example.ikt_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnswerNotFoundException extends RuntimeException{
    public AnswerNotFoundException(Long id) {
        super(String.format("Answer with id: %d was " +
                "not found", id));
    }
}
