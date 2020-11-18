package com.esi.msauth.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mahrem")
public class Mahrem {

    @Id
    @Column(name = "enummahrem")
    private Long Enummahrem;
    private String Nommahrem;
    private String Prenommahrem;
    private String Lieumahrem;
    private String Emailmahrem;
    private Long Nummahrem;
    private String sexemahrem;
    private Date Datenmahrem;

    @OneToOne
    @JoinColumn(name = "adressemahrem", referencedColumnName = "id")
    private Adresse Adressemahrem;


    @OneToOne(mappedBy = "mahrem")
    private Inscrits inscrits;


    public Long getEnummahrem() {
        return Enummahrem;
    }

    public void setEnummahrem(Long enummahrem) {
        Enummahrem = enummahrem;
    }

    public String getNommahrem() {
        return Nommahrem;
    }

    public void setNommahrem(String nommahrem) {
        Nommahrem = nommahrem;
    }

    public String getPrenommahrem() {
        return Prenommahrem;
    }

    public void setPrenommahrem(String prenommahrem) {
        Prenommahrem = prenommahrem;
    }

    public String getLieumahrem() {
        return Lieumahrem;
    }

    public void setLieumahrem(String lieumahrem) {
        Lieumahrem = lieumahrem;
    }

    public String getEmailmahrem() {
        return Emailmahrem;
    }

    public void setEmailmahrem(String emailmahrem) {
        Emailmahrem = emailmahrem;
    }

    public Long getNummahrem() {
        return Nummahrem;
    }

    public void setNummahrem(Long nummahrem) {
        Nummahrem = nummahrem;
    }

    public String getSexemahrem() {
        return sexemahrem;
    }

    public void setSexemahrem(String sexemahrem) {
        this.sexemahrem = sexemahrem;
    }

    public Date getDatenmahrem() {
        return Datenmahrem;
    }

    public void setDatenmahrem(Date datenmahrem) {
        Datenmahrem = datenmahrem;
    }

    public Adresse getAdressemahrem() {
        return Adressemahrem;
    }

    public void setAdressemahrem(Adresse adressemahrem) {
        Adressemahrem = adressemahrem;
    }

    public Inscrits getInscrits() {
        return inscrits;
    }

    public void setInscrits(Inscrits inscrits) {
        this.inscrits = inscrits;
    }
}
