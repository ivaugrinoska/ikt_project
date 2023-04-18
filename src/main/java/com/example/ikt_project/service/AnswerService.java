package com.example.ikt_project.service;

import com.example.ikt_project.model.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<Answer> findAll();
    Optional<Answer> findById(Long id);
    void deleteById(Long id);
}
