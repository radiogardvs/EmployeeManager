package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Event;
import com.employeemanager.employeemanager.dto.EventDTO;
import com.employeemanager.employeemanager.exception.EventNotFoundException;
import com.employeemanager.employeemanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    private final EventRepository eventRepository;
    @Autowired
    public EventMapper(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }
    public EventDTO toDTO(Event event){
        EventDTO eventDTO=new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setEventType(event.getEventType());
        return eventDTO;
    }
    public Event findEntity(EventDTO eventDTO){
        return eventRepository.findById(eventDTO.getId()).orElseThrow(()->
                new EventNotFoundException(eventDTO.getId()));
    }
    public Event toEntity(EventDTO eventDTO){
        Event event= new Event();
        event.setName(eventDTO.getName());
        event.setEventType(eventDTO.getEventType());
        return event;
    }
    public Event updateEntity(EventDTO eventDTO){
        Event event= eventRepository.findById(eventDTO.getId()).orElseThrow(()->
                new EventNotFoundException(eventDTO.getId()));
        event.setName(eventDTO.getName());
        event.setEventType(eventDTO.getEventType());
        return event;
    }
}
