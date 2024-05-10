package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.DepartmentEmployee;
import com.employeemanager.employeemanager.dto.DepartmentEmployeeDTO;
import com.employeemanager.employeemanager.exception.*;
import com.employeemanager.employeemanager.repository.DepartmentEmployeeRepository;
import com.employeemanager.employeemanager.repository.DepartmentRepository;
import com.employeemanager.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentEmployeeMapper {
    private final DepartmentEmployeeRepository departmentEmployeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentEmployeeMapper(DepartmentEmployeeRepository departmentEmployeeRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentEmployeeRepository = departmentEmployeeRepository;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEmployeeDTO toDTO(DepartmentEmployee departmentEmployee) {
        DepartmentEmployeeDTO departmentEmployeeDTO = new DepartmentEmployeeDTO();
        departmentEmployeeDTO.setId((departmentEmployee.getId()));
        departmentEmployeeDTO.setEmployeeId(departmentEmployee.getEmployee().getId());
        departmentEmployeeDTO.setDepartmentId(departmentEmployee.getDepartment().getId());
        return departmentEmployeeDTO;
    }

    public DepartmentEmployee findEntity(DepartmentEmployeeDTO departmentEmployeeDTO) {
        return departmentEmployeeRepository.findById(departmentEmployeeDTO.getId()).orElseThrow(() ->
                new DepartmentEmployeeNotFoundException(departmentEmployeeDTO.getId(), departmentEmployeeDTO.getDepartmentId(), departmentEmployeeDTO.getEmployeeId()));
    }

    public DepartmentEmployee toEntity(DepartmentEmployeeDTO departmentEmployeeDTO) {
        DepartmentEmployee departmentEmployee = new DepartmentEmployee();
        departmentEmployee.setEmployee(employeeRepository.findById(departmentEmployeeDTO.getEmployeeId()).orElseThrow(() ->
                new EmployeeNotFoundException(departmentEmployeeDTO.getId())));
        departmentEmployee.setDepartment(departmentRepository.findById(departmentEmployeeDTO.getDepartmentId()).orElseThrow(() ->
                new DepartmentNotFoundException(departmentEmployeeDTO.getId())));
        return departmentEmployee;
    }

    public DepartmentEmployee updateEntity(DepartmentEmployeeDTO departmentEmployeeDTO) {
        DepartmentEmployee departmentEmployee = departmentEmployeeRepository.findById(departmentEmployeeDTO.getId()).orElseThrow(() ->
                new DepartmentEmployeeNotFoundException(departmentEmployeeDTO.getId(), departmentEmployeeDTO.getDepartmentId(), departmentEmployeeDTO.getEmployeeId()));
        departmentEmployee.setEmployee(employeeRepository.findById(departmentEmployeeDTO.getEmployeeId()).orElseThrow(() ->
                new EmployeeNotFoundException(departmentEmployeeDTO.getEmployeeId())));
        departmentEmployee.setDepartment(departmentRepository.findById(departmentEmployeeDTO.getDepartmentId()).orElseThrow(() ->
                new DepartmentNotFoundException(departmentEmployeeDTO.getDepartmentId())));
        return departmentEmployee;
    }
}
