package com.example.ikt_project.web;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.Question;
import com.example.ikt_project.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService){
        this.answerService = answerService;
    }

    @GetMapping()
    public List<Answer> findAll() {
        return this.answerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id) {
        return this.answerService.findById(id)
                .map(answer -> ResponseEntity.ok().body(answer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.answerService.deleteById(id);
        if(this.answerService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
