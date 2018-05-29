package com.eheio.hello.Service;

import com.eheio.hello.Dao.MaldieDao;
import com.eheio.hello.Dao.MesureDao;
import com.eheio.hello.Model.Mesure;

import java.util.List;

public interface MesureService {
    public void setMesureDao(MesureDao mesureDao);
    public void addMasure(Mesure mesure);
    public void removeMesure(int id);
    public Mesure getMesure(int id);
    public List<Mesure> getMesure();
}
