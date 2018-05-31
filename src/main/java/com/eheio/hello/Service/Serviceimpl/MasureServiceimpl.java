package com.eheio.hello.Service.Serviceimpl;

import com.eheio.hello.Dao.MesureDao;
import com.eheio.hello.Model.Mesure;
import com.eheio.hello.Service.MesureService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class MasureServiceimpl implements MesureService {

     private MesureDao  mesureDao;
    @Autowired
    public void setMesureDao(MesureDao mesureDao) {
        this.mesureDao=mesureDao;
    }

    @Transactional
    public void addMasure(Mesure mesure) {
     mesureDao.addMasure(mesure);
    }

    @Transactional
    public void removeMesure(int id) {
        mesureDao.removeMesure(id);

    }

    @Transactional
    public Mesure getMesure(int id) {
        return mesureDao.getMesure(id);
    }

    @Transactional
    public List<Mesure> getMesure() {
        return mesureDao.getMesure();
    }
}
