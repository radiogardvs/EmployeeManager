package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.EmployeeEventAssignment;
import com.employeemanager.employeemanager.dto.EmployeeEventAssignmentDTO;
import com.employeemanager.employeemanager.exception.EmployeeEventAssignmentNotFoundException;
import com.employeemanager.employeemanager.exception.EmployeeNotFoundException;
import com.employeemanager.employeemanager.exception.EventNotFoundException;
import com.employeemanager.employeemanager.repository.EmployeeEventAssignmentRepository;
import com.employeemanager.employeemanager.repository.EmployeeRepository;
import com.employeemanager.employeemanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventAssignmentMapper {
    private final EmployeeRepository employeeRepository;
    private final EventRepository eventRepository;
    private final EmployeeEventAssignmentRepository employeeEventAssignmentRepository;

    @Autowired
    public EmployeeEventAssignmentMapper(EmployeeRepository employeeRepository, EventRepository eventRepository, EmployeeEventAssignmentRepository employeeEventAssignmentRepository) {
        this.employeeRepository = employeeRepository;
        this.eventRepository = eventRepository;
        this.employeeEventAssignmentRepository = employeeEventAssignmentRepository;
    }

    public EmployeeEventAssignmentDTO toDTO(EmployeeEventAssignment employeeEventAssignment) {
        EmployeeEventAssignmentDTO employeeEventAssignmentDTO = new EmployeeEventAssignmentDTO();
        employeeEventAssignmentDTO.setId((employeeEventAssignment.getId()));
        employeeEventAssignmentDTO.setEmployeeId(employeeEventAssignment.getEmployee().getId());
        employeeEventAssignmentDTO.setEventId((employeeEventAssignment.getEvent().getId()));
        return employeeEventAssignmentDTO;
    }

    public EmployeeEventAssignment findEntity(EmployeeEventAssignmentDTO employeeEventAssignmentDTO) {
        return employeeEventAssignmentRepository.findById(employeeEventAssignmentDTO.getId()).orElseThrow(() ->
                new EmployeeEventAssignmentNotFoundException(employeeEventAssignmentDTO.getId(), employeeEventAssignmentDTO.getEmployeeId(), employeeEventAssignmentDTO.getEventId()));
    }

    public EmployeeEventAssignment toEntity(EmployeeEventAssignmentDTO employeeEventAssignmentDTO) {
        EmployeeEventAssignment employeeEventAssignment = new EmployeeEventAssignment();
        employeeEventAssignment.setEmployee(employeeRepository.findById(employeeEventAssignmentDTO.getEmployeeId()).orElseThrow(() ->
                new EmployeeNotFoundException(employeeEventAssignmentDTO.getId())));
        employeeEventAssignment.setEvent(eventRepository.findById(employeeEventAssignmentDTO.getEventId()).orElseThrow(() ->
                new EventNotFoundException(employeeEventAssignmentDTO.getId())));
        return employeeEventAssignment;
    }

    public EmployeeEventAssignment updateEntity(EmployeeEventAssignmentDTO employeeEventAssignmentDTO) {
        EmployeeEventAssignment employeeEventAssignment = employeeEventAssignmentRepository.findById(employeeEventAssignmentDTO.getId()).orElseThrow(() ->
                new EmployeeEventAssignmentNotFoundException(employeeEventAssignmentDTO.getId(), employeeEventAssignmentDTO.getEmployeeId(), employeeEventAssignmentDTO.getEventId()));
        employeeEventAssignment.setEmployee(employeeRepository.findById(employeeEventAssignmentDTO.getEmployeeId()).orElseThrow(() ->
                new EmployeeNotFoundException(employeeEventAssignmentDTO.getEmployeeId())));
        employeeEventAssignment.setEvent(eventRepository.findById(employeeEventAssignmentDTO.getEventId()).orElseThrow(() ->
                new EventNotFoundException(employeeEventAssignmentDTO.getEventId())));
        return employeeEventAssignment;
    }
}
