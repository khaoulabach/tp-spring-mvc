package com.eheio.hello.Service;

import com.eheio.hello.Dao.ConsultationDao;
import com.eheio.hello.Model.Consultation;

import java.util.List;

public interface ConsultationService {

    public void setConsultationDao(ConsultationDao consultationDao);
    public void addConsultation(Consultation consultation);
    public void removeConsultation(int id);
    public Consultation getConsultation(int id);
    public List<Consultation> getConsultations();
    public List<Consultation> getConsultationWithMaldie();
}
