package com.example.ikt_project.model;


import jakarta.persistence.*;
import lombok.Data;

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

    public Question() {}

    public Question(String content) {
        this.content = content;
    }
}
