package com.sirvic.journal.journal.service;

import com.sirvic.journal.journal.model.Users;
import com.sirvic.journal.journal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.FEBRUARY;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
           Users firstUser = new Users(
                    "haerinposa",
                    "123",
                    "Haerin",
                    "Kang",
                    "Female",
                    LocalDate.of(2004, FEBRUARY, 14)
            );

           Users secondUser  = new Users(
                   "hanni",
                   "123",
                   "Hanni",
                   "Pham",
                   "Female",
                   LocalDate.of(2004, APRIL, 23)
           );

           repository.saveAll(
                List.of(firstUser, secondUser)
           );
        };
    }
}
