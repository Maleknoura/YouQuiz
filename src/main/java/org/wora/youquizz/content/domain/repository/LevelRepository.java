package org.wora.youquizz.content.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.youquizz.content.domain.entity.Level;

public interface LevelRepository extends JpaRepository<Level,Long> {
}
