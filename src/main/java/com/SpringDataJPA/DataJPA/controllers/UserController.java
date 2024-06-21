package com.SpringDataJPA.DataJPA.controllers;

import com.SpringDataJPA.DataJPA.dto.UserDto;
import com.SpringDataJPA.DataJPA.entity.User;
import com.SpringDataJPA.DataJPA.services.serviceImplementation.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    @PostMapping("register")
    public ResponseEntity<UserDto> registerUser(@RequestBody User user){
        UserDto saveUser =this.userService.registerUser(user);
        return new ResponseEntity<>(saveUser,HttpStatus.OK);
    }

    @GetMapping("all-users")
    public ResponseEntity<String> getAllUser(){
        return new ResponseEntity<>("Abdul Rahuman",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }

    @GetMapping("authenticate/check")
    public ResponseEntity<String> authenticate(){
        return new ResponseEntity<>("You have been authenticated",HttpStatus.OK);
    }

}
