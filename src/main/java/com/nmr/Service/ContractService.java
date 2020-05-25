package com.nmr.Service;


import com.nmr.Handler.PriceHandler;
import com.nmr.Model.Contract;
import com.nmr.Model.Motorhome;
import com.nmr.Repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    ContractRepo contractRepo;

    public List<Contract> fetchAll() {
        return contractRepo.fetchAll();
    }

    public Contract createContract(Contract contract) {
        return contractRepo.createContract(contract);
    }

    public Contract findContractById(int id) {
        return contractRepo.findContractById(id);
    }

    public Boolean deleteContract(int id) {
        return contractRepo.deleteContract(id);
    }

    public Contract updateContract(int id, Contract contract) {
        return contractRepo.updateContract(id, contract);
    }

    public Contract calulateFullPrice(Contract contract, Motorhome motorhome){
        contract.setFullPrice(PriceHandler.calculateFullPrice(contract.getRentalStartDate(), contract.getRentalEndDate(), motorhome.getPricePerDay()));
        return contract;
    }

}
