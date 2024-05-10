package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Department;
import com.employeemanager.employeemanager.dto.DepartmentDTO;
import com.employeemanager.employeemanager.exception.DepartmentNotFoundException;
import com.employeemanager.employeemanager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentMapper(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDTO toDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }

    public Department findEntity(DepartmentDTO departmentDTO) {
        return departmentRepository.findById(departmentDTO.getId()).orElseThrow(() ->
                new DepartmentNotFoundException(departmentDTO.getId()));
    }

    public Department toEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        return department;
    }

    public Department updateEntity(DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(departmentDTO.getId()).orElseThrow(() ->
                new DepartmentNotFoundException(departmentDTO.getId()));
        department.setName(departmentDTO.getName());
        return department;
    }
}
