package com.sam.moh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sam.moh.entity.enums.AreaType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AreaType areaType;

    @OneToOne
    private Employee employee;

    @JsonIgnore
    @ManyToMany(mappedBy = "area")
    private List<Person> person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
