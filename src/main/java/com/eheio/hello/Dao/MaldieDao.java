package com.eheio.hello.Dao;

import com.eheio.hello.Model.Consultation;
import com.eheio.hello.Model.Maladie;
import org.hibernate.SessionFactory;

import java.util.List;

public interface MaldieDao {
    public void setSessionFactory(SessionFactory sessionFactory);
    public void addMaldie(Maladie maladie);
    public void removeMaldie(int id);
    public Maladie getMaldie(int id);
    public List<Maladie> getMaldie();
    public List<Maladie> getMaldieWithMesure();
    public List<Maladie> getMaldieWithConsultation();

}
