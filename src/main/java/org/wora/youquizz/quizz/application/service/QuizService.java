package org.wora.youquizz.quizz.application.service;

import org.wora.youquizz.quizz.application.dto.request.QuizRequestDTO;
import org.wora.youquizz.quizz.application.dto.response.QuizResponseDTO;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    QuizResponseDTO create(QuizRequestDTO quizRequestDTO);
    List<QuizResponseDTO> getAllQuizzes();
}
