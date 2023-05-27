package com.example.ikt_project.web;

import com.example.ikt_project.model.User;
import com.example.ikt_project.model.dto.RegisterRequestDto;
import com.example.ikt_project.model.enumerations.Role;
import com.example.ikt_project.model.exceptions.InvalidArgumentsException;
import com.example.ikt_project.model.exceptions.InvalidUserCredentialsException;
import com.example.ikt_project.model.exceptions.PasswordsDoNotMatchException;
import com.example.ikt_project.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDto registerUserDto) {
        try {
            authService.register(registerUserDto.getEmail(), registerUserDto.getUsername(), registerUserDto.getPassword(), registerUserDto.getRepeatPassword(), registerUserDto.getName(), registerUserDto.getSurname(), Role.ROLE_USER);
            return ResponseEntity.status(HttpStatus.CREATED).body("User has been created");
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password,
                                        HttpServletRequest request) {
        User user;
        try {
            user = this.authService.login(username, password);
            request.getSession().setAttribute("user", user);
            return ResponseEntity.ok("Successfully logged in!");
        } catch (InvalidUserCredentialsException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }

    @GetMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok("Successfully logged out!");
    }
}
