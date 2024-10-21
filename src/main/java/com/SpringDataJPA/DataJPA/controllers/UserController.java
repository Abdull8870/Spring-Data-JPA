package com.SpringDataJPA.DataJPA.controllers;

import com.SpringDataJPA.DataJPA.dto.UserDto;
import com.SpringDataJPA.DataJPA.entity.User;
import com.SpringDataJPA.DataJPA.messaging.JmsProducer;
import com.SpringDataJPA.DataJPA.services.serviceImplementation.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;
    private JmsProducer jmsProducer;

    @PostMapping("register")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid User user){
        UserDto saveUser =this.userService.registerUser(user);
        jmsProducer.sendMessage("my-queue", "ActiveMq is working");
        jmsProducer.sendMessage("user_log", user.getUsername()+" Has been registered");
        return new ResponseEntity<>(saveUser,HttpStatus.OK);
    }

    @GetMapping("users/all-users")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable @Valid Long id){
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }

    @GetMapping("authenticate/check")
    public ResponseEntity<String> authenticate(){
        return new ResponseEntity<>("You have been authenticated",HttpStatus.OK);
    }



}
