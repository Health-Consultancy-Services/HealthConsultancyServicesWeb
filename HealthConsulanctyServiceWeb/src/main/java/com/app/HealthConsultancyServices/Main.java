package com.app.HealthConsultancyServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
public class Main {

	public static void main(String[] args) {
		
		ApplicationContext con = SpringApplication.run(Main.class, args);
	}
}
