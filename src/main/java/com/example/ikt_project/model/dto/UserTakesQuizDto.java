package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class UserTakesQuizDto {
    Long quizId;
    Long user_iktId;
    int result;

    public UserTakesQuizDto() {}

    public UserTakesQuizDto(Long quizId, Long user_iktId, int result) {
        this.quizId = quizId;
        this.user_iktId = user_iktId;
        this.result = result;
    }

}
