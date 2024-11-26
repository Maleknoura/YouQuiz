package org.wora.youquizz.content.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Subject {
    @Id
    private long id;
    private String intitule;

    @ManyToOne
    private Subject parentSubject;

    @OneToMany(mappedBy = "parentSubject")
    private List<Subject> childSubjects;


}

