package com.employeemanager.employeemanager.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id){
        super("Employee with id " + id + "does not exist.");
    }
}
