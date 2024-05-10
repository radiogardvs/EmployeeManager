package com.employeemanager.employeemanager.exception;

import com.employeemanager.employeemanager.dao.EmployeeTaskAssignment;

public class EmployeeTaskAssignmentNotFoundException extends RuntimeException {
    public EmployeeTaskAssignmentNotFoundException(Long id, Long employeeId, Long taskId) {
        super("The assignment with id " + id + " between employee with id " + employeeId + " and task with id" + taskId + "does not exist.");
    }
}
