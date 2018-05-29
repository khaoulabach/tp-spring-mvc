package com.eheio.hello.Dao;

import com.eheio.hello.Model.Mesure;
import org.hibernate.SessionFactory;

import java.util.List;

public interface MesureDao {
    public void setSessionFactory(SessionFactory sessionFactory);
    public void addMasure(Mesure mesure);
    public void removeMesure(int id);
    public Mesure getMesure(int id);
    public List<Mesure> getMesure();
}
