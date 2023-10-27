package com.esprit.freelancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import com.esprit.freelancer.FreelancersRepository;


@SpringBootApplication
@EnableEurekaClient

public class FreelancersInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelancersInfoApplication.class, args);
    }

    @Autowired
    FreelancersRepository repository;
    @Bean
    ApplicationRunner init() {
        return args -> {
           // repository.save(new FreelancersModel("name", "family_name", "male", "mdp", "address", "email@example.com"));
        };
    }
}


