package org.wora.youquizz.quizz.application.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDateTime;
import java.util.List;

public record QuizResponseDTO(
        Long id,
        String title,
        String description,
        LocalDateTime createdAt,
        String remarks,
        String instructions,
        Integer maxAttempts,
        Integer passingScore,
        Boolean canViewAnswers,
        Boolean canViewResults,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Long teacherId,
        List<Long> subjectIds
) {
}


