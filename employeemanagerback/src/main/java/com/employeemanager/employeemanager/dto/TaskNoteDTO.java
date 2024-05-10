package com.employeemanager.employeemanager.dto;

public class TaskNoteDTO {
    private Long id;
    private Long taskId;
    private Long noteId;

    public TaskNoteDTO() {
    }

    public TaskNoteDTO(Long id, Long taskId, Long noteId) {
        this.id = id;
        this.noteId=noteId;
        this.taskId=taskId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "TaskNoteDTO{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", noteId=" + noteId +
                '}';
    }
}
