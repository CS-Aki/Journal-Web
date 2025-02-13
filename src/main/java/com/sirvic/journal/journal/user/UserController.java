package com.sirvic.journal.journal.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API Layer
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired // optional if only one constructor, otherwise must specify which constructor to use by using autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> displayUser(){
        return userService.displayUser();
    }

    @PostMapping
    public void registerUser(@RequestBody Users user){
        userService.addNewUser(user);
    }
}
