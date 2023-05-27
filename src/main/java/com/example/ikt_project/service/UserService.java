package com.example.ikt_project.service;

import com.example.ikt_project.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User findUserByUsername(String username);
}