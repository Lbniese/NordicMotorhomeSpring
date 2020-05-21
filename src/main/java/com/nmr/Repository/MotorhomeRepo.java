package com.nmr.Repository;


import com.nmr.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepo {
    @Autowired
    JdbcTemplate template;

    public Motorhome createMotorhome(Motorhome motorhome) {
        String sql = "INSERT INTO Motorhome (brand, model, odometer, size, type, pricePerDay, serviceNotes) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, motorhome.getBrand(), motorhome.getModel(), motorhome.getOdometer(), motorhome.getSize(), motorhome.getType(), motorhome.getPricePerDay(), motorhome.getServiceNotes());
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

    public Motorhome updateMotorhome(int id, Motorhome motorhome){
        String sql = "UPDATE Motorhome SET brand=?, model=?, odometer=?, size=?, type=?, pricePerDay=?, serviceNotes=? WHERE id=?";
        template.update(sql, motorhome.getBrand(), motorhome.getModel(), motorhome.getOdometer(), motorhome.getSize(), motorhome.getType(), motorhome.getPricePerDay(), motorhome.getServiceNotes(), id);
        return null;
    }

}
