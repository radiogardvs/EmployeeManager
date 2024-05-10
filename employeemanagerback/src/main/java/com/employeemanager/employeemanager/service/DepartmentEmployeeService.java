package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.DepartmentEmployeeDTO;
import com.employeemanager.employeemanager.exception.DepartmentEmployeeNotFoundException;
import com.employeemanager.employeemanager.mapper.DepartmentEmployeeMapper;
import com.employeemanager.employeemanager.repository.DepartmentEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentEmployeeService {
    private final DepartmentEmployeeRepository departmentEmployeeRepository;
    private final DepartmentEmployeeMapper departmentEmployeeMapper;

    @Autowired
    public DepartmentEmployeeService(DepartmentEmployeeMapper departmentEmployeeMapper, DepartmentEmployeeRepository departmentEmployeeRepository) {
        this.departmentEmployeeMapper = departmentEmployeeMapper;
        this.departmentEmployeeRepository = departmentEmployeeRepository;
    }

    public DepartmentEmployeeDTO addDepartmentEmployee(DepartmentEmployeeDTO departmentEmployeeDTO) {
        return departmentEmployeeMapper.toDTO(departmentEmployeeRepository.save(departmentEmployeeMapper.toEntity(departmentEmployeeDTO)));
    }

    public List<DepartmentEmployeeDTO> findAllDepartmentEmployees() {
        return departmentEmployeeRepository.findAll().stream().map(departmentEmployeeMapper::toDTO).collect(Collectors.toList());
    }

    public DepartmentEmployeeDTO updateDepartmentEmployee(DepartmentEmployeeDTO departmentEmployeeDTO) {
        return departmentEmployeeMapper.toDTO(departmentEmployeeRepository.save(departmentEmployeeMapper.updateEntity(departmentEmployeeDTO)));
    }

    public DepartmentEmployeeDTO findDepartmentEmployeeById(Long id) {
        return departmentEmployeeMapper.toDTO(departmentEmployeeRepository.findById(id).orElseThrow(() -> new DepartmentEmployeeNotFoundException(id, 0L, 0L)));
    }

    public void deleteDepartmentEmployee(Long id) {
        departmentEmployeeRepository.deleteById(id);
    }

}
