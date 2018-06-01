package com.eheio.hello.Dao.Daoimpl;

import com.eheio.hello.Dao.PersonneDao;
import com.eheio.hello.Model.Consultation;
import com.eheio.hello.Model.Personne;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
        org.hibernate.query.Query<Personne> query = session.createQuery("from Personne");
        return query.getResultList();
    }
    public List<Personne> getPersonneWithMaldie(){

        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createNativeQuery("select p.nom ,p.prenom from Personne p ").list();

    }
}
