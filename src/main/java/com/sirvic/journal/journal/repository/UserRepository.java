package com.sirvic.journal.journal.repository;

import com.sirvic.journal.journal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

//    @Query("SELECT u FROM users u WHERE u.username = ?")
    Optional<Users> findByUsername(String username);
}
