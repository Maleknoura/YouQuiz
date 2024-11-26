package org.wora.youquizz.quizz.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.wora.youquizz.content.application.dto.request.SubjectRequestDTO;
import org.wora.youquizz.content.application.dto.response.SubjectResponseDTO;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.person.Entity.Teacher;
import org.wora.youquizz.quizz.application.dto.request.QuizRequestDTO;
import org.wora.youquizz.quizz.application.dto.response.QuizResponseDTO;
import org.wora.youquizz.quizz.domain.entity.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.quizz.application.dto.request.QuizRequestDTO;
import org.wora.youquizz.quizz.application.dto.response.QuizResponseDTO;
import org.wora.youquizz.quizz.domain.entity.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.quizz.application.dto.request.QuizRequestDTO;
import org.wora.youquizz.quizz.application.dto.response.QuizResponseDTO;
import org.wora.youquizz.quizz.domain.entity.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface QuizMapper {

    @Mapping(target = "teacher", source = "teacherId")
    @Mapping(target = "subjects", source = "subjectIds", qualifiedByName = "mapSubjectIds") // Correction ici
    Quiz toEntity(QuizRequestDTO dto);

    @Mapping(source = "teacher", target = "teacherId")
    @Mapping(source = "subjects", target = "subjectIds", qualifiedByName = "mapSubjectIdsToList")
    QuizResponseDTO toDTO(Quiz entity);

    @Named("mapSubjectIds")
    default List<Subject> mapSubjectIds(List<Long> subjectIds) {
        if (subjectIds == null) {
            return new ArrayList<>();
        }
        return subjectIds.stream()
                .map(id -> {
                    Subject subject = new Subject();
                    subject.setId(id); // Assurez-vous que Subject a une méthode setId
                    return subject;
                })
                .collect(Collectors.toList());
    }

    @Named("mapSubjectIdsToList")
    default List<Long> mapSubjectIdsToList(List<Subject> subjects) {
        if (subjects == null) {
            return new ArrayList<>();
        }
        return subjects.stream()
                .map(Subject::getId)
                .collect(Collectors.toList());
    }

    default Long map(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        return teacher.getId();
    }

    default Teacher map(Long teacherId) {
        if (teacherId == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        return teacher;
    }
}
