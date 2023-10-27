package com.esprit.equipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class gestionEquipeMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(gestionEquipeMsApplication.class, args);
    }
}


