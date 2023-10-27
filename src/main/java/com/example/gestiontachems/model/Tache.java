package com.example.gestiontachems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tache {

    public enum Priorite{FAIBLE,
        MOYENNE_FAIBLE,
        MOYENNE,
        MOYENNE_HAUTE,
        ÉLEVÉE;}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean done;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinEstimee;
    private LocalDateTime DateAssignation;
    private Priorite priorite;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;


    @PrePersist
    private void prePersist() {
        dateCreation = new Date();
    }
}
