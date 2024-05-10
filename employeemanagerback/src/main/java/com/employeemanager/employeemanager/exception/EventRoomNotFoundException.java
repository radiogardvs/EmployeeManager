package com.employeemanager.employeemanager.exception;

public class EventRoomNotFoundException extends RuntimeException{
    public EventRoomNotFoundException(Long id, Long eventId, Long roomId){
        super("The event-room connection with id"+id+"between event with id "+ eventId+" and room with id "+roomId+" does not exist");
    }
}
