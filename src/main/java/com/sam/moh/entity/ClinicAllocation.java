package com.sam.moh.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@Entity
public class ClinicAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn (name = "clinic_creation_id")
    private ClinicCreation clinicCreation;

    @ManyToOne
    private Area area;

    private String place;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clinicallocation_employee",
            joinColumns = @JoinColumn(name = "clinic_allocation_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Collection<Employee> employee;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClinicCreation getClinicCreation() {
        return clinicCreation;
    }

    public void setClinicCreation(ClinicCreation clinicCreation) {
        this.clinicCreation = clinicCreation;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Collection<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Collection<Employee> employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() { return description;  }

    public void setDescription(String description) {
        this.description = description;
    }
}
