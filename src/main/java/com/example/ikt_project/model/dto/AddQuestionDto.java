package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class AddQuestionDto {
    Long id;

    public AddQuestionDto() {}

    public AddQuestionDto(Long id) {
        this.id = id;
    }
}
