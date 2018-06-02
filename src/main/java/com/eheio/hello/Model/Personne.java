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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="login")
    private String login;
    @Column(name="passwrd")
    private String passwrd;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    public void setListmesure(List<Mesure> listmesure) {
        Listmesure = listmesure;
    }

    public Integer getId() {

        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public String getRole() {
        return role;
    }

    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public List<Mesure> getListmesure() {
        return Listmesure;
    }


    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
