package com.employeemanager.employeemanager.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task with id "+id+" does not exist.");
    }
}
