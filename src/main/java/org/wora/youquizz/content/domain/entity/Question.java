package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.wora.youquizz.content.domain.enums.QuestionType;
import org.wora.youquizz.quizz.QuizzQuestion;

import java.util.List;

@Entity
public class Question {
    @Id
    private long id;
    private String texte;
    private String media;
    private QuestionType type;
    private Integer points;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Level level;

    @OneToMany(mappedBy = "question")
    private List<QuestionAnswer> questionAnswers;

    @OneToMany(mappedBy = "question")
    private List<QuizzQuestion> quizzQuestions;

}