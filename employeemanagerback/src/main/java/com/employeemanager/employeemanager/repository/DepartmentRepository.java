package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.dao.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
