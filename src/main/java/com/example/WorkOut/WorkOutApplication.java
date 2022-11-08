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

			// Your code...add some demo data to db
			// Training first = new Training(1, "Aki Hietamäki", "Golden Six", "46 min");
			// Training two = new Training(2, "Pekka Jokunen", "Yoga", "1 h");
			// Training three = new Training(3, "Tatu Toivonen", "Pilates", "2 y");

			// if (repository.findByName(first.getName()) == null) {
			// repository.save(first);
			// }

			// if (repository.findByName(two.getName()) == null) {
			// repository.save(two);
			// }

			// if (repository.findByName(three.getName()) == null) {
			// repository.save(three);
			// }
		};

	}
}
