package org.wora.youquizz.content.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wora.youquizz.content.application.dto.request.SubjectRequestDTO;
import org.wora.youquizz.content.application.dto.response.SubjectResponseDTO;
import org.wora.youquizz.content.application.mapper.SubjectMapper;
import org.wora.youquizz.content.application.service.SubjectService;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.content.domain.repository.SubjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectResponseDTO createSubject(SubjectRequestDTO requestDTO) {
        Subject subject = subjectMapper.toEntity(requestDTO);

        if (requestDTO.parentSubjectId() != null) {
            Subject parentSubject = subjectRepository.findById(requestDTO.parentSubjectId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent subject not found"));

            subject.setParentSubject(parentSubject);

            parentSubject.getSubSubjects().add(subject);
        }

        Subject savedSubject = subjectRepository.save(subject);

        return subjectMapper.toResponseDTO(savedSubject);
    }

    public List<SubjectResponseDTO> getSubSubjects(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        return subjectRepository.findByParentSubject(subject)
                .stream()
                .map(subjectMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
