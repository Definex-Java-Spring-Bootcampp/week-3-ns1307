package com.patika.orderservice.controller;


import com.patika.orderservice.model.Invoice;
import com.patika.orderservice.model.Order;
import com.patika.orderservice.model.Product;
import com.patika.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders/")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping("new-order")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createNewOrder() {
        Invoice invoice= new Invoice(getInvoiceID());
        return orderService.createNewOrder(invoice);
    }



    @PutMapping("update/{invoiceID}")
    public Order addNewProductWithQuantity(@PathVariable("invoiceID") int invoiceID,@RequestParam("productID") int productID,@RequestParam("quantity") int quantity) {

        Product product= WebClient.builder().baseUrl("http://localhost:8084").build().get().uri("/api/products/"+Integer.toString(productID)).retrieve().bodyToMono(Product.class).block();
        return orderService.addProduct(invoiceID,product,quantity);
    }
    @GetMapping("all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @GetMapping("{invoiceNo}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> getOrderByinvoiceNo(@PathVariable("invoiceNo") int invoiceNo) {
        Optional<Order> foundOrder = orderService.getOrderByinvoiceNo(invoiceNo);
        return  foundOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    private int getInvoiceID() {
        //invoice-service api üzerinden çek
        return WebClient.builder().baseUrl("http://localhost:8084").build().get().uri("/api/invoices/unique-id").retrieve().bodyToMono(Integer.class).block();

    }







}
