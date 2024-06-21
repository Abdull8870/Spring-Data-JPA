package com.SpringDataJPA.DataJPA.services;

import com.SpringDataJPA.DataJPA.dto.UserDto;
import com.SpringDataJPA.DataJPA.entity.User;

import java.util.List;


public interface UserService {

    UserDto registerUser(User user);

    User updatePassword(String username,String password);

    User updateEmail(String username,String email);

    void removeUser(String username);

    UserDto getUser(Long id);

    List<UserDto> getAllUsers();


}
