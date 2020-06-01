package com.nmr.Service;


import com.nmr.Handler.PriceHandler;
import com.nmr.Model.Contract;
import com.nmr.Model.Motorhome;
import com.nmr.Repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Indicates that this class is a service class
 */
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

    /**
     * Method: 'calculateFullPrice' calls several methods from the PriceHandler class which all calculates parts of the full price.
     *
     * @param contract
     * @param motorhome
     * @return contract
     */
    public Contract calculateFullPrice(Contract contract, Motorhome motorhome) {
        double fullPrice = PriceHandler.calculateFullPrice(contract.getRentalStartDate(), contract.getRentalEndDate(), motorhome.getPricePerDay());
        fullPrice += PriceHandler.calculatePickUpPrice(contract.getPickUpPoint());
        fullPrice += PriceHandler.calculateDropOffPrice(contract.getDropOffPoint());
        fullPrice += PriceHandler.calculateExtraPrice(contract.getBikeRack(), contract.getBedLinen(), contract.getChildSeat(), contract.getPicnicTable(), contract.getChairs(), contract.getGrill(), contract.getLantern(), contract.getFirstAidKit(), contract.getToiletPaper());
        contract.setFullPrice(PriceHandler.calculateCancellationPrice(contract.isActive(), contract.getRentalStartDate(), fullPrice));
        return contract;
    }

    /**
     * Method 'calculatePickUpAndDropOff' calls methods from the PriceHandler class i order to calculate pickup and dropoff price.
     *
     * @param contract
     * @return
     */
    public Contract calculatePickUpAndDropOff(Contract contract) {
        contract.setPickUpPrice(PriceHandler.calculatePickUpPrice(contract.getPickUpPoint()));
        contract.setDropOffPrice(PriceHandler.calculateDropOffPrice(contract.getDropOffPoint()));
        return contract;
    }
}
