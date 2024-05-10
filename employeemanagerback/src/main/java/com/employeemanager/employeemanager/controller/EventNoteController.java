package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.EmployeeEventAssignmentDTO;
import com.employeemanager.employeemanager.dto.EventNoteDTO;
import com.employeemanager.employeemanager.service.EventNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventnote")
public class EventNoteController {
    private final EventNoteService eventNoteService;

    @Autowired
    public EventNoteController(EventNoteService eventNoteService) {
        this.eventNoteService = eventNoteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventNoteDTO>> getAllEventNotes() {
        return new ResponseEntity<>(eventNoteService.findAllEventNotes(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EventNoteDTO> getEventNoteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventNoteService.findEventNoteById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EventNoteDTO> addEventNote(@RequestBody EventNoteDTO eventNoteDTO) {
        return new ResponseEntity<>(eventNoteService.addEventNote(eventNoteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EventNoteDTO> updateEventNote(@RequestBody EventNoteDTO eventNoteDTO) {
        return new ResponseEntity<>(eventNoteService.updateEventNote(eventNoteDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEventNote(@PathVariable("id") Long id) {
        eventNoteService.deleteEventNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
