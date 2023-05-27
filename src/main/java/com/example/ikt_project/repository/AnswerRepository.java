package com.example.ikt_project.repository;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestionId(Long id);
}
