package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "department_employee")
public class DepartmentEmployee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public DepartmentEmployee() {

    }

    public DepartmentEmployee(Department department, Employee employee) {
        this.department = department;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DepartmentEmployee{" +
                "id=" + id +
                ", department=" + department +
                ", employee=" + employee +
                '}';
    }
}
