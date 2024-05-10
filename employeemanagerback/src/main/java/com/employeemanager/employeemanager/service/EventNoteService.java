package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.EventNoteDTO;
import com.employeemanager.employeemanager.dto.TaskNoteDTO;
import com.employeemanager.employeemanager.exception.EventNoteNotFoundException;
import com.employeemanager.employeemanager.mapper.EventNoteMapper;
import com.employeemanager.employeemanager.repository.EventNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventNoteService {
    private final EventNoteRepository eventNoteRepository;
    private final EventNoteMapper eventNoteMapper;

    @Autowired
    public EventNoteService(EventNoteRepository eventNoteRepository, EventNoteMapper eventNoteMapper) {
        this.eventNoteMapper = eventNoteMapper;
        this.eventNoteRepository = eventNoteRepository;
    }

    public EventNoteDTO addEventNote(EventNoteDTO eventNoteDTO) {
        return eventNoteMapper.toDTO(eventNoteRepository.save(eventNoteMapper.toEntity(eventNoteDTO)));
    }

    public List<EventNoteDTO> findAllEventNotes() {
        return eventNoteRepository.findAll().stream().map(eventNoteMapper::toDTO).collect(Collectors.toList());
    }

    public EventNoteDTO updateEventNote(EventNoteDTO eventNoteDTO) {
        return eventNoteMapper.toDTO(eventNoteRepository.save(eventNoteMapper.updateEntity(eventNoteDTO)));
    }

    public EventNoteDTO findEventNoteById(Long id) {
        return eventNoteMapper.toDTO(eventNoteRepository.findById(id).orElseThrow(() -> new EventNoteNotFoundException(id, 0L, 0L)));
    }

    public void deleteEventNote(Long id) {
        eventNoteRepository.deleteById(id);
    }

}
