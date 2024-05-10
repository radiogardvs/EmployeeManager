package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.EmployeeEventAssignmentDTO;
import com.employeemanager.employeemanager.dto.EmployeeTaskAssignmentDTO;
import com.employeemanager.employeemanager.service.EmployeeEventAssignmentService;
import com.employeemanager.employeemanager.service.EmployeeTaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeeventassignment")
public class EmployeeEventAssignmentController {
    private final EmployeeEventAssignmentService employeeEventAssignmentService;
    @Autowired
    public EmployeeEventAssignmentController(EmployeeEventAssignmentService employeeEventAssignmentService){
        this.employeeEventAssignmentService=employeeEventAssignmentService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEventAssignmentDTO>> getAllEmployeeEventAssignments() {
        return new ResponseEntity<>(employeeEventAssignmentService.findAllEmployeeEventAssignments(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeEventAssignmentDTO> getEmployeeEventAssignmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeEventAssignmentService.findEmployeeEventAssignmentById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeEventAssignmentDTO> addEmployeeEventAssignment(@RequestBody EmployeeEventAssignmentDTO employeeEventAssignmentDTO) {
        return new ResponseEntity<>(employeeEventAssignmentService.addEmployeeEventAssignment(employeeEventAssignmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeEventAssignmentDTO> updateEmployeeEventAssignment(@RequestBody EmployeeEventAssignmentDTO employeeEventAssignmentDTO) {
        return new ResponseEntity<>(employeeEventAssignmentService.updateEmployeeEventAssignment(employeeEventAssignmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeEventAssignment(@PathVariable("id") Long id) {
        employeeEventAssignmentService.deleteEmployeeEventAssignment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
