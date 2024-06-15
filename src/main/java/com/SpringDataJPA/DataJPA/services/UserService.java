package com.SpringDataJPA.DataJPA.services;

import com.SpringDataJPA.DataJPA.entity.User;


public interface UserService {

    User registerUser(User user);

    User updatePassword(String username,String password);

    User updateEmail(String username,String email);

    void removeUser(String username);


}
