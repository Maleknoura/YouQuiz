package org.wora.youquizz.quizz.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wora.youquizz.content.domain.entity.Subject;
import org.wora.youquizz.person.Entity.Teacher;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private String remarks;
    private String instructions;
    private Integer maxAttempts;
    private Integer passingScore;
    private Boolean canViewAnswers;
    private Boolean canViewResults;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
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
