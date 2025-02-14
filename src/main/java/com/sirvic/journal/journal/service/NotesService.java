package com.sirvic.journal.journal.service;

import com.sirvic.journal.journal.model.Notes;
import com.sirvic.journal.journal.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NotesService {
    private final NotesRepository repository;

    @Autowired
    public NotesService(NotesRepository repository) {
        this.repository = repository;
    }

    public List<Notes> displayNotes(Long id) {
        repository.findByUserId(id);

        return null;
    }
}
