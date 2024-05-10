package com.employeemanager.employeemanager.exception;

public class TaskNoteNotFoundException extends RuntimeException {
    public TaskNoteNotFoundException(Long id, Long taskId, Long noteId) {
        super("The task-note connection with id " + id + " between task with id " + taskId + " and note with id" + noteId + " does not exist");
    }
}
