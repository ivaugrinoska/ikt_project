package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class QuestionDto {
    String content;

    public QuestionDto() {}

    public QuestionDto(String content) {
        this.content = content;
    }
}
