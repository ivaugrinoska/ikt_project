package com.example.ikt_project.web;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.Question;
import com.example.ikt_project.model.dto.QuestionDto;
import com.example.ikt_project.service.AnswerService;
import com.example.ikt_project.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    public QuestionController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping
    public List<Question> findAll() {
        return this.questionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) {
        return this.questionService.findById(id)
                .map(question -> ResponseEntity.ok().body(question))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Question> save(@RequestBody QuestionDto questionDto) {
        return this.questionService.save(questionDto)
                .map(question -> ResponseEntity.ok().body(question))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Question> save(@PathVariable Long id,
                                         @RequestBody QuestionDto questionDto) {
        return this.questionService.edit(id, questionDto)
                .map(question -> ResponseEntity.ok().body(question))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.questionService.deleteById(id);
        if (this.questionService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{questionId}/answers")
    public List<Answer> getAllAnswersByQuestionId(@PathVariable Long questionId){
        return answerService.getAllAnswersByQuestionId(questionId);
    }

}
