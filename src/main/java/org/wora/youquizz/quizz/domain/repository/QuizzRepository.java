package org.wora.youquizz.quizz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.youquizz.quizz.domain.entity.Quiz;

public interface QuizzRepository extends JpaRepository<Quiz,Long> {
}
