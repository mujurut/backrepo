package com.example.getmeapi.repository;

import com.example.getmeapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByAddress( String address);
}

