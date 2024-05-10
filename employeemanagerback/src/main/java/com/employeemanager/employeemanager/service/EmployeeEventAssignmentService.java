package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.EmployeeEventAssignmentDTO;
import com.employeemanager.employeemanager.dto.EmployeeTaskAssignmentDTO;
import com.employeemanager.employeemanager.exception.EmployeeEventAssignmentNotFoundException;
import com.employeemanager.employeemanager.mapper.EmployeeEventAssignmentMapper;
import com.employeemanager.employeemanager.repository.EmployeeEventAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeEventAssignmentService {
    private final EmployeeEventAssignmentRepository employeeEventAssignmentRepository;
    private final EmployeeEventAssignmentMapper employeeEventAssignmentMapper;

    @Autowired
    public EmployeeEventAssignmentService(EmployeeEventAssignmentRepository employeeEventAssignmentRepository, EmployeeEventAssignmentMapper employeeEventAssignmentMapper) {
        this.employeeEventAssignmentMapper = employeeEventAssignmentMapper;
        this.employeeEventAssignmentRepository = employeeEventAssignmentRepository;
    }

    public EmployeeEventAssignmentDTO addEmployeeEventAssignment(EmployeeEventAssignmentDTO employeeEventAssignmentDTO) {
        return employeeEventAssignmentMapper.toDTO(employeeEventAssignmentRepository.save(employeeEventAssignmentMapper.toEntity(employeeEventAssignmentDTO)));
    }

    public List<EmployeeEventAssignmentDTO> findAllEmployeeEventAssignments() {
        return employeeEventAssignmentRepository.findAll().stream().map(employeeEventAssignmentMapper::toDTO).collect(Collectors.toList());
    }

    public EmployeeEventAssignmentDTO updateEmployeeEventAssignment(EmployeeEventAssignmentDTO employeeEventAssignmentDTO) {
        return employeeEventAssignmentMapper.toDTO(employeeEventAssignmentRepository.save(employeeEventAssignmentMapper.updateEntity(employeeEventAssignmentDTO)));
    }

    public EmployeeEventAssignmentDTO findEmployeeEventAssignmentById(Long id) {
        return employeeEventAssignmentMapper.toDTO(employeeEventAssignmentRepository.findById(id).orElseThrow(
                ()->new EmployeeEventAssignmentNotFoundException(id, 0L, 0L)));
    }

    public void deleteEmployeeEventAssignment(Long id) {
        employeeEventAssignmentRepository.deleteById(id);
    }

}
