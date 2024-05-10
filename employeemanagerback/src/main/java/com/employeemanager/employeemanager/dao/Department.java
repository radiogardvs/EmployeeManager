package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<DepartmentEmployee> departmentEmployees = new HashSet<>();

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

    public Set<DepartmentEmployee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(Set<DepartmentEmployee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
