package com.sam.moh.entity;

import javax.persistence.*;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;

    @OneToOne
    private ClinicAllocation clinicAllocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClinicAllocation getClinicAllocation() {
        return clinicAllocation;
    }

    public void setClinicAllocation(ClinicAllocation clinicAllocation) {
        this.clinicAllocation = clinicAllocation;
    }
}
