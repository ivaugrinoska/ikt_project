package com.example.ikt_project.service;

import com.example.ikt_project.model.Question;
import com.example.ikt_project.model.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();

    Optional<Question> save(QuestionDto questionDto);

    Optional<Question> findById(Long id);

    Optional<Question> edit(Long id, QuestionDto questionDto);

    void deleteById(Long id);

    List<Question> getAllByQuizId(Long quizId);
}
