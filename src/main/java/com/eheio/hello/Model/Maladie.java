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

}
