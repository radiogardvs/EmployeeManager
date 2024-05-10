package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.TaskNote;
import com.employeemanager.employeemanager.dto.TaskNoteDTO;
import com.employeemanager.employeemanager.exception.NoteNotFoundException;
import com.employeemanager.employeemanager.exception.TaskNotFoundException;
import com.employeemanager.employeemanager.exception.TaskNoteNotFoundException;
import com.employeemanager.employeemanager.repository.NoteRepository;
import com.employeemanager.employeemanager.repository.TaskNoteRepository;
import com.employeemanager.employeemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskNoteMapper {
    private final TaskNoteRepository taskNoteRepository;
    private final TaskRepository taskRepository;
    private final NoteRepository noteRepository;

    @Autowired
    public TaskNoteMapper(TaskNoteRepository taskNoteRepository, TaskRepository taskRepository, NoteRepository noteRepository) {
        this.taskNoteRepository = taskNoteRepository;
        this.taskRepository = taskRepository;
        this.noteRepository = noteRepository;
    }

    public TaskNoteDTO toDTO(TaskNote taskNote) {
        TaskNoteDTO taskNoteDTO = new TaskNoteDTO();
        taskNoteDTO.setId(taskNote.getId());
        taskNoteDTO.setNoteId(taskNote.getNote().getId());
        taskNoteDTO.setTaskId(taskNote.getTask().getId());
        return taskNoteDTO;
    }

    public TaskNote findEntity(TaskNoteDTO taskNoteDTO) {
        return taskNoteRepository.findById(taskNoteDTO.getId()).orElseThrow(() ->
                new TaskNoteNotFoundException(taskNoteDTO.getId(), taskNoteDTO.getTaskId(), taskNoteDTO.getNoteId()));
    }

    public TaskNote toEntity(TaskNoteDTO taskNoteDTO) {
        TaskNote taskNote = new TaskNote();
        taskNote.setTask(taskRepository.findById(taskNoteDTO.getTaskId()).orElseThrow(() ->
                new TaskNotFoundException(taskNoteDTO.getTaskId())));
        taskNote.setNote(noteRepository.findById(taskNoteDTO.getNoteId()).orElseThrow(() ->
                new NoteNotFoundException(taskNoteDTO.getNoteId())));
        return taskNote;
    }

    public TaskNote updateEntity(TaskNoteDTO taskNoteDTO) {
        TaskNote taskNote = taskNoteRepository.findById(taskNoteDTO.getId()).orElseThrow(() ->
                new TaskNoteNotFoundException(taskNoteDTO.getId(), taskNoteDTO.getTaskId(), taskNoteDTO.getNoteId()));
        taskNote.setTask(taskRepository.findById(taskNoteDTO.getTaskId()).orElseThrow(() ->
                new TaskNotFoundException(taskNoteDTO.getTaskId())));
        taskNote.setNote(noteRepository.findById(taskNoteDTO.getNoteId()).orElseThrow(() ->
                new NoteNotFoundException(taskNoteDTO.getNoteId())));
        return taskNote;
    }
}
