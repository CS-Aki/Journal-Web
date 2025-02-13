package com.sirvic.journal.journal.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

//    @Query("SELECT u FROM users u WHERE u.username = ?")
    Optional<Users> findByUsername(String username);
}
