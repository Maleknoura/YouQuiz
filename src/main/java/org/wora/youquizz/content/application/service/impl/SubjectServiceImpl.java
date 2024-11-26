package org.wora.youquizz.content.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wora.youquizz.content.application.dto.request.SubjectRequestDTO;
import org.wora.youquizz.content.application.dto.response.SubjectResponseDTO;
import org.wora.youquizz.content.application.mapper.SubjectMapper;
import org.wora.youquizz.content.application.service.SubjectService;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.content.domain.repository.SubjectRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;


    public SubjectResponseDTO createSubject(SubjectRequestDTO subjectRequestDTO) {
        Subject subject = subjectMapper.toEntity(subjectRequestDTO);

        if (subjectRequestDTO.parentSubjectId() != null) {
            Optional<Subject> parentSubject = subjectRepository.findById(subjectRequestDTO.parentSubjectId());
            parentSubject.ifPresent(subject::setParentSubject);
        }

        Subject savedSubject = subjectRepository.save(subject);

        return subjectMapper.toDto(savedSubject);
    }

    @Override
    public List<SubjectResponseDTO> getSubSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(subjectMapper::toDto)
                .collect(Collectors.toList());
    }

}
