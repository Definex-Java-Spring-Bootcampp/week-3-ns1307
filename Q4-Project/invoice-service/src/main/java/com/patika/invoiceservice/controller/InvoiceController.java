package com.patika.invoiceservice.controller;

import com.patika.invoiceservice.service.InvoiceService;
import com.patika.invoiceservice.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    @Autowired
    private final InvoiceService invoiceService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int getNewInvoiceID() {
        return invoiceService.getNewInvoiceID();
    }






}
