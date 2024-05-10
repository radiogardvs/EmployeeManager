package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.NoteDTO;
import com.employeemanager.employeemanager.dto.RoomDTO;
import com.employeemanager.employeemanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        return new ResponseEntity<>(roomService.findAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roomService.findRoomById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RoomDTO> addRoom(@RequestBody RoomDTO roomDTO) {
        return new ResponseEntity<>(roomService.addRoom(roomDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO) {
        return new ResponseEntity<>(roomService.updateRoom(roomDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
