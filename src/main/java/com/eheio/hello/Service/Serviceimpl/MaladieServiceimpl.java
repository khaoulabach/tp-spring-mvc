package com.eheio.hello.Service.Serviceimpl;

import com.eheio.hello.Dao.MaldieDao;
import com.eheio.hello.Model.Maladie;
import com.eheio.hello.Service.MaldieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public class MaladieServiceimpl implements MaldieService {


    private MaldieDao maladieDao;
    @Autowired
    @Qualifier("maldieDao")
    public void setMaladieDao(MaldieDao maladieDao) {
     this.maladieDao=maladieDao;
    }

    @Transactional
    public void addMaldie(Maladie maladie) {
       maladieDao.addMaldie(maladie);
    }

    @Transactional
    public void removeMaldie(int id) {
     maladieDao.removeMaldie(id);
    }

    @Transactional
    public Maladie getMaldie(int id) {
        return maladieDao.getMaldie(id);
    }

    @Transactional
    public List<Maladie> getMaldie() {
        return maladieDao.getMaldie();
    }

    @Transactional
    public List<Maladie> getPerssoneWithMaldie() {
        return maladieDao.getPerssoneWithMaldie();
    }

    @Transactional
    public List<Maladie> getMaldieWithConsultation() {
        return maladieDao.getMaldieWithConsultation();
    }
}
