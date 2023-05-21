package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.Question;
import com.example.ikt_project.model.Quiz;
import com.example.ikt_project.model.User;
import com.example.ikt_project.model.dto.AddQuestionDto;
import com.example.ikt_project.model.dto.QuizDto;
import com.example.ikt_project.model.exceptions.QuizNotFoundException;
import com.example.ikt_project.repository.QuestionRepository;
import com.example.ikt_project.repository.QuizRepository;
import com.example.ikt_project.repository.UserRepository;
import com.example.ikt_project.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public Optional<Quiz> addUserToQuiz(Long quizId, String username) {
        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));
//        List<User> users = quiz.getUsers();

//        if(users.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList()).size() == 0){
//            User user = this.userRepository.findUserByUsername(username);
//
//            users.add(user);
//        }
//
//        quiz.setUsers(users);

        this.quizRepository.save(quiz);

        return Optional.of(quiz);
    }

//    @Override
//    public Optional<Quiz> addQuestionsToQuiz(Long quizId, List<AddQuestionDto> questionIds) {
//        List<Question> questions = new ArrayList<>();
//        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException(quizId));
//
//        List<Long> ids = new ArrayList<>();
//
//        for(int i=0; i<questionIds.size();i++){
//            ids.add(questionIds.get(i).getId());
//        }
//
//        for(Question question : this.questionRepository.findAll()){
//            for(Long questionId : ids){
//
//                if(question.getId().equals(questionId)){
//                    questions.add(question);
//                }
//
//            }
//        }
//
////        quiz.setQuestions(questions);
//
//        this.quizRepository.save(quiz);
//
//        return Optional.of(quiz);
//    }
}
