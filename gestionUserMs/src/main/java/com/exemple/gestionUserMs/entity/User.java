package com.exemple.gestionUserMs.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.PrePersist;
import java.util.Date;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public enum EtatCivil {CELIBATAIRE, MARIE, DIVORCE}

    public enum Poste {TECHNICIEN, INGENIEUR}

    public enum Departement {RH, WEBDEV, MOBDEV, FINANCE}

    public enum ERole {role_chef, role_employee, role_responsable}

    @Id
    private String id; // Using String as ID for MongoDB
    private String username;
    private String email;
    private String password;
    private ERole role;
    private String cin;
    private String resetPasswordToken;
    private String verificationCode;
    private boolean blocked;
    private String matricule;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Integer numTelephone;
    private String adresse;
    private Date dateEmbauche;
    private String urgenceNom;
    private Integer urgenceNum;
    private Integer congeSolde;
    private Date checkin;
    private boolean approved;
    private boolean statut;
    private Date dateCreation;
    private Poste poste;
    private EtatCivil etatCivil;
    private Departement departement;
    private Long equipeId;

    @PrePersist
    private void prePersist() {
        dateCreation = new Date();
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
