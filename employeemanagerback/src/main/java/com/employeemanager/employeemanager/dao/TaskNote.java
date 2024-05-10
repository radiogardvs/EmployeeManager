package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="task_note")
public class TaskNote implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="note_id")
    private Note note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskNote{" +
                "id=" + id +
                ", task=" + task +
                ", note=" + note +
                '}';
    }
}
