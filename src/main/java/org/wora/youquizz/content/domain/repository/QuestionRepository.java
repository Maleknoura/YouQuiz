package org.wora.youquizz.content.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.youquizz.content.domain.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
