package com.nmr.repository;

import com.nmr.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The spring annotation 'repository' indicates that this is a repository class, and that it can be used for encapsulating, storage, retrieval and search behavior.
 */
@Repository
public class CustomerRepo {

    /**
     * Annotating the autowired makes it possible for us to use the JDBC template, which is a class in the spring framework that gives us an easy way to connect to our database and execute SQL queries.
     */
    @Autowired
    JdbcTemplate template;

    /**
     * Method: 'createCustomer' makes an SQL call and inserts the customer information given in the HTML 'create customer' tab into the MySQL database.
     * Uses the JDBC template to execute the SQL query.
     *
     * @param customer
     * @return null
     */
    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (firstName, lastName, phoneNumber, email, address, driverLicenceNumber, zipCode) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber(), customer.getEmail(), customer.getAddress(), customer.getDriverLicenceNumber(), customer.getZipCode());
        return null;
    }

    /**
     * Method: 'fetchAll' makes an SQL call which selects everything from the customer table. The method uses the Spring RowMapper which automatically maps the attributes of our customer objects.
     *
     * @return JDBC template
     */
    public List<Customer> fetchAll() {
        String sql = "SELECT * FROM Customer c JOIN Zipcode z ON c.zipCode = z.zipCode";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    /**
     * Method: 'FindCustomerById' makes an SQL call which selects a specific customer from the database. It uses the Spring rowMapper to map the attributes of the object and creates a customer object.
     *
     * @param id - The method takes an id given by the pathVariable annotation in our HomeController.
     * @return - The method returns the specific customer which is used when updating a customer and when retrieving specific customer information for an invoice.
     */
    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sql, rowMapper, id);
        return customer;
    }

    /**
     * Method: 'deleteCustomer' makes an SQL call which deletes a specific customer from the database.
     *
     * @param id
     * @return
     */
    public Boolean deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    /**
     * Method: 'updateCustomer' makes an SQL call which updates the information for a specific customer
     *
     * @param id
     * @param customer
     * @return null
     */
    public Customer updateCustomer(int id, Customer customer) {
        String sql = "UPDATE Customer SET firstName=?, lastName=?, phoneNumber=?, email=?, address=?, driverLicenceNumber=?, zipCode=? WHERE id=?";
        template.update(sql, customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber(), customer.getEmail(), customer.getAddress(), customer.getDriverLicenceNumber(), customer.getZipCode(), id);
        return null;
    }
}
