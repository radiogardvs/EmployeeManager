package com.employeemanager.employeemanager.dao;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "employee_event")
public class EmployeeEventAssignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
    public EmployeeEventAssignment(){

    }
    public EmployeeEventAssignment(Employee employee, Event event){
        this.employee=employee;
        this.event=event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EmployeeEventAssignment{" +
                "id=" + id +
                ", employee=" + employee +
                ", event=" + event +
                '}';
    }
}
