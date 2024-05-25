package com.SpringDataJPA.DataJPA.repositories;

import com.SpringDataJPA.DataJPA.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
