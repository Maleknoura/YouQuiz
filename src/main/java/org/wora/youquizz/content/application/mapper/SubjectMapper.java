package org.wora.youquizz.content.application.mapper;

import org.mapstruct.Mapper;
import org.wora.youquizz.content.application.dto.request.SubjectRequestDTO;
import org.wora.youquizz.content.application.dto.response.SubjectResponseDTO;
import org.wora.youquizz.content.domain.entity.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectResponseDTO toResponseDTO(Subject subject);
    Subject toEntity(SubjectRequestDTO requestDTO);
}
