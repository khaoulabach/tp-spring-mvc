package com.eheio.hello.Service;

import com.eheio.hello.Dao.ConsultationDao;
import com.eheio.hello.Dao.MaldieDao;
import com.eheio.hello.Model.Maladie;

import java.util.List;

public interface MaldieService {
    public void setMaladieDao(MaldieDao maladieDao);
    public void addMaldie(Maladie maladie);
    public void removeMaldie(int id);
    public Maladie getMaldie(int id);
    public List<Maladie> getMaldie();
    public List<Maladie> getPerssoneWithMaldie();
    public List<Maladie> getMaldieWithConsultation();
}
