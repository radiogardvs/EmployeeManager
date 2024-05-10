package com.employeemanager.employeemanager.exception;

public class EventNoteNotFoundException extends RuntimeException {
    public EventNoteNotFoundException(Long id, Long eventId, Long noteId) {
        super("The event-note connection with id " + id + " between event with id " + eventId + "and note with id " + noteId + "does not exist.");
    }
}
