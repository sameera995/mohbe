package com.sam.moh.service;

import com.sam.moh.entity.Person;
import com.sam.moh.entity.enums.PersonType;
import com.sam.moh.entity.payload.DataSet;
import com.sam.moh.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Console;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Transactional
    public Iterable<Person>findAll(){return personRepository.findAll();}

    @Transactional
    public Optional<Person>findById(Integer id){ return personRepository.findById(id);}

    @Transactional
    public void save(@RequestBody Person person){personRepository.save(person);}

    @Transactional
    public List<Person> search(Person person) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Person> example = Example.of(person, matcher);
        return personRepository.findAll(example);
    }

    @Transactional
    public List<Person> findAllByPersonStatus(String personStatus) {
        return personRepository.findAllByPersonStatus(personStatus);
    }

    @Transactional
    public List<Person> findAllByPersonStatusAndPersonType(String personStatus, Integer personType) {

        return personRepository.findAllByPersonStatusAndPersonType(personStatus,personType);

    }

    @Transactional
    public DataSet getWieghtReport(Integer id) {
        Person person = personRepository.getOne(id);
        DataSet dataSet = new DataSet("Actual Weight");
        person.getClinicPerson().forEach(clinicPerson -> dataSet.getData().add(clinicPerson.getWeight()));
        return dataSet;
    }
}