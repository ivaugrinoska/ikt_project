package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.UserTakesQuiz;
import com.example.ikt_project.model.dto.UserTakesQuizDto;
import com.example.ikt_project.model.exceptions.UserTakesQuizException;
import com.example.ikt_project.repository.UserTakesQuizRepository;
import com.example.ikt_project.service.UserTakesQuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTakesQuizServiceImpl implements UserTakesQuizService {

    private final UserTakesQuizRepository userTakesQuizRepository;

    public UserTakesQuizServiceImpl(UserTakesQuizRepository userTakesQuizRepository) {
        this.userTakesQuizRepository = userTakesQuizRepository;
    }

    @Override
    public List<UserTakesQuiz> findAll() {
        return userTakesQuizRepository.findAll();
    }

    @Override
    public Optional<UserTakesQuiz> save(UserTakesQuizDto userTakesQuizDto) {
        UserTakesQuiz userTakesQuiz = new UserTakesQuiz(userTakesQuizDto.getQuizId(), userTakesQuizDto.getUserId());

        this.userTakesQuizRepository.save(userTakesQuiz);

        return Optional.of(userTakesQuiz);
    }

    @Override
    public List<UserTakesQuiz> findAllByUser(Long userId) {
        return this.userTakesQuizRepository.findByUserId(userId);
    }

    @Override
    public List<UserTakesQuiz> findAllByQuiz(Long quizId) {
        return this.userTakesQuizRepository.findByQuizId(quizId);
    }

    @Override
    public List<UserTakesQuiz> findAllByResult(int result) {
        return this.userTakesQuizRepository.findByResult(result);
    }

    @Override
    public Optional<UserTakesQuiz> findById(Long id) {
        return Optional.of(this.userTakesQuizRepository.findById(id).orElseThrow(() -> new UserTakesQuizException(id)));
    }

    @Override
    public Optional<UserTakesQuiz> addResult(Long id, int result) {
        UserTakesQuiz userTakesQuiz = this.userTakesQuizRepository.findById(id)
                .orElseThrow(() -> new UserTakesQuizException(id));

        userTakesQuiz.setResult(result);

        return Optional.of(this.userTakesQuizRepository.save(userTakesQuiz));
    }

}
