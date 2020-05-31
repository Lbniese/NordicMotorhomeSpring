package com.nmr.Repository;

import com.nmr.Model.Employee;
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
public class EmployeeRepo {

    /**
     * Annotating the autowired makes it possible for us to use the JDBC template, which is a class in the spring framework that gives us an easy way to connect to our database and execute SQL queries.
     */
    @Autowired
    JdbcTemplate template;

    /**
     * Method: 'createEmployee' makes an SQL call and inserts the employee information given in the HTML 'create employee' tab into the MySQL database.
     * Uses the JDBC template to execute the SQL query.
     * @param employee
     * @return null
     */
    public Employee createEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (firstName, lastName, phoneNumber, email, address, title, zipCode) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, employee.getFirstName(), employee.getLastName(), employee.getPhoneNumber(), employee.getEmail(), employee.getAddress(), employee.getTitle(), employee.getZipCode());
        return null;
    }

    public List<Employee> fetchAll() {
        String sql = "SELECT * FROM Employee e JOIN Zipcode z ON e.zipCode = z.zipCode";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public Employee findEmployeeById(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = template.queryForObject(sql, rowMapper, id);
        return employee;
    }

    public Boolean deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public Employee updateEmployee(int id, Employee employee) {
        String sql = "UPDATE Employee SET firstName=?, lastName=?, phoneNumber=?, email=?, address=?, title=?, zipCode=? WHERE id=?";
        template.update(sql, employee.getFirstName(), employee.getLastName(), employee.getPhoneNumber(), employee.getEmail(), employee.getAddress(), employee.getTitle(), employee.getZipCode(), id);
        return null;
    }
}
