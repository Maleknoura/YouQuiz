package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class QuestionAnswer {
    @Id
    private long id;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    private Boolean estCorrect;
}
