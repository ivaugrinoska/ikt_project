package com.example.ikt_project.model.dto;

import lombok.Data;

@Data
public class QuizDto {

    String title;
    String description;

    public QuizDto(){}

    public QuizDto(String title, String description){
        this.title = title;
        this.description = description;
    }

}
