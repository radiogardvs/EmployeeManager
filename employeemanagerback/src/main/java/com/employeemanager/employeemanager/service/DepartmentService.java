package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.DepartmentDTO;
import com.employeemanager.employeemanager.exception.DepartmentNotFoundException;
import com.employeemanager.employeemanager.mapper.DepartmentMapper;
import com.employeemanager.employeemanager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        return departmentMapper.toDTO(departmentRepository.save(departmentMapper.toEntity(departmentDTO)));
    }

    public List<DepartmentDTO> findAllDepartments() {
        return departmentRepository.findAll().stream().map(departmentMapper::toDTO).collect(Collectors.toList());
    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        return departmentMapper.toDTO(departmentRepository.save(departmentMapper.updateEntity(departmentDTO)));
    }

    public DepartmentDTO findDepartmentById(Long id) {
        return departmentMapper.toDTO(departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id)));
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }


}
