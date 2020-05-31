package com.nmr.Repository;


import com.nmr.Model.Motorhome;
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
public class MotorhomeRepo {

    /**
     * Annotating the autowired makes it possible for us to use the JDBC template, which is a class in the spring framework that gives us an easy way to connect to our database and execute SQL queries.
     */
    @Autowired
    JdbcTemplate template;

    /**
     * Method: 'createMotorhome' makes an SQL call and inserts the motorhome information given in the HTML 'create motorhome' tab into the MySQL database.
     * Uses the JDBC template to execute the SQL query.
     * @param motorhome
     * @return null
     */
    public Motorhome createMotorhome(Motorhome motorhome) {
        String sql = "INSERT INTO Motorhome (brand, model, odometer, vehicleSize, vehicleType, pricePerDay, serviceNote) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, motorhome.getBrand(), motorhome.getModel(), motorhome.getOdometer(), motorhome.getVehicleSize(), motorhome.getVehicleType(), motorhome.getPricePerDay(), motorhome.getServiceNote());
        return null;
    }

    public List<Motorhome> fetchAll() {
        String sql = "SELECT * FROM Motorhome";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(sql, rowMapper);
    }

    public Motorhome findMotorhomeById(int id) {
        String sql = "SELECT * FROM Motorhome WHERE id = ?";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        Motorhome motorhome = template.queryForObject(sql, rowMapper, id);
        return motorhome;
    }

    public Boolean deleteMotorhome(int id) {
        String sql = "DELETE FROM Motorhome WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public Motorhome updateMotorhome(int id, Motorhome motorhome) {
        String sql = "UPDATE Motorhome SET brand=?, model=?, odometer=?, vehicleSize=?, vehicleType=?, pricePerDay=?, serviceNote=? WHERE id=?";
        template.update(sql, motorhome.getBrand(), motorhome.getModel(), motorhome.getOdometer(), motorhome.getVehicleSize(), motorhome.getVehicleType(), motorhome.getPricePerDay(), motorhome.getServiceNote(), id);
        return null;
    }

}
