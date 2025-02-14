package com.sirvic.journal.journal.controller;

import com.sirvic.journal.journal.model.Notes;
import com.sirvic.journal.journal.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/notes")

public class NotesController {
    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public List<Notes> displayAllNotes(){
        return notesService.displayAllNotes();
    }

    @GetMapping(path = "{userId}")
    public List<Notes> displayNotes(@PathVariable("userId") Long id){
        return notesService.displayNotes(id);
    }


}
