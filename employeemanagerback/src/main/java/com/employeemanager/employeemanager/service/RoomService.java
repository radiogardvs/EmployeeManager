package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.NoteDTO;
import com.employeemanager.employeemanager.dto.RoomDTO;
import com.employeemanager.employeemanager.exception.RoomNotFoundException;
import com.employeemanager.employeemanager.mapper.RoomMapper;
import com.employeemanager.employeemanager.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomDTO addRoom(RoomDTO roomDTO) {
        return roomMapper.toDTO(roomRepository.save(roomMapper.toEntity(roomDTO)));
    }

    public List<RoomDTO> findAllRooms() {
        return roomRepository.findAll().stream().map(roomMapper::toDTO).collect(Collectors.toList());
    }

    public RoomDTO updateRoom(RoomDTO roomDTO) {
        return roomMapper.toDTO(roomRepository.save(roomMapper.updateEntity(roomDTO)));
    }

    public RoomDTO findRoomById(Long id) {
        return roomMapper.toDTO(roomRepository.findById(id).orElseThrow(()-> new RoomNotFoundException(id)));
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
