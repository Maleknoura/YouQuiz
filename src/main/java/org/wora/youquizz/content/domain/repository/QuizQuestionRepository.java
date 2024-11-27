package org.wora.youquizz.content.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.youquizz.content.domain.entity.QuizQuestion;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion,Long> {
    List<QuizQuestion> findByQuizId(Long quizId);
}
