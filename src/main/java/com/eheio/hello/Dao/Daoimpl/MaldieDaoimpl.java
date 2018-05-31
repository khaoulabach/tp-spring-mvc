package com.eheio.hello.Dao.Daoimpl;
import com.eheio.hello.Dao.MaldieDao;
import com.eheio.hello.Model.Consultation;
import com.eheio.hello.Model.Maladie;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MaldieDaoimpl implements  MaldieDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void addMaldie(Maladie maladie)
    {
        this.sessionFactory.getCurrentSession().save(maladie);
    }
    public void removeMaldie(int id)
    {
        this.sessionFactory.getCurrentSession().delete(getMaldie(id));
    }
    public Maladie getMaldie(int id){
        return (Maladie) this.sessionFactory.getCurrentSession().get(Maladie.class, id);
    }
    public List<Maladie> getMaldie(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query qry = session.createQuery("from Maladie ");
        return qry.list();
    }
    public List<Maladie> getMaldieWithMesure(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createNativeQuery("select m.nom,ms.nom from Maladie m inner join Mesure ms on m.id=ms.id_maladie  ").list();
    }
    public List<Maladie> getMaldieWithConsultation()
    {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createNativeQuery("select m.nom ,c.obeservation  from Maladie m inner join  con_maldie cm on cm.id_maladie= m.id inner join  Consultation c on cm.id_consultation=c.id  ").list();
    }
}
