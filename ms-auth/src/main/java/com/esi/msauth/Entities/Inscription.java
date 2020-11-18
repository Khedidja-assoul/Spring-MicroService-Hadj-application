package com.esi.msauth.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "inscription")
@NoArgsConstructor @AllArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dated;
    private Date datef;
    private int nmbrplace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public Date getDatef() {
        return datef;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }

    public int getNmbrplace() {
        return nmbrplace;
    }

    public void setNmbrplace(int nmbrplace) {
        this.nmbrplace = nmbrplace;
    }
}
