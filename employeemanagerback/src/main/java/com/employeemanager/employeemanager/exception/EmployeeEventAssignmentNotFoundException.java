package com.employeemanager.employeemanager.exception;

public class EmployeeEventAssignmentNotFoundException extends RuntimeException{
    public EmployeeEventAssignmentNotFoundException(Long id, Long employeeId, Long eventId){
        super("The assignment with id " + id + "between employee with id " + employeeId + "and event with id " + eventId +"does not exist.");
    }
}
