package org.wora.youquizz.quizz;

import jakarta.persistence.*;
import org.wora.youquizz.content.domain.entity.AnswerValidation;
import org.wora.youquizz.person.Entity.Student;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class QuizAssignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime assignedAt;
    private LocalDateTime completedAt;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "quizAssignment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerValidation> answerValidations;




}

