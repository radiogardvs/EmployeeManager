package com.employeemanager.employeemanager.mapper;
import com.employeemanager.employeemanager.dao.EmployeeTaskAssignment;
import com.employeemanager.employeemanager.dto.EmployeeTaskAssignmentDTO;
import com.employeemanager.employeemanager.exception.EmployeeNotFoundException;
import com.employeemanager.employeemanager.exception.EmployeeTaskAssignmentNotFoundException;
import com.employeemanager.employeemanager.exception.TaskNotFoundException;
import com.employeemanager.employeemanager.repository.EmployeeRepository;
import com.employeemanager.employeemanager.repository.EmployeeTaskAssignmentRepository;
import com.employeemanager.employeemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTaskAssignmentMapper {
    private final EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;
    @Autowired
    public EmployeeTaskAssignmentMapper(EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository, EmployeeRepository employeeRepository, TaskRepository taskRepository){
        this.employeeTaskAssignmentRepository=employeeTaskAssignmentRepository;
        this.employeeRepository=employeeRepository;
        this.taskRepository=taskRepository;
    }
    public EmployeeTaskAssignmentDTO toDTO(EmployeeTaskAssignment employeeTaskAssignment){
        EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO= new EmployeeTaskAssignmentDTO();
        employeeTaskAssignmentDTO.setId(employeeTaskAssignment.getId());
        employeeTaskAssignmentDTO.setEmployeeId(employeeTaskAssignment.getEmployee().getId());
        employeeTaskAssignmentDTO.setTaskId(employeeTaskAssignment.getTask().getId());
        return employeeTaskAssignmentDTO;
    }
    public EmployeeTaskAssignment findEntity(EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO){
        return employeeTaskAssignmentRepository.findById(employeeTaskAssignmentDTO.getId()).orElseThrow(()->
                new EmployeeTaskAssignmentNotFoundException(employeeTaskAssignmentDTO.getId(),employeeTaskAssignmentDTO.getEmployeeId(),employeeTaskAssignmentDTO.getTaskId()));
    }
    public EmployeeTaskAssignment toEntity(EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO){
        EmployeeTaskAssignment employeeTaskAssignment=new EmployeeTaskAssignment();
        employeeTaskAssignment.setEmployee(employeeRepository.findById(employeeTaskAssignmentDTO.getEmployeeId()).orElseThrow(()->
                new EmployeeNotFoundException(employeeTaskAssignmentDTO.getEmployeeId())));
        employeeTaskAssignment.setTask(taskRepository.findById(employeeTaskAssignmentDTO.getTaskId()).orElseThrow(()->
                new TaskNotFoundException(employeeTaskAssignmentDTO.getTaskId())));
        return employeeTaskAssignment;
    }
    public EmployeeTaskAssignment updateEntity(EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO){
        EmployeeTaskAssignment employeeTaskAssignment= employeeTaskAssignmentRepository.findById(employeeTaskAssignmentDTO.getId()).orElseThrow(()->
                new EmployeeTaskAssignmentNotFoundException(employeeTaskAssignmentDTO.getId(),employeeTaskAssignmentDTO.getEmployeeId(), employeeTaskAssignmentDTO.getTaskId()));
        employeeTaskAssignment.setEmployee(employeeRepository.findById(employeeTaskAssignmentDTO.getEmployeeId()).orElseThrow(()->
                new EmployeeNotFoundException(employeeTaskAssignmentDTO.getEmployeeId())));
        employeeTaskAssignment.setTask(taskRepository.findById(employeeTaskAssignmentDTO.getTaskId()).orElseThrow(()->
                new TaskNotFoundException(employeeTaskAssignmentDTO.getTaskId())));
        return employeeTaskAssignment;
    }
}