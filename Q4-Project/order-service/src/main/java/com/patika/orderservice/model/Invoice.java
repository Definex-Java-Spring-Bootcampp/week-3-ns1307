package com.patika.orderservice.model;

public class Invoice {

    int invoiceNo;


    public Invoice() {
        this.invoiceNo = 0;
    }
    public Invoice(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
}
