package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Level {
    @Id
    private Long id;
    private String description;
    private Integer pointsMin;
    private Integer pointsMax;

}
