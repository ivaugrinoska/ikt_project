package com.example.ikt_project.service;

import com.example.ikt_project.model.UserTakesQuiz;
import com.example.ikt_project.model.dto.UserTakesQuizDto;

import java.util.List;
import java.util.Optional;

public interface UserTakesQuizService {
    List<UserTakesQuiz> findAll();

    Optional<UserTakesQuiz> save(UserTakesQuizDto userTakesQuizDto);

    List<UserTakesQuiz> findAllByUser(Long userId);

    List<UserTakesQuiz> findAllByQuiz(Long quizId);

    List<UserTakesQuiz> findAllByResult(int result);

    Optional<UserTakesQuiz> findById(Long id);

}
