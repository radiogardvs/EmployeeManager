package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
