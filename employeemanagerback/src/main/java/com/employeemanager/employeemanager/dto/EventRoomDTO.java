package com.employeemanager.employeemanager.dto;

public class EventRoomDTO {
    private Long id;
    private Long eventId;
    private long roomId;

    public EventRoomDTO() {
    }

    public EventRoomDTO(Long id, Long eventId, Long roomId) {
        this.id = id;
        this.eventId = eventId;
        this.roomId = roomId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
