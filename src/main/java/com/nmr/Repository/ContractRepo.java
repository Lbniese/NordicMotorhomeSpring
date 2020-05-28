package com.nmr.Repository;

import com.nmr.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContractRepo {

    @Autowired
    JdbcTemplate template;

    public Contract createContract(Contract contract) {
        String sql = "INSERT INTO Contract (rentalStartDate, rentalEndDate, pickUpPoint, dropOffPoint, bikeRack, bedLinen, childSeat, picnicTable, chairs, grill, lantern, firstAidKit, toiletPaper ,customerId, motorhomeId, employeeId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, contract.getRentalStartDate(), contract.getRentalEndDate(), contract.getPickUpPoint(), contract.getDropOffPoint(), contract.getBikeRack(), contract.getBedLinen(), contract.getChildSeat(), contract.getPicnicTable(), contract.getChairs(), contract.getGrill(), contract.getLantern(), contract.getFirstAidKit(), contract.getToiletPaper(), contract.getCustomerId(),contract.getMotorhomeId() , contract.getEmployeeId());
        return null;
    }

    public List<Contract> fetchAll() {
        String sql = "SELECT * FROM Contract";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    public Contract findContractById(int id) {
        String sql = "SELECT * FROM Contract WHERE id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract contract = template.queryForObject(sql, rowMapper, id);
        return contract;
    }

    public Boolean deleteContract(int id) {
        String sql = "DELETE FROM Contract WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public Boolean cancelContract(int id){
        String sql = "UPDATE Contract SET active=? WHERE id=?";
        return template.update(sql, 0, id) > 0;

    }

    public Contract updateContract(int id, Contract contract){
        String sql = "UPDATE Contract SET rentalStartDate=?, rentalEndDate=?, pickUpPoint=?, dropOffPoint=?, miscellaneous=?, customerId=?, motorhomeId=?, employeeId=? WHERE id=?";
        template.update(sql, contract.getRentalStartDate(), contract.getRentalEndDate(), contract.getPickUpPoint(), contract.getDropOffPoint(), contract.getMiscellaneous(), contract.getCustomerId(), contract.getMotorhomeId(), contract.getEmployeeId(), id);
        return null;
    }

    public boolean rentalDateValidation(int motorhomeId, LocalDateTime rentalStartDate, LocalDateTime rentalEndDate){
        String sql = "SELECT count(*) FROM Contract WHERE motorhomeId = ? AND rentalStartDate < ? AND rentalEndDate > ?";
        int rowCount = template.queryForObject(sql, new Object[] { motorhomeId,rentalEndDate, rentalStartDate }, Integer.class);
        if(rowCount == 0)
            return true;
        return false;
    }
}