package org.wora.youquizz.content.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.wora.youquizz.content.application.dto.request.QuestionRequestDTO;
import org.wora.youquizz.content.application.dto.response.QuestionResponseDTO;
import org.wora.youquizz.content.domain.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "level.id", source = "levelId")
    @Mapping(target = "answerValidations", ignore = true)
    @Mapping(target = "quizzQuestions", ignore = true)
    Question toEntity(QuestionRequestDTO dto);

    @Mapping(source = "subject.id", target = "subjectId")
    @Mapping(source = "level.id", target = "levelId")
    QuestionResponseDTO toDTO(Question question);
}
