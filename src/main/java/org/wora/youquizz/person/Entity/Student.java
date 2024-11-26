package org.wora.youquizz.person.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.wora.youquizz.quizz.domain.entity.QuizAssignement;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Student extends User {
    private LocalDate dateInscription;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizAssignement> quizAssignments;
}

