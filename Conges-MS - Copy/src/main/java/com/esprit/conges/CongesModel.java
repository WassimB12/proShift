package com.esprit.conges;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

public class CongesModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String datedeconge;
    private String Dureeduconge;
    private String motifdureport;

    public CongesModel(String datedeconge, String dureeduconge, String motifdureport) {
        this.datedeconge = datedeconge;
        Dureeduconge = dureeduconge;
        this.motifdureport = motifdureport;
    }

    public CongesModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatedeconge() {
        return datedeconge;
    }

    public void setDatedeconge(String datedeconge) {
        this.datedeconge = datedeconge;
    }

    public String getDureeduconge() {
        return Dureeduconge;
    }

    public void setDureeduconge(String dureeduconge) {
        Dureeduconge = dureeduconge;
    }

    public String getMotifdureport() {
        return motifdureport;
    }

    public void setMotifdureport(String motifdureport) {
        this.motifdureport = motifdureport;
    }
}
