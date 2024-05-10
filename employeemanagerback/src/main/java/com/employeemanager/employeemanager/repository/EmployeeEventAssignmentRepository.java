package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.dao.EmployeeEventAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEventAssignmentRepository extends JpaRepository<EmployeeEventAssignment,Long> {
}
