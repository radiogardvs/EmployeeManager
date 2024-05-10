package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dto.TaskDTO;
import com.employeemanager.employeemanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>( taskService.addTask(taskDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.updateTask(taskDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

