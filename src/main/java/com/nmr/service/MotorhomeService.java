package com.nmr.service;

import com.nmr.model.Motorhome;
import com.nmr.repository.MotorhomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeService {
    @Autowired
    MotorhomeRepo motorhomeRepo;

    /**
     * createMotorhome()
     * @param motorhome
     * @return
     */
    public Motorhome createMotorhome(Motorhome motorhome) {
        return motorhomeRepo.createMotorhome(motorhome);
    }

    /**
     * fetchAll()
     * @return
     */
    public List<Motorhome> fetchAll() {
        return motorhomeRepo.fetchAll();
    }

    /**
     * findMotorhomeById()
     * @param id
     * @return
     */
    public Motorhome findMotorhomeById(int id) {
        return motorhomeRepo.findMotorhomeById(id);
    }

    /**
     * deleteMotorhome()
     * @param id
     * @return
     */
    public Boolean deleteMotorhome(int id) {
        try {
            return motorhomeRepo.deleteMotorhome(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    /**
     * updateMotorhome()
     * @param id
     * @param motorhome
     * @return
     */
    public Motorhome updateMotorhome(int id, Motorhome motorhome) {
        return motorhomeRepo.updateMotorhome(id, motorhome);
    }


    /**
     * addKilometersToOdometer()
     * @param id
     * @param kmDriven
     */
    public void addKilometersToOdometer(int id, int kmDriven) {
        Motorhome motorhome = motorhomeRepo.findMotorhomeById(id);
        int newOdometer = motorhome.getOdometer();
        newOdometer += kmDriven;
        motorhome.setOdometer(newOdometer);
        motorhomeRepo.updateOdometer(id, motorhome);
    }
}