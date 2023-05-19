package com.example.ikt_project.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String content;

//    @ManyToOne
//    Quiz quiz;

    @OneToMany
    List<Answer> answers;

    public Question() {}

    public Question(String content) {
        this.content = content;
    }
}
