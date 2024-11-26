package org.wora.youquizz.person.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Student extends User {
    private LocalDate dateInscription;


}

