package com.patika.invoiceservice.controller;

import com.patika.invoiceservice.service.InvoiceService;
import com.patika.invoiceservice.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices/")
@RequiredArgsConstructor
public class InvoiceController {

    @Autowired
    private final InvoiceService invoiceService;

    @GetMapping("unique-id")
    @ResponseStatus(HttpStatus.CREATED)
    public int getNewInvoiceID() {
        return invoiceService.createNewInvoice();
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Integer> getAllInvoices() {
        return invoiceService.getAll();
    }








}
