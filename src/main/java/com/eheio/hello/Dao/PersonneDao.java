package com.eheio.hello.Dao;

import com.eheio.hello.Model.Consultation;
import com.eheio.hello.Model.Personne;
import org.hibernate.SessionFactory;

import java.util.List;

public interface PersonneDao {
    public void setSessionFactory(SessionFactory sessionFactory);
    public void addPersonne(Personne personne);
    public void removePersonne(int id);
    public Personne getPersonne(int id);
    public List<Personne> getPersonne();
    public List<Personne> getPersonneWithMaldie();
}
