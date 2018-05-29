package com.eheio.hello.Model;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="mesure")
public class Mesure {
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    @Column(name="nom")
    private String nom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne")
    private Personne m;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_maladie")
    private Personne p;

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Personne getM() {
        return m;
    }

    public Personne getP() {
        return p;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setM(Personne m) {
        this.m = m;
    }

    public void setP(Personne p) {
        this.p = p;
    }
}
