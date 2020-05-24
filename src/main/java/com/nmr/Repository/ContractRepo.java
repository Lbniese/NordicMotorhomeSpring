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
        String sql = "INSERT INTO Contract (startDate, endDate, pickUpPoint, dropOffPoint, miscellaneous, customerId, motorhomeId, employeeId) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, contract.getStartDate(), contract.getEndDate(), contract.getPickUpPoint(), contract.getDropOffPoint(), contract.getMiscellaneous(), contract.getCustomerId(),contract.getMotorhomeId() , contract.getEmployeeId());
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

    public Contract updateContract(int id, Contract contract){
        String sql = "UPDATE Contract SET startDate=?, endDate=?, pickUpPoint=?, dropOffPoint=?, miscellaneous=?, customerId=?, motorhomeId=?, employeeId=? WHERE id=?";
        template.update(sql, contract.getStartDate(), contract.getEndDate(), contract.getPickUpPoint(), contract.getDropOffPoint(), contract.getMiscellaneous(), contract.getCustomerId(), contract.getMotorhomeId(), contract.getEmployeeId(), id);
        return null;
    }
}