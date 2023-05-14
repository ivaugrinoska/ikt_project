package com.example.ikt_project.repository;

import com.example.ikt_project.model.UserTakesQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTakesQuizRepository extends JpaRepository<UserTakesQuiz, Long> {
}
