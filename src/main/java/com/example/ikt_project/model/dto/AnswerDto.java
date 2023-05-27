package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private String content;
    private boolean is_correct;

    private Long questionId;

    public AnswerDto() {
    }

    public AnswerDto(String content, Long questionId, boolean is_correct) {
        this.content = content;
        this.questionId = questionId;
        this.is_correct = is_correct;
    }
}
