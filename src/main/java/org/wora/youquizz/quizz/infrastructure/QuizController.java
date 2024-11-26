package org.wora.youquizz.quizz.infrastructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wora.youquizz.quizz.application.dto.request.QuizRequestDTO;
import org.wora.youquizz.quizz.application.dto.response.QuizResponseDTO;
import org.wora.youquizz.quizz.application.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@AllArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<QuizResponseDTO> createQuiz(@Valid @RequestBody QuizRequestDTO quizRequestDTO) {
        QuizResponseDTO createdQuiz = quizService.create(quizRequestDTO);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDTO>> getAllQuizzes() {
        List<QuizResponseDTO> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }
}
