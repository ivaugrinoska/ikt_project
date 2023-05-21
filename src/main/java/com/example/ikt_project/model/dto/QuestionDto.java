package com.example.ikt_project.model.dto;

import com.example.ikt_project.model.Quiz;
import lombok.Data;

@Data
public class QuestionDto {
    String content;

    Long quizId;

    public QuestionDto() {}

    public QuestionDto(String content, Long quizId) {
        this.content = content;
        this.quizId = quizId;
    }
}
