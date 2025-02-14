package com.sirvic.journal.journal.service;

import com.sirvic.journal.journal.model.Notes;
import com.sirvic.journal.journal.model.Users;
import com.sirvic.journal.journal.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class NotesService {
    private final NotesRepository repository;

    @Autowired
    public NotesService(NotesRepository repository) {
        this.repository = repository;
    }

    public List<Notes> displayNotes(Long id) {

        List<Notes> notes = repository.findByUserId(id);

        if(notes.isEmpty()){
            throw new IllegalStateException("Note Not Found");
        }

        return notes;
    }

    public List<Notes> displayAllNotes() {
        return repository.findAll();
    }
}
