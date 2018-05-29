package com.eheio.hello.Service.Serviceimpl;

import com.eheio.hello.Dao.ConsultationDao;
import com.eheio.hello.Model.Consultation;
import com.eheio.hello.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ConsultationServiceimpl implements ConsultationService {
    @Autowired
    private ConsultationDao consultationDao;
    public void setConsultationDao(ConsultationDao consultationDao) {
        this.consultationDao = consultationDao;
    }
    @Transactional
    public void addConsultation(Consultation consultation) {
        consultationDao.addConsultation(consultation);
    }

    @Transactional
    public void removeConsultation(int id) {

        consultationDao.removeConsultation(id);
    }

    @Transactional
    public Consultation getConsultation(int id) {
        return consultationDao.getConsultation(id);
    }

    @Transactional
    public List<Consultation> getConsultations() {
        return consultationDao.getConsultations();
    }

    @Transactional
    public List<Consultation> getConsultationWithMaldie() {
        return consultationDao.getConsultationWithMaldie();
    }
}
