package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.dto.EmployeeTaskAssignmentDTO;
import com.employeemanager.employeemanager.service.EmployeeTaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeetaskassignment")
public class EmployeeTaskAssignmentController {
    private final EmployeeTaskAssignmentService employeeTaskAssignmentService;
    @Autowired
    public EmployeeTaskAssignmentController(EmployeeTaskAssignmentService employeeTaskAssignmentService){
        this.employeeTaskAssignmentService=employeeTaskAssignmentService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeTaskAssignmentDTO>> getAllEmployeeTaskAssignments() {
        return new ResponseEntity<>(employeeTaskAssignmentService.findAllEmployeeTaskAssignments(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeTaskAssignmentDTO> getEmployeeTaskAssignmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeTaskAssignmentService.findEmployeeTaskAssignmentById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeTaskAssignmentDTO> addEmployeeTaskAssignment(@RequestBody EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO) {
        return new ResponseEntity<>(employeeTaskAssignmentService.addEmployeeTaskAssignment(employeeTaskAssignmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeTaskAssignmentDTO> updateEmployeeTaskAssignment(@RequestBody EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO) {
        return new ResponseEntity<>(employeeTaskAssignmentService.updateEmployeeTaskAssignment(employeeTaskAssignmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeTaskAssignment(@PathVariable("id") Long id) {
        employeeTaskAssignmentService.deleteEmployeeTaskAssignment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
