package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.wora.youquizz.content.domain.enums.QuestionType;
import org.wora.youquizz.quizz.domain.entity.QuizzQuestion;

import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texte;
    @Enumerated(EnumType.STRING)
    private QuestionType type;
    private Integer points;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "question")
    private List<AnswerValidation> answerValidations;

    @OneToMany(mappedBy = "question")
    private List<QuizzQuestion> quizzQuestions;

}
