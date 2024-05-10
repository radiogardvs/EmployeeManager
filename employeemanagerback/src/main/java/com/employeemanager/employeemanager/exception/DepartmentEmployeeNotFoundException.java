package com.employeemanager.employeemanager.exception;

public class DepartmentEmployeeNotFoundException extends RuntimeException {
    public DepartmentEmployeeNotFoundException(Long id, Long departmentId, Long employeeId) {
        super("The department-employee connection with id " + id + " between department with id " + departmentId + " and employee with id " + id + " was not found");
    }
}
