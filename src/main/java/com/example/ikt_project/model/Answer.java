package com.example.ikt_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String content;
    boolean is_correct;

    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Answer(String content, boolean is_correct) {
        this.content = content;
        this.is_correct = is_correct;
    }

}
