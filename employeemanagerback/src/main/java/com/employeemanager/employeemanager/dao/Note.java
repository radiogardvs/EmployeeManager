package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "note")
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<TaskNote> taskNotes = new HashSet<>();
    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<EventNote> eventNotes = new HashSet<>();

    public Note() {

    }

    public Note(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TaskNote> getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(Set<TaskNote> taskNotes) {
        this.taskNotes = taskNotes;
    }

    public Set<EventNote> getEventNotes() {
        return eventNotes;
    }

    public void setEventNotes(Set<EventNote> eventNotes) {
        this.eventNotes = eventNotes;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
