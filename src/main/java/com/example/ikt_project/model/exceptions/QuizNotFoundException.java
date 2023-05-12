package com.example.ikt_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuizNotFoundException extends RuntimeException{
    public QuizNotFoundException(Long id) {
        super(String.format("Quiz with id: %d was " + "not found", id));
    }
}
