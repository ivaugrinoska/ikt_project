package com.example.ikt_project.web;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.dto.AnswerDto;
import com.example.ikt_project.service.AnswerService;
import com.example.ikt_project.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    public AnswerController(AnswerService answerService, QuestionService questionService){
        this.answerService = answerService;
        this.questionService = questionService;
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

    @PostMapping("/add")
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerDto answerDto){
        return this.answerService.createAnswer(answerDto)
                .map(answer -> ResponseEntity.ok().body(answer))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Answer> editAnswer(@PathVariable Long id, @RequestBody AnswerDto answerDto){
        return this.answerService.editAnswer(id, answerDto)
                .map(answer -> ResponseEntity.ok().body(answer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

//    @PostMapping("/add-answers/{id}")
//        public ResponseEntity<Question> addAnswersToQuestion(@PathVariable Long id, @RequestBody List<AddAnswerDto> answerIds){
//        return this.answerService.addAnswerToQuestion(id, answerIds)
//                .map(question -> ResponseEntity.ok().body(question))
//                .orElseGet(()-> ResponseEntity.badRequest().build());
//    }
}
