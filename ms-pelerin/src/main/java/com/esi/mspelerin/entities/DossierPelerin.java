package com.esi.mspelerin.entities;

import javax.persistence.*;
import javax.servlet.http.Part;

@Entity
@Table(name = "dossier")
public class DossierPelerin {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dossier_id;
    private Part carteidentite;

    public void setDossier_id(Long dossier_id) {
        this.dossier_id = dossier_id;
    }

    @Id
    public Long getDossier_id() {
        return dossier_id;
    }
}
