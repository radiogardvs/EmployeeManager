package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String description;
    private Integer estimatedTime;
    private Integer effectiveTime;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<EmployeeTaskAssignment> employeeTaskAssignments=new HashSet<>();
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private  Set<TaskNote> taskNotes=new HashSet<>();

    public Task() {
    }

    public Task(String title, String description, Integer estimatedTime, Integer effectiveTime) {
        this.title = title;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.effectiveTime = effectiveTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Integer getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Integer effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Set<EmployeeTaskAssignment> getEmployeeTaskAssignments() {
        return employeeTaskAssignments;
    }

    public void setEmployeeTaskAssignments(Set<EmployeeTaskAssignment> employeeTaskAssignments) {
        this.employeeTaskAssignments = employeeTaskAssignments;
    }

    public Set<TaskNote> getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(Set<TaskNote> taskNotes) {
        this.taskNotes = taskNotes;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", effectiveTime=" + effectiveTime +
                ", employeeTaskAssignments=" + employeeTaskAssignments.toString() +
                '}';
    }
}
