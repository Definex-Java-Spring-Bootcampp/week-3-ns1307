package com.patika.invoiceservice.repo;


import com.patika.invoiceservice.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {

    private List<Invoice> invoiceList = new ArrayList<>();

    int lastInvoiceID=0;



    public int getNewInvoiceID() {
        lastInvoiceID++;
        return lastInvoiceID-1;
    }
}

