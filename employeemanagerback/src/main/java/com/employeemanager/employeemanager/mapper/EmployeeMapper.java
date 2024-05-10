package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Employee;
import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.exception.EmployeeNotFoundException;
import com.employeemanager.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmployeeCode(employee.getEmployeeCode());
        employeeDTO.setImageUrl(employee.getImageUrl());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setJobTitle(employee.getJobTitle());
        return employeeDTO;
    }

    public Employee findEntity(EmployeeDTO employeeDTO) {
        return employeeRepository.findById(employeeDTO.getId()).orElseThrow(() -> new EmployeeNotFoundException(employeeDTO.getId()));
    }

    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setPhone(employeeDTO.getPhone());
        employee.setImageUrl(employeeDTO.getImageUrl());
        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        return employee;
    }

    public Employee updateEntity(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(() ->
                new EmployeeNotFoundException(employeeDTO.getId()));
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setPhone(employeeDTO.getPhone());
        employee.setImageUrl(employeeDTO.getImageUrl());
        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        return employee;
    }
}
