package tn.esprit.freelancers.projet;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProjetModel implements Serializable {
    private static final long serialVersionUID = 6;


    @Id
    @GeneratedValue

    private int id;

    private String nom;
    private String description;
    private int budget;
    private String competencesRequises;

    public ProjetModel(String nom, String description, int budget, String competencesRequises) {
        this.nom = nom;
        this.description = description;
        this.budget = budget;
        this.competencesRequises = competencesRequises;
    }

    public ProjetModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getCompetencesRequises() {
        return competencesRequises;
    }

    public void setCompetencesRequises(String competencesRequises) {
        this.competencesRequises = competencesRequises;
    }
}
