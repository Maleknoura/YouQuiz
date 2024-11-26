package org.wora.youquizz.content.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.wora.youquizz.content.application.dto.request.SubjectRequestDTO;
import org.wora.youquizz.content.application.dto.response.SubjectResponseDTO;
import org.wora.youquizz.content.domain.entity.Subject;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class})
public interface SubjectMapper {
    @Mapping(target = "parentSubject", source = "parentSubjectId", qualifiedByName = "longToSubject")
    Subject toEntity(SubjectRequestDTO dto);

    @Named("longToSubject")
    default Subject longToSubject(Long parentSubjectId) {
        if (parentSubjectId == null) {
            return null;
        }
        Subject subject = new Subject();
        subject.setId(parentSubjectId);
        return subject;
    }

    @Mapping(target = "parentSubjectId", source = "parentSubject.id")
    @Mapping(target = "subSubjectIds",
            expression = "java(subject.getSubSubjects() != null ? " +
                    "subject.getSubSubjects().stream().map(Subject::getId).collect(Collectors.toList()) : null)")
    SubjectResponseDTO toDto(Subject subject);
}