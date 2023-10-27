package com.example.gestionprojetms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projet {

    public enum Etat{TERMINER,ENCOURS,ANNULEE}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateFinEstimee;
    private Date dateFin;
    private Date dateDebut;
    private String description;
    private Etat etat;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @PrePersist
    private void prePersist() {
        dateCreation = new Date();
    }


}
