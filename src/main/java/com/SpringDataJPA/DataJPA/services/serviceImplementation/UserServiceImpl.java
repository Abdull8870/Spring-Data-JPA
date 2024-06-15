package com.SpringDataJPA.DataJPA.services.serviceImplementation;

import com.SpringDataJPA.DataJPA.entity.User;
import com.SpringDataJPA.DataJPA.repositories.UserRepository;
import com.SpringDataJPA.DataJPA.services.UserService;
import jakarta.persistence.EntityNotFoundException;
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
    public User registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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

    public User findUserByUsername(String username){
        Optional<User> user=this.userRepository.findByUserName(username);
        return unWrapUser(user);
    }

    static User unWrapUser(Optional<User> user){
        if(user.isPresent()) return user.get();
        else throw new EntityNotFoundException("User Not Found");
    }
}
