package com.patika.mainservice;


import com.patika.mainservice.controller.MainController;
import com.patika.mainservice.model.Customer;
import com.patika.mainservice.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
public class MainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainServiceApplication.class, args);
		MainService mainService=new MainService();
		Customer customer1= mainService.createCustomer("Enes","Yurtcu", LocalDate.of(1999,01,28),"enes_yurtcu@hotmail.com","123456","5554443322");
	}

}
