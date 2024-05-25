package com.SpringDataJPA.DataJPA.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity{


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
