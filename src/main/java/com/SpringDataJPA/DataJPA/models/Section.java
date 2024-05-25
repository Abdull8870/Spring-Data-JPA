package com.SpringDataJPA.DataJPA.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Section extends BaseEntity{

    private String name;

    private String sectionOrder;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

}
