package com.nmr.Repository;

import com.nmr.Model.Invoice;
import com.nmr.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepo {

    @Autowired
    JdbcTemplate template;

    public Invoice createInvoice(Invoice invoice) {
        String sql = "INSERT INTO Invoice (fullPrice, customerId, motorhomeId, employeeId, contractId) VALUES(?, ?, ?, ?, ?)";
        template.update(sql, invoice.getTotalPrice(), invoice.getCustomerId(), invoice.getMotorhomeId(), invoice.getEmployeeId(), invoice.getContractId());
        return null;
    }
}
