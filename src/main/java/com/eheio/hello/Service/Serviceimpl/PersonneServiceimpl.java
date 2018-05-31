package com.eheio.hello.Service.Serviceimpl;

import com.eheio.hello.Dao.PersonneDao;
import com.eheio.hello.Model.Personne;
import com.eheio.hello.Service.PerssoneService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class PersonneServiceimpl implements PerssoneService {

     private  PersonneDao  personneDao;
    @Autowired
    public void setPersonneDao(PersonneDao personneDao) {
        this.personneDao=personneDao;
    }

    @Transactional
    public void addPersonne(Personne personne) {
      personneDao.addPersonne(personne);
    }

    @Transactional
    public void removePersonne(int id) {
        personneDao.removePersonne(id);

    }

    @Transactional
    public Personne getPersonne(int id) {
        return personneDao.getPersonne(id);
    }

    @Transactional
    public List<Personne> getPersonne() {
        return personneDao.getPersonne();
    }

    @Transactional
    public List<Personne> getPersonneWithMaldie() {
        return personneDao.getPersonneWithMaldie();
    }
}
