package com.esprit.gestionProjetMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class gestionProjetMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(gestionProjetMsApplication.class, args);
    }

}
