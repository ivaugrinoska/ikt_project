package com.example.ikt_project.service;

import com.example.ikt_project.model.Quiz;
import com.example.ikt_project.model.dto.QuizDto;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    Optional<Quiz> createQuiz(QuizDto quizDto);

    Optional<Quiz> editQuiz(Long id, QuizDto quizDto);

    void deleteQuiz(Long id);

    List<Quiz> findAllQuizzes();

    Optional<Quiz> findQuizById(Long id);

}
