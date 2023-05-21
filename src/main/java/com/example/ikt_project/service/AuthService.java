package com.example.ikt_project.service;

import com.example.ikt_project.model.User;
import com.example.ikt_project.model.enumerations.Role;

public interface AuthService {

    User login(String username, String password);

    User register(String email, String username, String password, String repeatPassword, String name, String surname, Role role);

    User editProfile(String username, String name, String surname);
}
