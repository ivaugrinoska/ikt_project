package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.UserTakesQuiz;
import com.example.ikt_project.model.dto.AnswerDto;
import com.example.ikt_project.model.exceptions.AnswerNotFoundException;
import com.example.ikt_project.repository.AnswerRepository;
import com.example.ikt_project.repository.QuestionRepository;
import com.example.ikt_project.repository.UserTakesQuizRepository;
import com.example.ikt_project.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserTakesQuizRepository userTakesQuizRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository, UserTakesQuizRepository userTakesQuizRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userTakesQuizRepository = userTakesQuizRepository;
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

    @Override
    public Optional<Answer> createAnswer(AnswerDto answerDto) {
        Answer newAnswer = new Answer(answerDto.getContent(), questionRepository.findById(answerDto.getQuestionId()).get(),
                answerDto.is_correct());
        this.answerRepository.save(newAnswer);
        return Optional.of(newAnswer);
    }

    @Override
    public Optional<Answer> editAnswer(long id, AnswerDto answerDto) {
        Answer answer = this.answerRepository.findById(id).orElseThrow(() -> new AnswerNotFoundException(id));
        answer.setContent(answerDto.getContent());
        answer.set_correct(answerDto.is_correct());
        this.answerRepository.save(answer);
        return Optional.of(answer);
    }

    @Override
    public Optional<UserTakesQuiz> getResult(Long quizId, Long userId, List<Long> answerIds) {
        int result = 0;

        for (Answer answer : this.answerRepository.findAllById(answerIds)) {
            if (answer.is_correct())
                result += 1;
        }

        UserTakesQuiz userTakesQuiz = this.userTakesQuizRepository.findByQuizIdAndUserId(quizId, userId);

        userTakesQuiz.setResult(result);
        this.userTakesQuizRepository.save(userTakesQuiz);

        return Optional.of(userTakesQuiz);
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(Long id) {
        return answerRepository.findAllByQuestionId(id);
    }

}
