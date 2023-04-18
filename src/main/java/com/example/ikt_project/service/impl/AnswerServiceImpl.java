package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.repository.AnswerRepository;
import com.example.ikt_project.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> findAll() {
        return this.answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return this.answerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.answerRepository.deleteById(id);
    }
}
