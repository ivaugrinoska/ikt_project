package com.example.ikt_project.service;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.dto.AnswerDto;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<Answer> findAll();
    Optional<Answer> findById(Long id);
    void deleteById(Long id);

    Optional<Answer> createAnswer(AnswerDto answerDto);
    Optional<Answer> editAnswer(long id, AnswerDto answerDto);
    //Optional<Question> addAnswerToQuestion(Long questionId, List<AddAnswerDto> answerIds);
}
