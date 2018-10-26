package com.sam.moh.entity;

import com.sam.moh.entity.enums.CivilStatus;
import com.sam.moh.entity.enums.Designation;
import com.sam.moh.entity.enums.Gender;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nic;
    private String address;
    private String contact;
    private LocalDate dob;
    private String email;
    private Date assignDate;
    private Byte employeeStatus;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;

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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getDob() {return dob;    }

    public void setDob(LocalDate dob) {this.dob = dob;    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Byte getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Byte employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }
}
