package org.wora.youquizz.quizz.application.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wora.youquizz.quizz.application.dto.request.QuizRequestDTO;
import org.wora.youquizz.quizz.application.dto.response.QuizResponseDTO;
import org.wora.youquizz.quizz.application.mapper.QuizMapper;
import org.wora.youquizz.quizz.application.service.QuizService;
import org.wora.youquizz.quizz.domain.entity.Quiz;
import org.wora.youquizz.quizz.domain.repository.QuizzRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizzRepository quizRepository;
    private final QuizMapper quizMapper;
    @Override
    public QuizResponseDTO create(QuizRequestDTO quizRequestDTO) {
        Quiz quiz = quizMapper.toEntity(quizRequestDTO);

        quiz.setCreatedAt(LocalDateTime.now());

        Quiz savedQuiz = quizRepository.save(quiz);

        return quizMapper.toDTO(savedQuiz);
    }

    @Override

    public List<QuizResponseDTO> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(quizMapper::toDTO)
                .collect(Collectors.toList());
    }
}
