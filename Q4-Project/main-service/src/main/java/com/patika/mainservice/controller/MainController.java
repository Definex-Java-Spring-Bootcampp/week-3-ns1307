package com.patika.mainservice.controller;

import com.patika.mainservice.model.Customer;
import com.patika.mainservice.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class MainController
{
    @Autowired
    MainService mainService;


    public Customer createCustomer(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber){
        return mainService.createCustomer(  name,  surname,  birthDate,  email,  password, phoneNumber);
    }

}