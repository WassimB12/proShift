package com.esprit.demandeemploi;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class OffreEmploiModel implements Serializable {
    private static final long SerialVersion=16;

    public OffreEmploiModel() {
    }

    public OffreEmploiModel(String titre, String typeEmploi, String CompetanceRequise, String AdressMail,Date datePublication,String statut) {
        this.titre = titre;
        this.typeEmploi=typeEmploi;
        this.AdressMail=AdressMail;
        this.CompetanceRequise=CompetanceRequise;
        this.datePublication=datePublication;
        this.statut=statut;
    }

    @Id
@GeneratedValue
    private int id;

    private String titre,typeEmploi,CompetanceRequise,AdressMail,statut;

    private Date datePublication;


    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTypeEmploi() {
        return typeEmploi;
    }

    public void setTypeEmploi(String typeEmploi) {
        this.typeEmploi = typeEmploi;
    }

    public String getCompetanceRequise() {
        return CompetanceRequise;
    }

    public void setCompetanceRequise(String competanceRequise) {
        CompetanceRequise = competanceRequise;
    }

    public String getAdressMail() {
        return AdressMail;
    }

    public void setAdressMail(String adressMail) {
        AdressMail = adressMail;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setId(int id) {
        this.id=id;
    }
}
