package org.wora.youquizz.content.application.dto.response;

import java.util.List;

public record SubjectResponseDTO(
        Long id,
        String name,
        Long parentSubjectId,
        List<Long> subSubjectIds
) {
}
