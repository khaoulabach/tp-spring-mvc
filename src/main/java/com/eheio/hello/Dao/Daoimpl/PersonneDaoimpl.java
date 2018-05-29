package com.eheio.hello.Dao.Daoimpl;

import com.eheio.hello.Dao.PersonneDao;
import com.eheio.hello.Model.Consultation;
import com.eheio.hello.Model.Personne;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonneDaoimpl implements PersonneDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void addPersonne(Personne personne)
    {
        this.sessionFactory.getCurrentSession().save(personne);
    }
    public void removePersonne(int id){
        this.sessionFactory.getCurrentSession().delete(getPersonne(id));
    }
    public Personne getPersonne(int id)
    {
        return (Personne) this.sessionFactory.getCurrentSession().get(Personne.class, id);
    }
    public List<Personne> getPersonne()
    {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query qry = session.createQuery("from Personne ");
        return qry.list();
    }
    public List<Personne> getPersonneWithMaldie(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createNativeQuery("select  p.nom ,p.prenom ,ml.nom from Personne p  inner join Mesure m on m.id_personne =p.id inner join Maladie ml on m.id_maladie=ml.id ").list();
    }
}