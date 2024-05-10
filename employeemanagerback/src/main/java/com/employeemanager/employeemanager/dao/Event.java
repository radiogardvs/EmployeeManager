package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String eventType;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<EmployeeEventAssignment> employeeEventAssignmentSet = new HashSet<>();
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<EventNote> eventNotes = new HashSet<>();
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<EventRoom> eventRooms =new HashSet<>();

    public Event() {

    }

    public Event(String name, String eventType) {
        this.name = name;
        this.eventType = eventType;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Set<EmployeeEventAssignment> getEmployeeEventAssignmentSet() {
        return employeeEventAssignmentSet;
    }

    public void setEmployeeEventAssignmentSet(Set<EmployeeEventAssignment> employeeEventAssignmentSet) {
        this.employeeEventAssignmentSet = employeeEventAssignmentSet;
    }

    public Set<EventNote> getEventNotes() {
        return eventNotes;
    }

    public void setEventNotes(Set<EventNote> eventNotes) {
        this.eventNotes = eventNotes;
    }

    public Set<EventRoom> getEventRooms() {
        return eventRooms;
    }

    public void setEventRooms(Set<EventRoom> eventRooms) {
        this.eventRooms = eventRooms;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                ", employeeEventAssignmentSet=" + employeeEventAssignmentSet +
                '}';
    }
}
