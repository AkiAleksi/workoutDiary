package com.example.WorkOut;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.WorkOut.model.repository.TrainingRepository;
import com.example.WorkOut.model.repository.UserRepository;

@SpringBootApplication
public class WorkOutApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkOutApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TrainingRepository repository, UserRepository urepository) {
		return (args) -> {

		};

	}
}
