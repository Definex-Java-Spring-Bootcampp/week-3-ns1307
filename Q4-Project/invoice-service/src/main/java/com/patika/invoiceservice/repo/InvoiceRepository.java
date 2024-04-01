package com.patika.invoiceservice.repo;


import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {

    private List<Integer> invoiceList = new ArrayList<>();

    int lastInvoiceID=0;



    public int createNewInvoice() {
        invoiceList.add(lastInvoiceID);
        lastInvoiceID++;
        return lastInvoiceID-1;
    }

    public List<Integer> getAll() {
        return invoiceList;
    }
}

