package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Room;
import com.employeemanager.employeemanager.dto.RoomDTO;
import com.employeemanager.employeemanager.exception.RoomNotFoundException;
import com.employeemanager.employeemanager.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomMapper(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        return roomDTO;
    }

    public Room findEntity(RoomDTO roomDTO) {
        return roomRepository.findById(roomDTO.getId()).orElseThrow(() ->
                new RoomNotFoundException(roomDTO.getId()));
    }

    public Room toEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setName(roomDTO.getName());
        return room;
    }

    public Room updateEntity(RoomDTO roomDTO) {
        Room room = roomRepository.findById(roomDTO.getId()).orElseThrow(() ->
                new RoomNotFoundException(roomDTO.getId()));
        room.setName(roomDTO.getName());
        return room;
    }
}
