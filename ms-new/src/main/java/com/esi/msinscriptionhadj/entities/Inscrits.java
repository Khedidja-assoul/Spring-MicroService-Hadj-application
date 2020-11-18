package com.esi.msinscriptionhadj.entities;

 import lombok.*;

 import javax.persistence.*;
 import java.sql.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name ="inscrits")
 public class Inscrits {

    @Id
    @Column(name = "enum")
     private Long Enum;
    private String Nom;
    private String Prenom;
    private String Lieu;
    private String Email;
    private Long Num;
    private String sexe;
    private Date Daten;
    private Integer inscriptions;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse", referencedColumnName = "id")
    private  Adresse adresse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mahrem", referencedColumnName = "enummahrem")
    private  Mahrem mahrem;

}
