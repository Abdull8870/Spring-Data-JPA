package com.SpringDataJPA.DataJPA.services.serviceImplementation;

import com.SpringDataJPA.DataJPA.dto.UserDto;
import com.SpringDataJPA.DataJPA.entity.User;
import com.SpringDataJPA.DataJPA.exception.EntityNotFoundException;
import com.SpringDataJPA.DataJPA.repositories.UserRepository;
import com.SpringDataJPA.DataJPA.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser= userRepository.save(user);
        UserDto userDto=UserDto.builder().
                firstName(savedUser.getFirstName()).
                lastName(savedUser.getLastName()).
                username(savedUser.getUsername()).
                id(savedUser.getId()).build();
        return userDto;

    }

    @Override
    public User updatePassword(String username, String password) {
        return null;
    }

    @Override
    public User updateEmail(String username, String email) {
        return null;
    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> userById = userRepository.findById(id);
        User user= unWrapUser(userById,String.valueOf(id));
        UserDto userDto=UserDto.builder().
                username(user.getUsername()).
                firstName(user.getFirstName()).
                lastName(user.getLastName()).
                id(user.getId()).build();

        return userDto;
    }

    public User findUserByUsername(String username){
        Optional<User> user=this.userRepository.findByUsername(username);
        return unWrapUser(user,username);
    }

    static User unWrapUser(Optional<User> user,String res){
        if(user.isPresent()) return user.get();
        else throw new EntityNotFoundException(res,User.class);
    }
}
