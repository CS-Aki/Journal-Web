package com.sirvic.journal.journal.controller;

import com.sirvic.journal.journal.model.Notes;
import com.sirvic.journal.journal.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/notes")

public class NotesController {
    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

//    @GetMapping
//    public List<Notes> displayAllNotes(){
//        return notesService.displayAllNotes();
//    }

    @PostMapping(path = "{userId}")
    public void createNote(@PathVariable("userId") Long userId,
                           @RequestBody Notes note){
         notesService.createNote(userId, note);
    }

    @GetMapping(path = "user/{userId}")
    public List<Notes> displayAllNotes(@PathVariable("userId") Long userId){
        return notesService.displayAllNotes(userId);
    }

    @GetMapping(path = "{id}")
    public Notes displayNote(@PathVariable("id") Long noteId){
        return notesService.displayNote(noteId);
    }

    @DeleteMapping(path = "{id}")
    public void deleteNote(@PathVariable("id") Long noteId){
        notesService.deleteNote(noteId);
    }

    @PatchMapping(path = "{id}")
    public void editNote(@PathVariable("id") Long noteId,
                         @RequestParam(required = false, defaultValue = "") String title,
                         @RequestParam(required = false, defaultValue = "") String textBody){
        notesService.editNote(noteId, title, textBody);
    }
}
