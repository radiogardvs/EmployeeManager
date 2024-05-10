package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Task;
import com.employeemanager.employeemanager.dto.TaskDTO;
import com.employeemanager.employeemanager.exception.TaskNotFoundException;
import com.employeemanager.employeemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskMapper(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO toDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setEffectiveTime(task.getEffectiveTime());
        taskDTO.setEstimatedTime(task.getEstimatedTime());
        return taskDTO;
    }

    public Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setEffectiveTime(taskDTO.getEffectiveTime());
        task.setEstimatedTime(taskDTO.getEstimatedTime());
        return task;
    }

    public Task findEntity(TaskDTO taskDTO) {
        return taskRepository.findById(taskDTO.getId()).orElseThrow(() ->
                new TaskNotFoundException(taskDTO.getId()));
    }

    public Task updateEntity(TaskDTO taskDTO) {
        Task task = taskRepository.findById(taskDTO.getId()).orElseThrow(() ->
                new TaskNotFoundException(taskDTO.getId()));
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setEffectiveTime(taskDTO.getEffectiveTime());
        task.setEstimatedTime(taskDTO.getEstimatedTime());
        return task;
    }
}
