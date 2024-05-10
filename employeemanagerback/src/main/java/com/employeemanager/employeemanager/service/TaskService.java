package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dao.Task;
import com.employeemanager.employeemanager.dto.TaskDTO;
import com.employeemanager.employeemanager.exception.TaskNotFoundException;
import com.employeemanager.employeemanager.mapper.TaskMapper;
import com.employeemanager.employeemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDTO addTask(TaskDTO taskDTO) {
        return taskMapper.toDTO(taskRepository.save(taskMapper.toEntity(taskDTO)));
    }

    public List<TaskDTO> findAllTasks() {
        return taskRepository.findAll().stream().map(taskMapper::toDTO).collect(Collectors.toList());
    }

    public TaskDTO updateTask(TaskDTO taskDTO) {
        return taskMapper.toDTO(taskRepository.save(taskMapper.updateEntity(taskDTO)));
    }

    public TaskDTO findTaskById(Long id) {
        return taskMapper.toDTO(taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException(id)));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
