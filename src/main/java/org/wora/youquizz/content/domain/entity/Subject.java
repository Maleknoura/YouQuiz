package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wora.youquizz.quizz.domain.entity.Quiz;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_subject_id")
    private Subject parentSubject;

    @OneToMany(mappedBy = "parentSubject")
    private List<Subject> subSubjects;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    @ManyToMany(mappedBy = "subjects")
    private List<Quiz> quizzes;

}

