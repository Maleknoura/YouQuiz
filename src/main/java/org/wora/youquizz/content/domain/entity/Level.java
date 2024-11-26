package org.wora.youquizz.content.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Level {
    @Id
    private long id;
    private String description;
    private Integer pointsMin;
    private Integer pointsMax;


}
