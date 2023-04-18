package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private String content;
    private boolean is_correct;

    public AnswerDto() {
    }

    public AnswerDto(String content, boolean is_correct) {
        this.content = content;
        this.is_correct = is_correct;
    }
}
