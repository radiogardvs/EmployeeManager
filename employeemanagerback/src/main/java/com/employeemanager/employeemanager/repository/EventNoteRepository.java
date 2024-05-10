package com.employeemanager.employeemanager.repository;

import com.employeemanager.employeemanager.dao.EventNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventNoteRepository extends JpaRepository<EventNote, Long> {
}
