package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class AddAnswerDto {
    Long id;

    public AddAnswerDto() {}

    public AddAnswerDto(Long id) {
        this.id = id;
    }
}
