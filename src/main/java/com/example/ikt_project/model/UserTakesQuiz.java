package com.example.ikt_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_takes_quiz")
public class UserTakesQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long quizId;
    Long userId;
    int result;

    public UserTakesQuiz() {
    }

    public UserTakesQuiz(Long quizId, Long userId) {
        this.quizId = quizId;
        this.userId = userId;
        this.result = 0;
    }

}