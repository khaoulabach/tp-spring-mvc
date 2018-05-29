package com.eheio.hello.Service;

import com.eheio.hello.Dao.MaldieDao;
import com.eheio.hello.Dao.PersonneDao;
import com.eheio.hello.Model.Personne;

import java.util.List;

public interface PerssoneService {
    public void setPersonneDao(PersonneDao personneDao);
    public void addPersonne(Personne personne);
    public void removePersonne(int id);
    public Personne getPersonne(int id);
    public List<Personne> getPersonne();
    public List<Personne> getPersonneWithMaldie();
}
