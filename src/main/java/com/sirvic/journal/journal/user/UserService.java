package com.sirvic.journal.journal.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Service Layer giving back data to the api layer
@Service // To tell spring this is a bean for the user to use
public class UserService {
    @GetMapping
    public List<User> displayUser(){
        return List.of(new User(
                1L,
                "njposa",
                "123",
                "Kang Haerin",
                "Female",
                18,
                LocalDate.of(2004, Month.FEBRUARY, 14)
        ));
    }
}
