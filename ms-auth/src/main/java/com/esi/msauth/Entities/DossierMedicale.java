package com.esi.msauth.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dossier_medicale")
@AllArgsConstructor @NoArgsConstructor
public class DossierMedicale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String maladie;
    private String avis;

    @Enumerated(EnumType.ORDINAL)
    private Vaccin vaccin;

    @OneToOne(mappedBy = "dossiermedicale ")
    private User pelerin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public Vaccin getVaccin() {
        return vaccin;
    }

    public void setVaccin(Vaccin vaccins) {
        this.vaccin = vaccins;
    }

    public User getPelerin() {
        return pelerin;
    }

    public void setPelerin(User pelerin) {
        this.pelerin = pelerin;
    }
}
