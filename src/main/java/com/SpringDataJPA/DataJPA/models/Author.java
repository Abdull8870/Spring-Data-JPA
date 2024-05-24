package com.SpringDataJPA.DataJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
public class Author {


    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

}
