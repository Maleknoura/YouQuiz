package org.wora.youquizz.content.application.service;

import org.wora.youquizz.content.application.dto.request.SubjectRequestDTO;
import org.wora.youquizz.content.application.dto.response.SubjectResponseDTO;

import java.util.List;

public interface SubjectService {
    SubjectResponseDTO createSubject(SubjectRequestDTO requestDTO);

    List<SubjectResponseDTO> getSubSubjects();
}
