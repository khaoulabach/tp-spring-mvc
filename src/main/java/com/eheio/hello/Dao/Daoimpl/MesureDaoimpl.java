package com.eheio.hello.Dao.Daoimpl;

import com.eheio.hello.Dao.MesureDao;
import com.eheio.hello.Model.Consultation;
import com.eheio.hello.Model.Mesure;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MesureDaoimpl implements MesureDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void addMasure(Mesure mesure)
    {
        this.sessionFactory.getCurrentSession().save(mesure);
    }
    public void removeMesure(int id){
        this.sessionFactory.getCurrentSession().delete(getMesure(id));

    }
    public Mesure getMesure(int id){
        return (Mesure) this.sessionFactory.getCurrentSession().get(Mesure.class, id);

    }
    public List<Mesure> getMesure(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query qry = session.createQuery("from Mesure ");
        return qry.list();
    }
}
