package com.esi.msauth.Entities;

 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;

 import javax.persistence.*;
 import java.sql.Date;
 import java.util.HashSet;
 import java.util.Optional;
 import java.util.Set;


@Entity
@Table(name = "users")
 @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean enabled;
    private String nom;
    private String prenom;
    private Date daten;
    private String specialite;
    private String sexe;
    private String adresse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dossiermedicale", referencedColumnName = "id")
    private  DossierMedicale dossiermedicale;



    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles = new HashSet<>();


    public User(Long id, String username, String password, boolean enabled, String nom, String prenom, Date daten, String sexe, String adresse, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nom = nom;
        this.prenom = prenom;
        this.daten = daten;
        this.sexe = sexe;
        this.adresse = adresse;
        this.roles = roles;
    }

    public User(Long id, String username, String password, boolean enabled, String nom, String prenom, Date daten, String specialite, String sexe, String adresse, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nom = nom;
        this.prenom = prenom;
        this.daten = daten;
        this.specialite = specialite;
        this.sexe = sexe;
        this.adresse = adresse;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDaten() {
        return daten;
    }

    public void setDaten(Date daten) {
        this.daten = daten;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public DossierMedicale getDossiermedicale() {
        return dossiermedicale;
    }

    public void setDossiermedicale(DossierMedicale dossiermedicale) {
        this.dossiermedicale = dossiermedicale;
    }
}
