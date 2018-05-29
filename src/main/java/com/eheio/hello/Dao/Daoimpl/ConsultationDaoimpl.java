package com.eheio.hello.Dao.Daoimpl;

import com.eheio.hello.Dao.ConsultationDao;
import com.eheio.hello.Model.Consultation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class ConsultationDaoimpl implements ConsultationDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addConsultation(Consultation consultation) {
        this.sessionFactory.getCurrentSession().save(consultation);
    }
    public void removeConsultation(int id) {
        this.sessionFactory.getCurrentSession().delete(getConsultation(id));

    }
    public Consultation getConsultation(int id) {
        return (Consultation) this.sessionFactory.getCurrentSession().get(Consultation.class, id);
    }
    public List<Consultation> getConsultations() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query qry = session.createQuery("from Consultation");
        return qry.list();
    }

    public List<Consultation> getConsultationWithMaldie() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createNativeQuery("select c.id, c.obeservation,c.date , p.nom ,p.prenom from Consultation c inner join Personne p on p.id = c.id_patient ").list();
    }

}
