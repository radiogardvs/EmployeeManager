package com.employeemanager.employeemanager.dto;

public class DepartmentEmployeeDTO {
    private Long id;
    private Long departmentId;
    private Long employeeId;

    public DepartmentEmployeeDTO() {

    }

    public DepartmentEmployeeDTO(Long id, Long departmentId, Long employeeId) {
        this.id = id;
        this.departmentId = departmentId;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "DepartmentEmployeeDTO{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", employeeId=" + employeeId +
                '}';
    }
}
