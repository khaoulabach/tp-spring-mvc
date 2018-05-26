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
}
