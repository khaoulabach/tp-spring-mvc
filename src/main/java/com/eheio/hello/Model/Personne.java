package com.eheio.hello.Model;
import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personne")
public class Personne
{
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="login")
    private String login;
    @Column(name="passwrd")
    private String obeservation;
    @Column(name="role")
    private String role;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Consultation> consultationList = new ArrayList<Consultation>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Mesure> Listmesure = new ArrayList<Mesure>();

}
