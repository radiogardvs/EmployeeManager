package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.TaskNoteDTO;
import com.employeemanager.employeemanager.exception.TaskNoteNotFoundException;
import com.employeemanager.employeemanager.mapper.TaskNoteMapper;
import com.employeemanager.employeemanager.repository.TaskNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskNoteService {
    private final TaskNoteRepository taskNoteRepository;
    private final TaskNoteMapper taskNoteMapper;

    @Autowired
    public TaskNoteService(TaskNoteRepository taskNoteRepository, TaskNoteMapper taskNoteMapper) {
        this.taskNoteRepository = taskNoteRepository;
        this.taskNoteMapper = taskNoteMapper;
    }

    public TaskNoteDTO addTaskNote(TaskNoteDTO taskNoteDTO) {
        return taskNoteMapper.toDTO(taskNoteRepository.save(taskNoteMapper.toEntity(taskNoteDTO)));
    }

    public List<TaskNoteDTO> findAllTaskNotes() {
        return taskNoteRepository.findAll().stream().map(taskNoteMapper::toDTO).collect(Collectors.toList());
    }

    public TaskNoteDTO updateTaskNote(TaskNoteDTO taskNoteDTO) {
        return taskNoteMapper.toDTO(taskNoteRepository.save(taskNoteMapper.updateEntity(taskNoteDTO)));
    }

    public TaskNoteDTO findTaskNoteById(Long id) {
        return taskNoteMapper.toDTO(taskNoteRepository.findById(id).orElseThrow(() -> new TaskNoteNotFoundException(id, 0L, 0L)));
    }

    public void deleteTaskNote(Long id) {
        taskNoteRepository.deleteById(id);
    }

}
