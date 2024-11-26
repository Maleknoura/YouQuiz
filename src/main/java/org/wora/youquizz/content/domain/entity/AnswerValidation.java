package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.*;
import org.wora.youquizz.quizz.domain.entity.QuizAssignement;

@Entity
public class AnswerValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isCorrect;
    private Double points;

    @ManyToOne
    @JoinColumn(name = "quiz_assignment_id")
    private QuizAssignement quizAssignment;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
