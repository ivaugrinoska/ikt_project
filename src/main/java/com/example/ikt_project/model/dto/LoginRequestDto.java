package com.example.ikt_project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginRequestDto {

    private String username;

    private String password;
}
