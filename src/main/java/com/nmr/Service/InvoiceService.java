package com.nmr.Service;

import com.nmr.Model.Invoice;
import com.nmr.Model.Motorhome;
import com.nmr.Repository.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepo invoiceRepo;

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepo.createInvoice(invoice);
    }
}
