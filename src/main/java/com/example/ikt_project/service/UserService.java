package com.example.ikt_project.service;

import com.example.ikt_project.model.User;
import com.example.ikt_project.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User findUserByUsername(String username);
}