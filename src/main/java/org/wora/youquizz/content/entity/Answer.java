package org.wora.youquizz.content.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {
    @Id
    private long id;
    private String texteReponse;
    private boolean estCorrect;

    @ManyToOne
    private Question question;
}
