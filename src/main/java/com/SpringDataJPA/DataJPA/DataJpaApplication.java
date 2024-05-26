package com.SpringDataJPA.DataJPA;

import com.SpringDataJPA.DataJPA.models.Author;
import com.SpringDataJPA.DataJPA.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataJpaApplication.class, args);

		System.out.println("Hello from Ab's branch");
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repo){
		return args -> {

//			Faker fake=new Faker();
//			for(int i=0;i<50;i++){
//				var autho=Author.builder().
//						firstName(fake.name().firstName()).
//						lastName(fake.name().lastName()).
//						email(fake.name().firstName()+i+"@email.com").
//						age(fake.number().numberBetween(20,80)).build();
//				repo.save(autho);
//			}

			List<Author> allAuthorsByAge = repo.getAllAuthorsByAge(20);

			for(Author auth:allAuthorsByAge){
				System.out.println(auth.getFirstName()+" "+auth.getAge());

			}

		};
	}



}
