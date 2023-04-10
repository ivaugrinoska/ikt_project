package com.example.ikt_project.model.dto;

import com.example.ikt_project.model.enumerations.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {

    private UserDto userDto;

    private Role role;
}
