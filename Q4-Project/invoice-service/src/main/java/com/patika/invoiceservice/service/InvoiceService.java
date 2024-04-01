package com.patika.invoiceservice.service;

import com.patika.invoiceservice.Producer.RequestProducer;
import com.patika.invoiceservice.repo.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Scope(value = "singleton")
@RequiredArgsConstructor
public class InvoiceService {
    private InvoiceRepository invoiceRepository = new InvoiceRepository();
    private final RequestProducer requestProducer;


    public int createNewInvoice() {
        requestProducer.sendRequest();
        return invoiceRepository.createNewInvoice();
    }

    public List<Integer> getAll() {
        return invoiceRepository.getAll();
    }
}
