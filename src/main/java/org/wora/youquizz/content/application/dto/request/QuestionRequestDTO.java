package org.wora.youquizz.content.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.wora.youquizz.content.domain.enums.QuestionType;

public record QuestionRequestDTO(
        @NotBlank(message = "Text is required")
        String texte,

        QuestionType type,

        @NotNull(message = "Points are required")
        Integer points,

        @NotNull(message = "Subject ID is required")
        Long subjectId,

        @NotNull(message = "Level ID is required")
        Long levelId,

        @NotNull(message = "Quiz ID is required")
        Long quizId,

        @NotNull(message = "Time is required")
        Integer time
) {}