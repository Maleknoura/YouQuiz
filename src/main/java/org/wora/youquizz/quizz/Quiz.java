package org.wora.youquizz.quizz;

import jakarta.persistence.*;
import org.mapstruct.ap.internal.model.GeneratedType;
import org.wora.youquizz.content.domain.entity.Question;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.person.Entity.Teacher;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizAssignement> quizAssignments;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizzQuestion> quizQuestions;
    @ManyToMany
    @JoinTable(
            name = "quiz_subject",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
}
