package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.UserTakesQuiz;
import com.example.ikt_project.model.dto.UserTakesQuizDto;
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
        UserTakesQuiz userTakesQuiz = new UserTakesQuiz(userTakesQuizDto.getQuizId(), userTakesQuizDto.getUser_iktId(),
                userTakesQuizDto.getResult());

        this.userTakesQuizRepository.save(userTakesQuiz);

        return Optional.of(userTakesQuiz);
    }
}
