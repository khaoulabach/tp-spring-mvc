package com.eheio.hello.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="maladie")
public class Maladie {
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="min")
    private float min;
    @Column(name="max")
    private float max;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Mesure> mesureList = new ArrayList<Mesure>();
    @ManyToMany
    @JoinTable(
            name="con_maldie",
            joinColumns=@JoinColumn(name="id_maladie", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id_consultation", referencedColumnName="id"))
    private List<Consultation> consultationList;

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public List<Mesure> getMesureList() {
        return mesureList;
    }

    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public void setMesureList(List<Mesure> mesureList) {
        this.mesureList = mesureList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    @Override
    public String toString() {
        return "Maladie{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
