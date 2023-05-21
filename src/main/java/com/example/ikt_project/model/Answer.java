package com.example.ikt_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String content;
    boolean is_correct;

    @ManyToOne
    private Question question;

//    @OneToOne
//    private Question correctQuestion;

    public Answer() {
    }

    public Answer(String content, Question question, boolean is_correct) {
        this.content = content;
        this.question = question;
        this.is_correct = is_correct;
    }

}
