package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wora.youquizz.quizz.domain.entity.Quiz;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private Integer time;
}
