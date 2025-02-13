package com.sirvic.journal.journal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

// Service Layer giving back data to the api layer
@Service // To tell spring this is a bean for the user to use
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @GetMapping
    public List<Users> displayUser(){
        return repository.findAll();
    }
    
    public void addNewUser(Users user) {
        Optional<Users> usersOptional = repository.findByUsername(user.getUsername());
//      Can change to much more complex error handler
        if(usersOptional.isPresent()){
            throw new IllegalStateException("Username is taken");
        }

        repository.save(user);
        System.out.println(user);
    }
}
