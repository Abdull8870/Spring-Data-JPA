package com.SpringDataJPA.DataJPA;

import com.SpringDataJPA.DataJPA.models.Author;
import com.SpringDataJPA.DataJPA.models.Video;
import com.SpringDataJPA.DataJPA.repositories.AuthorRepository;
import com.SpringDataJPA.DataJPA.repositories.VideoRepository;
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
	public CommandLineRunner commandLineRunner(
			VideoRepository repo){
		return args -> {

			var video= Video.builder().
					name("New Video").length(5).build();

			repo.save(video);

		};
	}



}
