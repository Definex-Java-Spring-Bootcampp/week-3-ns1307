package com.patika.invoiceservice.service;

import com.patika.invoiceservice.model.Invoice;
import com.patika.invoiceservice.repo.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository = new InvoiceRepository();

    public int getNewInvoiceID() {
        return invoiceRepository.getNewInvoiceID();
    }
}
