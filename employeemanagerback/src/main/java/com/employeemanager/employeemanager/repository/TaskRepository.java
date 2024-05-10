package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
