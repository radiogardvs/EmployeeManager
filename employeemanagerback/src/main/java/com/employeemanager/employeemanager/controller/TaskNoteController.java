package com.employeemanager.employeemanager.controller;
import com.employeemanager.employeemanager.dto.TaskNoteDTO;
import com.employeemanager.employeemanager.service.TaskNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasknote")
public class TaskNoteController {
    private final TaskNoteService taskNoteService;

    @Autowired
    public TaskNoteController(TaskNoteService taskNoteService) {
        this.taskNoteService = taskNoteService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TaskNoteDTO>> getAllTaskNotes() {
        return new ResponseEntity<>(taskNoteService.findAllTaskNotes(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TaskNoteDTO> getTaskNoteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(taskNoteService.findTaskNoteById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TaskNoteDTO> addTaskNote(@RequestBody TaskNoteDTO taskNoteDTO) {
        return new ResponseEntity<>(taskNoteService.addTaskNote(taskNoteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TaskNoteDTO> updateTaskNote(@RequestBody TaskNoteDTO taskNoteDTO) {
        return new ResponseEntity<>(taskNoteService.updateTaskNote(taskNoteDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTaskNote(@PathVariable("id") Long id) {
        taskNoteService.deleteTaskNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
