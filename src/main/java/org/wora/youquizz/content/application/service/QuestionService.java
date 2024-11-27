package org.wora.youquizz.content.application.service;


import org.wora.youquizz.content.application.dto.request.QuestionRequestDTO;
import org.wora.youquizz.content.application.dto.response.QuestionResponseDTO;

import java.util.List;

public interface QuestionService {
    QuestionResponseDTO createQuestionWithQuiz(QuestionRequestDTO dto);
    public List<QuestionResponseDTO> findAll();

}
