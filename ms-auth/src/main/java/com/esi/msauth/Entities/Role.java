package com.esi.msauth.Entities;

import javax.persistence.*;

@Entity
@Table (name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    private  int id;

    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
