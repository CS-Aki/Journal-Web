package com.sirvic.journal.journal.repository;

import com.sirvic.journal.journal.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

    Optional<Notes> findByUserId(Long id);
}
