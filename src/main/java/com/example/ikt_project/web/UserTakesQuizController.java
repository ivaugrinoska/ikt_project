package com.example.ikt_project.web;

import com.example.ikt_project.model.UserTakesQuiz;
import com.example.ikt_project.model.dto.UserTakesQuizDto;
import com.example.ikt_project.service.UserTakesQuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userTakesQuiz")
public class UserTakesQuizController {

    private final UserTakesQuizService userTakesQuizService;

    public UserTakesQuizController(UserTakesQuizService userTakesQuizService) {
        this.userTakesQuizService = userTakesQuizService;
    }

    @GetMapping
    public List<UserTakesQuiz> findAll() {
        return this.userTakesQuizService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTakesQuiz> findById(@PathVariable Long id) {
        return this.userTakesQuizService.findById(id)
                .map(object -> ResponseEntity.ok().body(object))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addUserToQuiz")
    public ResponseEntity<UserTakesQuiz> addUserToQuiz(@RequestBody UserTakesQuizDto userTakesQuizDto) {
        return this.userTakesQuizService.save(userTakesQuizDto)
                .map(object -> ResponseEntity.ok().body(object))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/findAllByUser")
    public List<UserTakesQuiz> findAllByUser(@RequestBody Long userId) {
        return this.userTakesQuizService.findAllByUser(userId);
    }

    @GetMapping("/findAllByQuiz")
    public List<UserTakesQuiz> findAllByQuiz(@RequestBody Long quizId) {
        return this.userTakesQuizService.findAllByQuiz(quizId);
    }

    @GetMapping("/findAllByResult")
    public List<UserTakesQuiz> findAllByResult(@RequestBody int result) {
        return this.userTakesQuizService.findAllByResult(result);
    }

}
