package com.eheio.hello.Dao;

import com.eheio.hello.Model.Consultation;
import org.hibernate.SessionFactory;

import java.util.List;

public interface ConsultationDao {
    public void setSessionFactory(SessionFactory sessionFactory);
    public void addConsultation(Consultation consultation);
    public void removeConsultation(int id);
    public Consultation getConsultation(int id);
    public List<Consultation> getConsultations();
    public List<Consultation> getConsultationWithMaldie();
}
