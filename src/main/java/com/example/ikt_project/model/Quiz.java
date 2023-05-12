package com.example.ikt_project.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String description;
    @ManyToMany
    List<User> users;
    @OneToMany
    List<Question> questions;

    public Quiz(){}

    public Quiz(String title, String description){
        this.title = title;
        this.description = description;
    }
}
