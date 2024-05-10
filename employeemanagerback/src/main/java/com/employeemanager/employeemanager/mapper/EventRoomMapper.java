package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.EventRoom;
import com.employeemanager.employeemanager.dto.EventRoomDTO;
import com.employeemanager.employeemanager.exception.EventNotFoundException;
import com.employeemanager.employeemanager.exception.EventRoomNotFoundException;
import com.employeemanager.employeemanager.exception.RoomNotFoundException;
import com.employeemanager.employeemanager.repository.EventRepository;
import com.employeemanager.employeemanager.repository.EventRoomRepository;
import com.employeemanager.employeemanager.repository.RoomRepository;
import org.springframework.stereotype.Component;

@Component
public class EventRoomMapper {
    private final EventRoomRepository eventRoomRepository;
    private final EventRepository eventRepository;
    private final RoomRepository roomRepository;

    public EventRoomMapper(EventRoomRepository eventRoomRepository, EventRepository eventRepository, RoomRepository roomRepository) {
        this.eventRepository = eventRepository;
        this.roomRepository = roomRepository;
        this.eventRoomRepository = eventRoomRepository;
    }

    public EventRoomDTO toDTO(EventRoom eventRoom) {
        EventRoomDTO eventRoomDTO = new EventRoomDTO();
        eventRoomDTO.setId(eventRoom.getId());
        eventRoomDTO.setEventId(eventRoom.getEvent().getId());
        eventRoomDTO.setRoomId(eventRoom.getRoom().getId());
        return eventRoomDTO;
    }

    public EventRoom findEntity(EventRoomDTO eventRoomDTO) {
        return eventRoomRepository.findById(eventRoomDTO.getId()).orElseThrow(() ->
                new EventRoomNotFoundException(eventRoomDTO.getId(), eventRoomDTO.getEventId(), eventRoomDTO.getRoomId()));
    }

    public EventRoom toEntity(EventRoomDTO eventRoomDTO) {
        EventRoom eventRoom = new EventRoom();
        eventRoom.setEvent(eventRepository.findById(eventRoomDTO.getEventId()).orElseThrow(() ->
                new EventNotFoundException(eventRoomDTO.getEventId())));
        eventRoom.setRoom(roomRepository.findById(eventRoomDTO.getRoomId()).orElseThrow(() ->
                new RoomNotFoundException(eventRoom.getId())));
        return eventRoom;
    }

    public EventRoom updateEntity(EventRoomDTO eventRoomDTO) {
        EventRoom eventRoom = eventRoomRepository.findById(eventRoomDTO.getId()).orElseThrow(() ->
                new EventRoomNotFoundException(eventRoomDTO.getId(), eventRoomDTO.getEventId(), eventRoomDTO.getRoomId()));
        eventRoom.setEvent(eventRepository.findById(eventRoomDTO.getEventId()).orElseThrow(() ->
                new EventNotFoundException(eventRoomDTO.getEventId())));
        eventRoom.setRoom(roomRepository.findById(eventRoomDTO.getRoomId()).orElseThrow(() ->
                new RoomNotFoundException(eventRoomDTO.getRoomId())));
        return eventRoom;
    }
}
