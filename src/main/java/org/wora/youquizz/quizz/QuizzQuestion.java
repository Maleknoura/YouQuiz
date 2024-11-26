package org.wora.youquizz.quizz;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.wora.youquizz.content.domain.entity.Question;

@Entity
public class QuizzQuestion {
    @Id
    private long id;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Question question;

    private Boolean estTemporise;
    private Integer temps;
}
