package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.dao.TaskNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskNoteRepository extends JpaRepository<TaskNote, Long> {
}
