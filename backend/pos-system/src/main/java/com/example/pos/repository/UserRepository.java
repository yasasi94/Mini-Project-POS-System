package com.example.pos.repository;

import java.util.List;

import com.example.pos.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public User findByUsername(String username);

}
