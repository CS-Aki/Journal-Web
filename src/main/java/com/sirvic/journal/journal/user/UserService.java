package com.sirvic.journal.journal.user;

import jakarta.transaction.Transactional;
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

    public void deleteUser(Long id) {
        boolean isIdExist = repository.existsById(id);

        if(!isIdExist){
            throw new IllegalStateException("User not found!");
        }

        repository.deleteById(id);
        System.out.println("Delete Success!");
    }

    @Transactional
    public void updateUsername(Long id, String username, String firstName, String lastName) {
        Users user = repository.findById(id).orElseThrow(() -> new IllegalStateException("User ID does not exist"));

        Optional<Users> usersOptional = repository.findByUsername(username);

        if(user.getUsername().equals(username)){
            throw new IllegalStateException("Username not changed!");
        }

        if(usersOptional.isPresent()){
            throw new IllegalStateException("Username already taken");
        }

        user.setUsername(username.equals("") ? user.getUsername() : username);
        user.setFirstName(firstName.equals("") ? user.getFirstName() : firstName);
        user.setLastName(lastName.equals("") ? user.getLastName() : lastName);
    }
}
