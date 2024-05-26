package com.SpringDataJPA.DataJPA.repositories;

import com.SpringDataJPA.DataJPA.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

//    Select * from author where first_name='{variable}'
    @Transactional
    @Modifying
    @Query("update Author a set a.age=:age where a.id=:id")
    int updateAge(int age,int id);

    List<Author> findAllByFirstName(String firstName);

    List<Author> findAllByLastName(String lastName);

    @Transactional
    @Modifying
    @Query(value ="Select * from Author a where a.age>:age",nativeQuery = true)
    List<Author> getAllAuthorsByAge(int age);

}
