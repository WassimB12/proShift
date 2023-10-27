package com.esprit.demande.model;



import javax.persistence.*;
import java.util.Date;

@Entity
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

    public Demande() {
    }

    public Demande(Long id, TypeDemande type, Date dateCreation, Date dateDebut, Date dateFin, String motif, int nombreJours, StatusDemande status, Long userId) {
        this.id = id;
        this.type = type;
        this.dateCreation = dateCreation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
        this.nombreJours = nombreJours;
        this.status = status;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeDemande getType() {
        return type;
    }

    public void setType(TypeDemande type) {
        this.type = type;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getNombreJours() {
        return nombreJours;
    }

    public void setNombreJours(int nombreJours) {
        this.nombreJours = nombreJours;
    }

    public StatusDemande getStatus() {
        return status;
    }

    public void setStatus(StatusDemande status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
