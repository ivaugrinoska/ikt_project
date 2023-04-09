package com.example.ikt_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ikt_project.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    User findUserByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
