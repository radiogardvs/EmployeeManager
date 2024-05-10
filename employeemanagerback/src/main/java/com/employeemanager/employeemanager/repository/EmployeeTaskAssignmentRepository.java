package com.employeemanager.employeemanager.repository;
import com.employeemanager.employeemanager.dao.EmployeeTaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeTaskAssignmentRepository extends JpaRepository<EmployeeTaskAssignment,Long> {
}
