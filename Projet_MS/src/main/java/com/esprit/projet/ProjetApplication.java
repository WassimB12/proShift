package tn.esprit.freelancers.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}
	@Autowired
	 ProjetRepository repository;

	@Bean
	ApplicationRunner init() {
		return (args -> {


			repository.save(new ProjetModel("Sarra","ab",466,""));
			repository.save(new ProjetModel("Mariem","Ch",999,"anglais"));

			repository.findAll().forEach(System.out::println);
		});

	}
}
