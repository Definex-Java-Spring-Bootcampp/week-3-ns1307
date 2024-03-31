package com.patika.projectdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProjectDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectDiscoveryApplication.class, args);
	}

}
