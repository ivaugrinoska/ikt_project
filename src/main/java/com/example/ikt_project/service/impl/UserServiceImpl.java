package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.User;
import com.example.ikt_project.model.enumerations.Role;
import com.example.ikt_project.model.exceptions.InvalidArgumentsException;
import com.example.ikt_project.model.exceptions.PasswordsDoNotMatchException;
import com.example.ikt_project.model.exceptions.UsernameAlreadyExistsException;
import com.example.ikt_project.repository.UserRepository;
import com.example.ikt_project.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
