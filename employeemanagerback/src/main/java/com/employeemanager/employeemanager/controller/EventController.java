package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.dto.EventDTO;
import com.employeemanager.employeemanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService){
        this.eventService=eventService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventService.findEventById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EventDTO> addEvent(@RequestBody EventDTO eventDTO) {
        return new ResponseEntity<>(eventService.addEvent(eventDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO eventDTO) {
        return new ResponseEntity<>(eventService.updateEvent(eventDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
