package com.employeemanager.employeemanager.dto;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Integer estimatedTime;
    private Integer effectiveTime;
    public TaskDTO(){

    }
    public TaskDTO(String title, String description, Integer estimatedTime, Integer effectiveTime){
        this.title=title;
        this.description=description;
        this.estimatedTime=estimatedTime;
        this.effectiveTime=effectiveTime;
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

    @Override
    public String toString() {
        return "TaskDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", effectiveTime=" + effectiveTime +
                '}';
    }
}
