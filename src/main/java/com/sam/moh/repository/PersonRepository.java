package com.sam.moh.repository;

import com.sam.moh.entity.Person;
import com.sam.moh.entity.enums.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    List<Person> findAllByPersonStatus(String personStatus);
    List<Person> findAllByPersonStatusAndPersonType(String personStatus, PersonType personType);

}
