package com.patika.customerservice.controller;

import com.patika.customerservice.model.Customer;
import com.patika.customerservice.model.Order;
import com.patika.customerservice.service.CustomerService;
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
@RequestMapping("/api/customers/")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService customerService;


    @PostMapping("new-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        Customer createdProduct = customerService.addNewCustomer(customer);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("{email}")
    public ResponseEntity<Customer> getByID(@PathVariable("email") String email) {

        Optional<Customer> foundCustomer= customerService.getByEmail(email);

        return foundCustomer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("update/{email}")
    public Customer addNewProductWithQuantity(@PathVariable("email") String email,@RequestParam("invoiceNo") int invoiceNo) {

        Order order= WebClient.builder().baseUrl("http://localhost:8084").build().get().uri("/api/orders/"+Integer.toString(invoiceNo)).retrieve().bodyToMono(Order.class).block();
        return customerService.addNewOrder(email,order);
    }



    @GetMapping("all")
    @ResponseStatus(HttpStatus.CREATED)
    protected List<Customer> getAllCustomers() {
        return customerService.getAll();
    }


}
