package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class UserTakesQuizDto {
    Long quizId;
    Long userId;

    public UserTakesQuizDto() {
    }

    public UserTakesQuizDto(Long quizId, Long userId) {
        this.quizId = quizId;
        this.userId = userId;
    }

}
