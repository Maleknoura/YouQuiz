package org.wora.youquizz.quizz;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.wora.youquizz.content.domain.entity.Question;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.person.Entity.Teacher;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Quiz {
    @Id
    private long id;
    private Double scoreReussite;
    private Boolean droitVisualiserReponses;
    private Boolean droitVoirResultatFinal;
    private Integer nombreChances;
    private String remarques;
    private String consignes;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    private List<Question> questions;

    @ManyToMany
    private List<Subject> subjects;

}
