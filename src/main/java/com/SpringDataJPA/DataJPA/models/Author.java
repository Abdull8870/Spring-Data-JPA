package com.SpringDataJPA.DataJPA.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Author {

  @Id
  @GeneratedValue
    private Integer id;

    @Column(
            name="f_name"
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true
    )
    private String email;

    private int age;

    @ManyToMany(
            mappedBy = "authors"
    )
    private List<Course> course;


}
