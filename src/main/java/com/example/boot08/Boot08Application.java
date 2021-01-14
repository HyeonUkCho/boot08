package com.example.boot08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Boot08Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot08Application.class, args);
	}

}
