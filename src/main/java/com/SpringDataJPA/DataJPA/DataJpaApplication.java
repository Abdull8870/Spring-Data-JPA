package com.SpringDataJPA.DataJPA;

import com.SpringDataJPA.DataJPA.models.Author;
import com.SpringDataJPA.DataJPA.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataJpaApplication.class, args);

		System.out.println("Hello from Ab's branch");
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}




}
