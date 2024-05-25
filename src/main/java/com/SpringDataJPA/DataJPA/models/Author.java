package com.SpringDataJPA.DataJPA.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
//@Table(name = "AUTHOR_TABLE")
public class Author {



    /*(
            strategy = GenerationType.SEQUENCE,
            generator = "author_id_gen"
    )

   */
/*    @TableGenerator(
             name="author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
            )

 */

  /*  @SequenceGenerator(
            name="author_sequence",
            sequenceName ="author_sequence",
            allocationSize = 1
    )

   */
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

    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;

}
