package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.EmployeeTaskAssignmentDTO;
import com.employeemanager.employeemanager.exception.EmployeeTaskAssignmentNotFoundException;
import com.employeemanager.employeemanager.mapper.EmployeeTaskAssignmentMapper;
import com.employeemanager.employeemanager.repository.EmployeeTaskAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeTaskAssignmentService {
    private final EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository;
    private final EmployeeTaskAssignmentMapper employeeTaskAssignmentMapper;

    @Autowired
    public EmployeeTaskAssignmentService(EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository, EmployeeTaskAssignmentMapper employeeTaskAssignmentMapper) {
        this.employeeTaskAssignmentMapper = employeeTaskAssignmentMapper;
        this.employeeTaskAssignmentRepository = employeeTaskAssignmentRepository;
    }

    public EmployeeTaskAssignmentDTO addEmployeeTaskAssignment(EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO) {
        return employeeTaskAssignmentMapper.toDTO(employeeTaskAssignmentRepository.save(employeeTaskAssignmentMapper.toEntity(employeeTaskAssignmentDTO)));
    }

    public List<EmployeeTaskAssignmentDTO> findAllEmployeeTaskAssignments() {
        return employeeTaskAssignmentRepository.findAll().stream().map(employeeTaskAssignmentMapper::toDTO).collect(Collectors.toList());
    }

    public EmployeeTaskAssignmentDTO updateEmployeeTaskAssignment(EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO) {
        return employeeTaskAssignmentMapper.toDTO(employeeTaskAssignmentRepository.save(employeeTaskAssignmentMapper.updateEntity(employeeTaskAssignmentDTO)));
    }

    public EmployeeTaskAssignmentDTO findEmployeeTaskAssignmentById(Long id) {
        return employeeTaskAssignmentMapper.toDTO(employeeTaskAssignmentRepository.findById(id).orElseThrow(()-> new EmployeeTaskAssignmentNotFoundException(id, 0L, 0L)));
    }

    public void deleteEmployeeTaskAssignment(Long id) {
        employeeTaskAssignmentRepository.deleteById(id);
    }
}
