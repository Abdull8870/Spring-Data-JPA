package com.SpringDataJPA.DataJPA.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Resource extends BaseEntity{

    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(name="lecture_id")
    private Lecture lecture;

}
