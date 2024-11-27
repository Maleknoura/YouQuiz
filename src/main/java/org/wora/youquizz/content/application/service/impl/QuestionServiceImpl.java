package org.wora.youquizz.content.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wora.youquizz.content.application.dto.request.QuestionRequestDTO;
import org.wora.youquizz.content.application.dto.response.QuestionResponseDTO;
import org.wora.youquizz.content.application.mapper.QuestionMapper;
import org.wora.youquizz.content.application.service.QuestionService;
import org.wora.youquizz.content.domain.entity.Level;
import org.wora.youquizz.content.domain.entity.Question;
import org.wora.youquizz.content.domain.entity.QuizQuestion;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.content.domain.repository.LevelRepository;
import org.wora.youquizz.content.domain.repository.QuestionRepository;
import org.wora.youquizz.content.domain.repository.QuizQuestionRepository;
import org.wora.youquizz.content.domain.repository.SubjectRepository;
import org.wora.youquizz.quizz.domain.entity.Quiz;
import org.wora.youquizz.quizz.domain.entity.QuizzQuestion;
import org.wora.youquizz.quizz.domain.repository.QuizzRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final SubjectRepository subjectRepository;
    private final LevelRepository levelRepository;
    private final QuizzRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;

    public QuestionResponseDTO createQuestionWithQuiz(QuestionRequestDTO dto) {
        Subject subject = subjectRepository.findById(dto.subjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        Level level = levelRepository.findById(dto.levelId())
                .orElseThrow(() -> new EntityNotFoundException("Level not found"));

        Quiz quiz = quizRepository.findById(dto.quizId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));

        Question question = questionMapper.toEntity(dto);
        question.setSubject(subject);
        question.setLevel(level);

        question = questionRepository.save(question);

        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setQuiz(quiz);
        quizQuestion.setQuestion(question);
        quizQuestion.setTime(dto.time());
        quizQuestionRepository.save(quizQuestion);

        return questionMapper.toDTO(question);
    }
    public List<QuestionResponseDTO> findAll() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }

}
