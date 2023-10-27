package com.esprit.gestionTacheMs.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
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

    public Tache(Long id, String name, String description, boolean done, LocalDateTime dateFin, LocalDateTime dateFinEstimee, LocalDateTime dateAssignation, Priorite priorite, Date dateCreation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
        this.dateFin = dateFin;
        this.dateFinEstimee = dateFinEstimee;
        DateAssignation = dateAssignation;
        this.priorite = priorite;
        this.dateCreation = dateCreation;
    }

    public Tache() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDateTime getDateFinEstimee() {
        return dateFinEstimee;
    }

    public void setDateFinEstimee(LocalDateTime dateFinEstimee) {
        this.dateFinEstimee = dateFinEstimee;
    }

    public LocalDateTime getDateAssignation() {
        return DateAssignation;
    }

    public void setDateAssignation(LocalDateTime dateAssignation) {
        DateAssignation = dateAssignation;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
