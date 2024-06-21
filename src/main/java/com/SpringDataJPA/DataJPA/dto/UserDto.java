package com.SpringDataJPA.DataJPA.dto;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserDto {

    private Integer id;

    private String username;

    private String firstName;

    private String lastName;

}
