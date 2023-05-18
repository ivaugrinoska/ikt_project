package com.example.ikt_project.repository;

import com.example.ikt_project.model.UserTakesQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTakesQuizRepository extends JpaRepository<UserTakesQuiz, Long> {

    List<UserTakesQuiz> findByUserId(Long userId);

    List<UserTakesQuiz> findByQuizId(Long quizId);

    List<UserTakesQuiz> findByResult(int result);

}
