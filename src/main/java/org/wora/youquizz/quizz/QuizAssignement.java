package org.wora.youquizz.quizz;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.wora.youquizz.person.Entity.Student;

import java.time.LocalDateTime;

@Entity
public class QuizAssignement {
    @Id
    private long id;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Student student;

    private Integer numeroTentative;
    private String raisonPassage;
    private LocalDateTime datePassage;
    private Double scoreTotal;




}

