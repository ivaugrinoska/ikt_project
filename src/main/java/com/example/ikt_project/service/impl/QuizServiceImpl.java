package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.Quiz;
import com.example.ikt_project.model.dto.QuizDto;
import com.example.ikt_project.model.exceptions.QuizNotFoundException;
import com.example.ikt_project.repository.QuestionRepository;
import com.example.ikt_project.repository.QuizRepository;
import com.example.ikt_project.repository.UserRepository;
import com.example.ikt_project.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public QuizServiceImpl(QuizRepository quizRepository, UserRepository userRepository,
                           QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Quiz> createQuiz(QuizDto quizDto) {
        Quiz quiz = new Quiz(quizDto.getTitle(), quizDto.getDescription());

        this.quizRepository.save(quiz);

        return Optional.of(quiz);
    }

    @Override
    public Optional<Quiz> editQuiz(Long id, QuizDto quizDto) {
        Quiz quiz = this.quizRepository.findById(id).orElseThrow(() -> new QuizNotFoundException(id));

        quiz.setTitle(quizDto.getTitle());
        quiz.setDescription(quizDto.getDescription());

        this.quizRepository.save(quiz);

        return Optional.of(quiz);
    }

    @Override
    public void deleteQuiz(Long id) {
        this.quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> findAllQuizzes() {
        return this.quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> findQuizById(Long id) {
        return this.quizRepository.findById(id);
    }

}
