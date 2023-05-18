package com.example.ikt_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserTakesQuizException extends RuntimeException{

    public UserTakesQuizException(Long id) {
        super(String.format("UserTakesQuiz with id: %d was not found", id));
    }
}
