package com.example.ikt_project.web;

import com.example.ikt_project.model.Answer;
import com.example.ikt_project.model.UserTakesQuiz;
import com.example.ikt_project.model.dto.AnswerDto;
import com.example.ikt_project.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
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
        if (this.answerService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerDto answerDto) {
        return this.answerService.createAnswer(answerDto)
                .map(answer -> ResponseEntity.ok().body(answer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Answer> editAnswer(@PathVariable Long id, @RequestBody AnswerDto answerDto) {
        return this.answerService.editAnswer(id, answerDto)
                .map(answer -> ResponseEntity.ok().body(answer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/getResult")
    public ResponseEntity<UserTakesQuiz> getResult(@RequestParam Long quizId, @RequestParam Long userId,
                                                   @RequestBody List<Long> answerIds) {
        return this.answerService.getResult(quizId, userId, answerIds)
                .map(userTakesQuiz -> ResponseEntity.ok().body(userTakesQuiz))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
