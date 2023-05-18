package com.example.ikt_project.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_takes_quiz")
public class UserTakesQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    public Long quizId;
    public Long user_iktId;
    int result;

    public UserTakesQuiz() {}

    public UserTakesQuiz(Long quizId, Long user_iktId) {
        this.quizId = quizId;
        this.user_iktId = user_iktId;
//        this.result = result;
    }

}