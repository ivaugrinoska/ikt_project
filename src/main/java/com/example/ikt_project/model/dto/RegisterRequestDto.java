package com.example.ikt_project.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegisterRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z]{2,}$")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z]{2,}$")
    private String surname;

    @NotEmpty
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;
}

