package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.EventNoteDTO;
import com.employeemanager.employeemanager.dto.EventRoomDTO;
import com.employeemanager.employeemanager.exception.EventRoomNotFoundException;
import com.employeemanager.employeemanager.mapper.EventRoomMapper;
import com.employeemanager.employeemanager.repository.EventRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventRoomService {
    private final EventRoomRepository eventRoomRepository;
    private final EventRoomMapper eventRoomMapper;

    @Autowired
    public EventRoomService(EventRoomRepository eventRoomRepository, EventRoomMapper eventRoomMapper) {
        this.eventRoomMapper = eventRoomMapper;
        this.eventRoomRepository = eventRoomRepository;
    }

    public EventRoomDTO addEventRoom(EventRoomDTO eventRoomDTO) {
        return eventRoomMapper.toDTO(eventRoomRepository.save(eventRoomMapper.toEntity(eventRoomDTO)));
    }

    public List<EventRoomDTO> findAllEventRooms() {
        return eventRoomRepository.findAll().stream().map(eventRoomMapper::toDTO).collect(Collectors.toList());
    }

    public EventRoomDTO updateEventRoom(EventRoomDTO eventRoomDTO) {
        return eventRoomMapper.toDTO(eventRoomRepository.save(eventRoomMapper.updateEntity(eventRoomDTO)));
    }

    public EventRoomDTO findEventRoomById(Long id) {
        return eventRoomMapper.toDTO(eventRoomRepository.findById(id).orElseThrow(() -> new EventRoomNotFoundException(id, 0L, 0L)));
    }

    public void deleteEventRoom(Long id) {
        eventRoomRepository.deleteById(id);
    }

}
