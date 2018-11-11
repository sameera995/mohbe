package com.sam.moh.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ClinicPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private ClinicAllocation clinicAllocation;

    @ManyToOne
    private Person person;

    private Integer height;
    private Integer weight;
    private String vaccination;
    private String thriposha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClinicAllocation getClinicAllocation() {
        return clinicAllocation;
    }

    public void setClinicAllocation(ClinicAllocation clinicAllocation) {
        this.clinicAllocation = clinicAllocation;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getThriposha() {
        return thriposha;
    }

    public void setThriposha(String thriposha) {
        this.thriposha = thriposha;
    }
}
