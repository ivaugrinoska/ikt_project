package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.Question;
import com.example.ikt_project.model.dto.QuestionDto;
import com.example.ikt_project.model.exceptions.QuestionNotFoundException;
import com.example.ikt_project.repository.QuestionRepository;
import com.example.ikt_project.repository.QuizRepository;
import com.example.ikt_project.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Question> findAll() {
        return this.questionRepository.findAll();
    }

    @Override
    public Optional<Question> save(QuestionDto questionDto) {
        Question question = new Question(questionDto.getContent(), quizRepository.findById(questionDto.getQuizId()).get());

        this.questionRepository.save(question);

        return Optional.of(question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return this.questionRepository.findById(id);
    }

    @Override
    public Optional<Question> edit(Long id, QuestionDto questionDto) {
        Question question = this.questionRepository.findById(id).orElseThrow(() ->
                new QuestionNotFoundException(id));

        question.setContent(questionDto.getContent());

        this.questionRepository.save(question);
        return Optional.of(question);
    }

    @Override
    public void deleteById(Long id) {
        this.questionRepository.deleteById(id);
    }

}
