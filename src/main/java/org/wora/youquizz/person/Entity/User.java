package org.wora.youquizz.person.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public abstract class User {
    @Id
    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String adresse;

}
