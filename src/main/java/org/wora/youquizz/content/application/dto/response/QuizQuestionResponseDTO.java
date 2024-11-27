package org.wora.youquizz.content.application.dto.response;

public record QuizQuestionResponseDTO(
        Long id,
        Long quizId,
        Long questionId,
        String questionText,
        Integer time
) {}
