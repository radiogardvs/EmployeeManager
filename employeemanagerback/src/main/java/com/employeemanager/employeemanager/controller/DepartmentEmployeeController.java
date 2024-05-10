package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.DepartmentEmployeeDTO;
import com.employeemanager.employeemanager.service.DepartmentEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departmentemployee")
public class DepartmentEmployeeController {
    private final DepartmentEmployeeService departmentEmployeeService;

    @Autowired
    public DepartmentEmployeeController(DepartmentEmployeeService departmentEmployeeService) {
        this.departmentEmployeeService = departmentEmployeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentEmployeeDTO>> getAllDepartmentEmployees() {
        return new ResponseEntity<>(departmentEmployeeService.findAllDepartmentEmployees(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DepartmentEmployeeDTO> getDepartmentEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(departmentEmployeeService.findDepartmentEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentEmployeeDTO> addDepartmentEmployee(@RequestBody DepartmentEmployeeDTO departmentEmployeeDTO) {
        return new ResponseEntity<>(departmentEmployeeService.addDepartmentEmployee(departmentEmployeeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DepartmentEmployeeDTO> updateDepartmentEmployee(@RequestBody DepartmentEmployeeDTO departmentEmployeeDTO) {
        return new ResponseEntity<>(departmentEmployeeService.updateDepartmentEmployee(departmentEmployeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartmentEmployee(@PathVariable("id") Long id) {
        departmentEmployeeService.deleteDepartmentEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
