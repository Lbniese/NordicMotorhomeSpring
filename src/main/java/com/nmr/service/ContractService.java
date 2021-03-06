package com.nmr.service;


import com.nmr.handler.PriceHandler;
import com.nmr.model.Contract;
import com.nmr.model.Motorhome;
import com.nmr.repository.ContractRepo;
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

    @Autowired
    MotorhomeService motorhomeService;

    /**
     * fetchAll()
     * @return
     */
    public List<Contract> fetchAll() {
        return contractRepo.fetchAll();
    }

    /**
     * createContract()
     * @param contract
     * @return
     */
    public boolean createContract(Contract contract) {
        boolean noOverlap = contractRepo.rentalDateValidation(contract.getMotorhomeId(), contract.getRentalStartDate(), contract.getRentalEndDate());
        if (noOverlap) {
            contractRepo.createContract(contract);
            return true;
        } else {
            return false;
        }
    }

    /**
     * findContractById()
     * @param id
     * @return
     */
    public Contract findContractById(int id) {
        return contractRepo.findContractById(id);
    }

    /**
     * deleteContract()
     * @param id
     * @return
     */
    public Boolean deleteContract(int id) {
        return contractRepo.deleteContract(id);
    }

    /**
     * updateContract()
     * @param id
     * @param contract
     * @return
     */
    public Contract updateContract(int id, Contract contract) {
        return contractRepo.updateContract(id, contract);
    }

    /**
     * cancelContract()
     * @param id
     * @return
     */
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
        fullPrice += PriceHandler.calculateFuelFee(contract.isFuelCharge());
        fullPrice += PriceHandler.calculateDrivenPrice(contract.getRentalStartDate(), contract.getRentalEndDate(), contract.getKmDriven());
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

    /**
     * completeContract()
     * @param id
     * @param contract
     * @return
     */
    public Contract completeContract(int id, Contract contract) {
        contractRepo.completeContract(id, contract);
        motorhomeService.addKilometersToOdometer(contract.getMotorhomeId(), contract.getKmDriven());
        return contract;
    }


}
