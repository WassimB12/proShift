package com.esprit.contact;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

public class ContactModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String datedenaissaince;
    private String poste;
    private String notes;
    private String reseauxsociaux;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatedenaissaince() {
        return datedenaissaince;
    }

    public void setDatedenaissaince(String datedenaissaince) {
        this.datedenaissaince = datedenaissaince;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReseauxsociaux() {
        return reseauxsociaux;
    }

    public void setReseauxsociaux(String reseauxsociaux) {
        this.reseauxsociaux = reseauxsociaux;
    }

    public int getId() {
        return id;
    }

    public ContactModel() {
    }

    public ContactModel(String nom, String prenom, String email, String datedenaissaince, String poste, String notes, String reseauxsociaux) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datedenaissaince = datedenaissaince;
        this.poste = poste;
        this.notes = notes;
        this.reseauxsociaux = reseauxsociaux;
    }

    public void setId(int id) {
        this.id = id;
    }
}
