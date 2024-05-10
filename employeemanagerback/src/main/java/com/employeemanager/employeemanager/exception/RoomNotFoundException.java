package com.employeemanager.employeemanager.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {
        super("Room with id " + id + " does not exist");
    }
}
