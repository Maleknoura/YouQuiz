package org.wora.youquizz.content.application.dto.request;

public record SubjectRequestDTO(
        String title,
        Long parentSubjectId
) {
}
