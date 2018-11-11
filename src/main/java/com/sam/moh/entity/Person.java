package com.sam.moh.entity;

import com.sam.moh.entity.enums.Gender;
import com.sam.moh.entity.enums.PersonType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Enumerated
    private Gender gender;

    private LocalDate dob;
    private Integer contact;
    private String address;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "person_area",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    private Collection<Area> area;

    @Enumerated
    private PersonType personType;

    private String parentName;
    private String parentOccupation;
    private Integer numberOfSiblings;
    private String personStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClinicPerson> clinicPerson;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Collection<Area> getArea() {
        return area;
    }

    public void setArea(Collection<Area> area) {
        this.area = area;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentOccupation() {
        return parentOccupation;
    }

    public void setParentOccupation(String parentOccupation) {
        this.parentOccupation = parentOccupation;
    }

    public Integer getNumberOfSiblings() {
        return numberOfSiblings;
    }

    public void setNumberOfSiblings(Integer numberOfSiblings) {
        this.numberOfSiblings = numberOfSiblings;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<ClinicPerson> getClinicPerson() {
        return clinicPerson;
    }

    public void setClinicPerson(Set<ClinicPerson> clinicPerson) {
        this.clinicPerson = clinicPerson;
    }
}
