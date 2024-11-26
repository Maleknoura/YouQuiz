package org.wora.youquizz.content.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.youquizz.content.domain.entity.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByParentSubject(Subject parentSubject);
}
