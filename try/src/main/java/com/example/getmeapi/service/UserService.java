package com.example.getmeapi.service;

import com.example.getmeapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.getmeapi.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

        public User updateUser( User user) {
        return userRepository.save(user);
    }
        //@DeleteMapping
        public void deleteUser(String userId) {
             userRepository.deleteById(userId);
        }

    public List<User> getByAddress(String address) {
        return userRepository.findAllByAddress(address);
    }

    public User getById(String userId){
        return userRepository.findById(userId).get();
    }
//    @GetMapping("/user")
//    public User getUser(){
//        //User user = new User("a","b",1);
//        return userRepository.getUser();
//    }
//
//
//
//    public List<User> getAllUsers() {
//        return userRepository.getAllUsers();
//    }
//
//    public User getUserById(int userId) {
//        return userRepository.getUserById(userId);
//    }
//
//    public User updateUser(int userId, User user) {
//        return userRepository.updateUser(userId,user);
//    }
//
//    public User deleteUser(int userId) {
//        return userRepository.deleteUser(userId);
//    }
}
