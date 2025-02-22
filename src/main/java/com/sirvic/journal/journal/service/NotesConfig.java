// package com.sirvic.journal.journal.service;

// import com.sirvic.journal.journal.model.Notes;
// import com.sirvic.journal.journal.repository.NotesRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.time.LocalDate;
// import java.util.List;

// import static java.time.Month.FEBRUARY;

// @Configuration
// public class NotesConfig {

//     @Bean
//     CommandLineRunner clr(NotesRepository repository){
//         return args -> {
//             Notes firstEntry = new Notes(2L,
//                     "First Entry Title",
//                     "This is the text body of First entry",
//                     LocalDate.of(2025, FEBRUARY, 14)
//             );

//             Notes secondEntry = new Notes(2L,
//                     "Second Entry Title",
//                     "This is the text body of Second entry",
//                     LocalDate.of(2025, FEBRUARY, 14)
//             );

//             Notes thirdEntry = new Notes(1L,
//                     "Third Entry Title",
//                     "This is the text body of thirdEntry entry",
//                     LocalDate.of(2025, FEBRUARY, 14)
//             );

//             repository.saveAll(List.of(firstEntry, secondEntry, thirdEntry));
//         };
//     }
// }
