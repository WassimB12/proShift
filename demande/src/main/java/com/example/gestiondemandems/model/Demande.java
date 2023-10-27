package com.example.gestiondemandems.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Demande {
    public enum TypeDemande{Conge,Teletravail,Autorisation}
    public enum StatusDemande{En_attante,Acceptee,Refusee}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeDemande type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private Date dateDebut;
    private Date dateFin;
    private String motif;
    private int nombreJours;
    @Enumerated(EnumType.STRING)
    private StatusDemande status;

    private Long userId;

    @PrePersist
    private void prePersist() {
        dateCreation = new Date();
    }

    }
