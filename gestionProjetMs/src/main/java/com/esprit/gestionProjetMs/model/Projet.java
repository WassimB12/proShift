package com.esprit.gestionProjetMs.model;


import javax.persistence.*;
import java.util.Date;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateFinEstimee() {
        return dateFinEstimee;
    }

    public void setDateFinEstimee(Date dateFinEstimee) {
        this.dateFinEstimee = dateFinEstimee;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Projet(Long id, String nom, Date dateFinEstimee, Date dateFin, Date dateDebut, String description, Etat etat, Date dateCreation) {
        this.id = id;
        this.nom = nom;
        this.dateFinEstimee = dateFinEstimee;
        this.dateFin = dateFin;
        this.dateDebut = dateDebut;
        this.description = description;
        this.etat = etat;
        this.dateCreation = dateCreation;
    }

    public Projet() {
    }
}
