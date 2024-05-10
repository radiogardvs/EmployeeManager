package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.dto.EventDTO;
import com.employeemanager.employeemanager.exception.EventNotFoundException;
import com.employeemanager.employeemanager.mapper.EventMapper;
import com.employeemanager.employeemanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @Autowired
    public EventService(EventRepository eventRepository, EventMapper eventMapper){
        this.eventRepository=eventRepository;
        this.eventMapper=eventMapper;
    }
    public EventDTO addEvent(EventDTO eventDTO) {
        return eventMapper.toDTO(eventRepository.save(eventMapper.toEntity(eventDTO)));
    }

    public List<EventDTO> findAllEvents() {
        return eventRepository.findAll().stream().map(eventMapper::toDTO).collect(Collectors.toList());
    }

    public EventDTO updateEvent(EventDTO eventDTO) {
        return eventMapper.toDTO(eventRepository.save(eventMapper.updateEntity(eventDTO)));
    }

    public EventDTO findEventById(Long id) {
        return eventMapper.toDTO(eventRepository.findById(id).orElseThrow(()-> new EventNotFoundException(id)));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }


}
