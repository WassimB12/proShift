package com.esprit.demandeemploi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.esprit.demandeemploi.OffreEmploiModel;
import com.esprit.demandeemploi.OffreEmploiRepository;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class DemandeEmploiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemandeEmploiApplication.class, args);
    }
    @Autowired
    OffreEmploiRepository repository;
    @Bean
    ApplicationRunner init() {
        return (args -> {
            repository.save(new OffreEmploiModel("Développeur Java Senior", "Type d'emploi", "Compétences requises","Adresse email", new Date(), "Statut"));
        });
    }

}
