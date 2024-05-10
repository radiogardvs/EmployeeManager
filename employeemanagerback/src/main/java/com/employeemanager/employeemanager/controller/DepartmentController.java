package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.DepartmentDTO;
import com.employeemanager.employeemanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.findAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(departmentService.findDepartmentById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.addDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
