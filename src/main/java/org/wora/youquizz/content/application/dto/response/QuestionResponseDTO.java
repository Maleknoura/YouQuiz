package org.wora.youquizz.content.application.dto.response;

import org.wora.youquizz.content.domain.enums.QuestionType;

public record QuestionResponseDTO(
        Long id,
        String texte,
        QuestionType type,
        Integer points,
        Long subjectId,
        Long levelId
) {}
