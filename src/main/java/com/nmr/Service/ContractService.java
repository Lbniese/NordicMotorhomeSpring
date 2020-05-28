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

    public boolean createContract(Contract contract) {
        if (contractRepo.rentalDateValidation(contract.getMotorhomeId(), contract.getRentalStartDate(), contract.getRentalEndDate())) {
            contractRepo.createContract(contract);
            return true;
        } else {
            return false;
        }
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

    public Boolean cancelContract(int id) {
        return contractRepo.cancelContract(id);
    }

    public Contract calculateFullPrice(Contract contract, Motorhome motorhome) {
        double fullPrice = PriceHandler.calculateFullPrice(contract.getRentalStartDate(), contract.getRentalEndDate(), motorhome.getPricePerDay());
        fullPrice += PriceHandler.calculatePickUpPrice(contract.getPickUpPoint());
        fullPrice += PriceHandler.calculateDropOffPrice(contract.getDropOffPoint());
        fullPrice += PriceHandler.calculateExtraPrice(contract.getBikeRack(), contract.getBedLinen(), contract.getChildSeat(), contract.getPicnicTable(), contract.getChairs(), contract.getGrill(), contract.getLantern(), contract.getFirstAidKit(), contract.getToiletPaper());
        contract.setFullPrice(PriceHandler.calculateCancellationFee(contract.isActive(), contract.getRentalStartDate(), fullPrice));
        return contract;
    }

    public Contract calculatePickUpAndDropOff(Contract contract) {
        contract.setPickUpPrice(PriceHandler.calculatePickUpPrice(contract.getPickUpPoint()));
        contract.setDropOffPrice(PriceHandler.calculateDropOffPrice(contract.getDropOffPoint()));
        return contract;
    }
}
