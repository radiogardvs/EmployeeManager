package com.employeemanager.employeemanager.dto;

public class EventNoteDTO {
    private Long id;
    private Long eventId;
    private Long noteId;

    public EventNoteDTO() {
    }

    public EventNoteDTO(Long id, Long eventId, Long noteId) {
        this.id = id;
        this.eventId = eventId;
        this.noteId = noteId;
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

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    @Override
    public String toString() {
        return "EventNoteDTO{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", noteId=" + noteId +
                '}';
    }
}
