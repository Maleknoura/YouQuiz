package org.wora.youquizz.quizz.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record QuizRequestDTO(
        @NotBlank(message = "Title is required") String title,
        String description,
        String remarks,
        String instructions,

        @NotNull(message = "Max attempts is required") Integer maxAttempts,
        @NotNull(message = "Passing score is required") Integer passingScore,

        Boolean canViewAnswers,
        Boolean canViewResults,

        @NotNull(message = "Start date is required") LocalDateTime startDate,
        @NotNull(message = "End date is required") LocalDateTime endDate,

        @NotNull(message = "Teacher ID is required") Long teacherId,
        List<Long> subjectIds
) {
}

