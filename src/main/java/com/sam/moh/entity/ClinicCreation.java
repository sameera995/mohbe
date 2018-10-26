package com.sam.moh.entity;

import com.sam.moh.entity.enums.ClinicType;
import com.sam.moh.entity.enums.PersonType;

import javax.persistence.*;

@Entity
public class ClinicCreation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ClinicType clinicType;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClinicType getClinicType() {
        return clinicType;
    }

    public void setClinicType(ClinicType clinicType) {
        this.clinicType = clinicType;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
