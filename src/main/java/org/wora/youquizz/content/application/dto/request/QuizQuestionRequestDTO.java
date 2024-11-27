package org.wora.youquizz.content.application.dto.request;

import jakarta.validation.constraints.NotNull;

public record QuizQuestionRequestDTO(
        @NotNull(message = "Quiz ID is required")
        Long quizId,

        @NotNull(message = "Question ID is required")
        Long questionId,

        @NotNull(message = "Time is required")
        Integer time
) {}
