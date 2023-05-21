package com.example.ikt_project.service.impl;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.dto.AnswerDto;
import com.example.ikt_project.model.exceptions.AnswerNotFoundException;
import com.example.ikt_project.repository.AnswerRepository;
import com.example.ikt_project.repository.QuestionRepository;
import com.example.ikt_project.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
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
        Answer newAnswer = new Answer(answerDto.getContent(), answerRepository.findById(answerDto.getQuestionId()).get().getQuestion(), answerDto.is_correct());
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

//    @Override
//    public Optional<Question> addAnswerToQuestion(Long questionId, List<AddAnswerDto> answerIds) {
//        List<Answer> answers = new ArrayList<>();
//        Question question = this.questionRepository.findById(questionId).orElseThrow(()->new QuestionNotFoundException(questionId));
//        List<Long> ids = new ArrayList<>();
//        for(int i=0; i<answerIds.size(); i++){
//            ids.add(answerIds.get(i).getId());
//        }
//        for(Answer answer : this.answerRepository.findAll()){
//            for (Long answerId : ids){
//                if(answer.getId().equals(answerId)){
//                    answers.add(answer);
//                }
//            }
//        }
//        question.setAnswers(answers);
//        this.questionRepository.save(question);
//        return Optional.of(question);
//    }
}
