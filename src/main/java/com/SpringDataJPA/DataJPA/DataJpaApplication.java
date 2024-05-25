package com.SpringDataJPA.DataJPA;

import com.SpringDataJPA.DataJPA.models.Author;
import com.SpringDataJPA.DataJPA.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataJpaApplication.class, args);

		System.out.println("Hello from Ab's branch");
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository){
		return args -> {
			var author= Author.builder().
					firstName("Virat").
					lastName("Kohli").
					age(35).email("virat@Ipl.com").build();

			authorRepository.save(author);

		};
	}



}
