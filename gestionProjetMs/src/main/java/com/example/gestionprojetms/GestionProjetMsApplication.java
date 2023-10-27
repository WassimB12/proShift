package com.example.gestionprojetms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionProjetMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionProjetMsApplication.class, args);
	}

}
