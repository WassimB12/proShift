package com.esprit.gestionTacheMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class gestionTacheMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(gestionTacheMsApplication.class, args);
    }

}
