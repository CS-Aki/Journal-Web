package com.sirvic.journal.journal.service;

import com.sirvic.journal.journal.model.Notes;
import com.sirvic.journal.journal.repository.NotesRepository;
import jakarta.transaction.Transactional;
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


    public List<Notes> displayAllNotes(Long userId) {

        List<Notes> notes = repository.findByUserId(userId);

        if(notes.isEmpty()){
            throw new IllegalStateException("Note Not Found");
        }

        return notes;
    }

//    public List<Notes> displayAllNotes() {
//        return repository.findAll();
//    }

    public void deleteNote(Long noteId) {
        Optional<Notes> note = repository.findById(noteId);

        if(note.isEmpty()){
            throw new IllegalStateException("Note ID not found");
        }

        repository.delete(note.get());
    }

    @Transactional
    public void editNote(Long noteId, String title, String textBody) {
//        Optional<Notes> noteOpt = repository.findById(id);
        Notes note = repository.findById(noteId).orElseThrow(() -> new IllegalStateException("Note ID not Found"));
        String origTitle = note.getTitle();
        String origBody = note.getTextBody();

        if(title == "" || title.equals(origTitle)){
            throw new IllegalStateException("No Changes Made");
        }

        if(textBody == null || textBody.equals(origBody)){
            throw new IllegalStateException("No Changes Made");
        }

        note.setTitle(origTitle.equals(title) ? origTitle : title);
        note.setTextBody(origBody.equals(textBody) ? origBody : textBody);
    }

    @Transactional
    public void createNote(Long userId, Notes note) {
        note.setUserId(userId);
        repository.save(note);
    }

    public Notes displayNote(Long noteId) {
        Notes note = repository.findById(noteId).orElseThrow(() -> new IllegalStateException("Note ID not found"));
        return note;
    }
}
