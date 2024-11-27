package org.wora.youquizz.content.infrastructure.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wora.youquizz.content.application.dto.request.QuestionRequestDTO;
import org.wora.youquizz.content.application.dto.response.QuestionResponseDTO;
import org.wora.youquizz.content.application.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionResponseDTO createQuestion(@Valid @RequestBody QuestionRequestDTO dto) {
        return questionService.createQuestionWithQuiz(dto);
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions() {
        List<QuestionResponseDTO> questions = questionService.findAll();
        return ResponseEntity.ok(questions);
    }
}
