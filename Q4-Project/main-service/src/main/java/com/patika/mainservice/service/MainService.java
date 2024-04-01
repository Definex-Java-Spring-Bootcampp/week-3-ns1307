package com.patika.mainservice.service;

import com.patika.mainservice.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
@Service
public class MainService {


    public Customer createCustomer(String name, String surname, LocalDate birthdate, String email, String password, String phoneNumber) {
        String orderJson = "{\n" +
                "  \"name\":"+name+",\n" +
                "  \"surname\": "+surname+",\n" +
                "  \"birthDate\":"+birthdate.toString()+",\n" +
                "  \"email\":"+email+",\n" +
                "  \"password\":"+password+",\n" +
                "  \"phoneNumber\":"+phoneNumber+",\n" +
                "  \"active\": true,\n" +
                "  \"orderList\": []\n" +
                "}";

        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8084")
                .build();

        Customer customer = client.post()
                .uri("/api/customers/new-customer")
                .header("Content-Type", "application/json")
                .body(Mono.just(orderJson), String.class)
                .retrieve()
                .bodyToMono(Customer.class)
                .block();

        return customer;
    }
}
