package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.EventNoteDTO;
import com.employeemanager.employeemanager.dto.EventRoomDTO;
import com.employeemanager.employeemanager.service.EventNoteService;
import com.employeemanager.employeemanager.service.EventRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventroom")
public class EventRoomController {
    private final EventRoomService eventRoomService;

    @Autowired
    public EventRoomController(EventRoomService eventRoomService) {
        this.eventRoomService = eventRoomService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventRoomDTO>> getAllEventRooms() {
        return new ResponseEntity<>(eventRoomService.findAllEventRooms(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EventRoomDTO> getEventRoomById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventRoomService.findEventRoomById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EventRoomDTO> addEventRoom(@RequestBody EventRoomDTO eventRoomDTO) {
        return new ResponseEntity<>(eventRoomService.addEventRoom(eventRoomDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EventRoomDTO> updateEventRoom(@RequestBody EventRoomDTO eventRoomDTO) {
        return new ResponseEntity<>(eventRoomService.updateEventRoom(eventRoomDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEventRoom(@PathVariable("id") Long id) {
        eventRoomService.deleteEventRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
