package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.dto.NoteDTO;
import com.employeemanager.employeemanager.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
    @Autowired
    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(noteService.findNoteById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<NoteDTO> addNote(@RequestBody NoteDTO noteDTO) {
        return new ResponseEntity<>(noteService.addNote(noteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<NoteDTO> updateNote(@RequestBody NoteDTO noteDTO) {
        return new ResponseEntity<>(noteService.updateNote(noteDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
