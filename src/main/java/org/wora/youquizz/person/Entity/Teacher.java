package org.wora.youquizz.person.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.wora.youquizz.quizz.domain.entity.Quiz;

import java.util.List;

@Entity
public class Teacher extends User {
    private String specialite;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes;
}
