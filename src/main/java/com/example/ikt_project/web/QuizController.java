package com.example.ikt_project.web;

import com.example.ikt_project.model.Question;
import com.example.ikt_project.model.Quiz;
import com.example.ikt_project.model.dto.QuizDto;
import com.example.ikt_project.service.QuestionService;
import com.example.ikt_project.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:3000")
public class QuizController {

    private final QuizService quizService;
    private final QuestionService questionService;

    public QuizController(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @GetMapping
    public List<Quiz> findAllQuizzes() {
        return this.quizService.findAllQuizzes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> findQuizById(@PathVariable Long id) {
        return this.quizService.findQuizById(id)
                .map(quiz -> ResponseEntity.ok().body(quiz))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/add-quiz")
    public ResponseEntity createQuizPage() {

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDto quizDto) {
        return this.quizService.createQuiz(quizDto)
                .map(quiz -> ResponseEntity.ok().body(quiz))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/edit-quiz/{id}")
    public ResponseEntity<Quiz> editQuizPage(@PathVariable Long id) {

        Optional<Quiz> quiz = this.quizService.findQuizById(id);

        return quiz.map(quizById -> ResponseEntity.ok().body(quizById))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Quiz> editQuiz(@PathVariable Long id,
                                         @RequestBody QuizDto quizDto) {
        return this.quizService.editQuiz(id, quizDto)
                .map(quiz -> ResponseEntity.ok().body(quiz))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteQuiz(@PathVariable Long id) {
        this.quizService.deleteQuiz(id);
        if (this.quizService.findQuizById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/add-questions")
    public List<Question> addQuestionToQuizPage() {

        return this.questionService.findAll();
    }

    @GetMapping("/{quizId}/questions")
    public List<Question> findAllQuestionsByQuiz(@PathVariable Long quizId){
        return questionService.getAllByQuizId(quizId);
    }

}
