package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.User;
import com.example.ikt_project.model.enumerations.Role;
import com.example.ikt_project.model.exceptions.*;
import com.example.ikt_project.repository.UserRepository;
import com.example.ikt_project.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        User user = userRepository.findByUsername(username).orElseThrow(InvalidUserCredentialsException::new);
        if(user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new InvalidUserCredentialsException();
    }

    @Override
    public User register(String email, String username, String password, String repeatPassword, String name, String surname, Role userRole) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidArgumentsException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(email, username, passwordEncoder.encode(password), name, surname, userRole);
        return userRepository.save(user);
    }

    @Override
    public User editProfile(String username, String name, String surname) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        user.setName(name);
        user.setSurname(surname);

        return userRepository.save(user);
    }
}