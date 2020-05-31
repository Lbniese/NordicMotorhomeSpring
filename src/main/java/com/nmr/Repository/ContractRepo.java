package com.nmr.Repository;

import com.nmr.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The spring annotation 'repository' indicates that this is a repository class, and that it can be used for encapsulating, storage, retrieval and search behavior.
 */
@Repository
public class ContractRepo {

    /**
     * Annotating the autowired makes it possible for us to use the JDBC template, which is a class in the spring framework that gives us an easy way to connect to our database and execute SQL queries.
     */
    @Autowired
    JdbcTemplate template;

    /**
     * Method: 'createContract' makes an SQL call and inserts the contract information given in the HTML 'create contract' tab into the MySQL database.
     * Uses the JDBC template to execute the SQL query.
     * @param contract
     * @return
     */
    public Contract createContract(Contract contract) {
        String sql = "INSERT INTO Contract (rentalStartDate, rentalEndDate, pickUpPoint, dropOffPoint, bikeRack, bedLinen, childSeat, picnicTable, chairs, grill, lantern, firstAidKit, toiletPaper ,customerId, motorhomeId, employeeId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, contract.getRentalStartDate(), contract.getRentalEndDate(), contract.getPickUpPoint(), contract.getDropOffPoint(), contract.getBikeRack(), contract.getBedLinen(), contract.getChildSeat(), contract.getPicnicTable(), contract.getChairs(), contract.getGrill(), contract.getLantern(), contract.getFirstAidKit(), contract.getToiletPaper(), contract.getCustomerId(), contract.getMotorhomeId(), contract.getEmployeeId());
        return null;
    }

    /**
     * Method: 'fetchAll' makes an SQL call which selects everything from the contract table. The method uses the Spring RowMapper which automatically maps the attributes of our contract objects.
     * @return JDBC template
     */
    public List<Contract> fetchAll() {
        String sql = "SELECT * FROM Contract";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    /**
     * Method: 'FindContractById' makes an SQL call which selects a specific contract from the database. It uses the Spring rowMapper to map the attributes of the object and creates a contract object.
     * @param id - The method takes an id given by the pathVariable annotation in our HomeController.
     * @return - The method returns the specific contract which is used when updating a contract and when retrieving specific contract information for an invoice.
     */
    public Contract findContractById(int id) {
        String sql = "SELECT * FROM Contract WHERE id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract contract = template.queryForObject(sql, rowMapper, id);
        return contract;
    }

    /**
     * Method: 'deleteContract' makes an SQL call which deletes a specific contract from database.
     * @param id
     * @return
     */
    public Boolean deleteContract(int id) {
        String sql = "DELETE FROM Contract WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    /**
     * Method: 'cancelContract' makes an SQL call which updates the active field to 0, which, since it is a boolean, means it is now false. This is used in the PriceHandler class when calculating the cancellation fee.
     * @param id
     * @return
     */
    public Boolean cancelContract(int id) {
        String sql = "UPDATE Contract SET active=? WHERE id=?";
        return template.update(sql, 0, id) > 0;

    }

    /**
     * Method: 'updateContract' makes an SQL call which updates the information in a specific contract
     * @param id
     * @param contract
     * @return
     */
    public Contract updateContract(int id, Contract contract) {
        String sql = "UPDATE Contract SET rentalStartDate=?, rentalEndDate=?, pickUpPoint=?, dropOffPoint=?, miscellaneous=?, customerId=?, motorhomeId=?, employeeId=? WHERE id=?";
        template.update(sql, contract.getRentalStartDate(), contract.getRentalEndDate(), contract.getPickUpPoint(), contract.getDropOffPoint(), contract.getMiscellaneous(), contract.getCustomerId(), contract.getMotorhomeId(), contract.getEmployeeId(), id);
        return null;
    }

    /**
     * Method: 'rentalDateValidation' makes an SQL call which counts how many active contracts there is with a specific motorhome in specific rental period.
     * @param motorhomeId
     * @param rentalStartDate
     * @param rentalEndDate
     * @return - The method returns rowCount == 0 which is either true or false. If it is true, it means that there are no active contracts with the specific motorhome in the specific rental period. This us used to make sure the same motorhome is not rented out twice in the same period.
     */
    public boolean rentalDateValidation(int motorhomeId, LocalDateTime rentalStartDate, LocalDateTime rentalEndDate) {
        String sql = "SELECT count(*) FROM Contract WHERE motorhomeId = ? AND active = 1 AND rentalStartDate < ? AND rentalEndDate > ?";
        int rowCount = template.queryForObject(sql, new Object[]{motorhomeId, rentalEndDate, rentalStartDate}, Integer.class);
        return rowCount == 0;
    }
}