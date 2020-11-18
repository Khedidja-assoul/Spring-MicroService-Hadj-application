package com.esi.msinscriptionhadj.entities;

import javax.persistence.*;

@Entity
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private  String wilaya;
    private  String commune;

    @OneToOne(mappedBy = "adresse")
    private Inscrits inscrits;

    @OneToOne(mappedBy = "Adressemahrem")
    private Mahrem mahrem  ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public String getCommune( ) {
        return this.commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public Inscrits getInscrits() {
        return inscrits;
    }

    public void setInscrits(Inscrits inscrits) {
        this.inscrits = inscrits;
    }
}
