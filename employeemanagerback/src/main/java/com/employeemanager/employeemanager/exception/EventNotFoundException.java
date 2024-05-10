package com.employeemanager.employeemanager.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("The event with id" + id + "does not exist.");
    }
}
