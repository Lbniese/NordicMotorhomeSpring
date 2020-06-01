package com.nmr.service;

import com.nmr.model.Motorhome;
import com.nmr.repository.MotorhomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeService {
    @Autowired
    MotorhomeRepo motorhomeRepo;

    public Motorhome createMotorhome(Motorhome motorhome) {
        return motorhomeRepo.createMotorhome(motorhome);
    }

    public List<Motorhome> fetchAll() {
        return motorhomeRepo.fetchAll();
    }

    public Motorhome findMotorhomeById(int id) {
        return motorhomeRepo.findMotorhomeById(id);
    }

    public Boolean deleteMotorhome(int id) {
        return motorhomeRepo.deleteMotorhome(id);
    }

    public Motorhome updateMotorhome(int id, Motorhome motorhome) {
        return motorhomeRepo.updateMotorhome(id, motorhome);
    }

    public Motorhome updateSeasonalPrice(int percentage) {
        return null;
    }
}
