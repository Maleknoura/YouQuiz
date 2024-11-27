package org.wora.youquizz.content.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.wora.youquizz.content.application.dto.request.QuizQuestionRequestDTO;
import org.wora.youquizz.content.application.dto.response.QuizQuestionResponseDTO;
import org.wora.youquizz.content.domain.entity.Question;
import org.wora.youquizz.content.domain.entity.QuizQuestion;

@Mapper(componentModel = "spring")
public interface QuizQuestionMapper {
    @Mapping(target = "quiz.id", source = "quizId")
    @Mapping(target = "question", source = "questionId", qualifiedByName = "mapToQuestion")
    QuizQuestion toEntity(QuizQuestionRequestDTO dto);

    @Mapping(source = "quiz.id", target = "quizId")
    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "question.texte", target = "questionText")
    QuizQuestionResponseDTO toDTO(QuizQuestion entity);

    @Named("mapToQuestion")
    default Question mapToQuestion(Long id) {
        Question question = new Question();
        question.setId(id);
        return question;
    }
}
