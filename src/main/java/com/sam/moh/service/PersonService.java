package com.sam.moh.service;

import com.sam.moh.entity.Person;
import com.sam.moh.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

    public List<Person> findAllByEmployeeStatus(String personStatus) {
        return personRepository.findAllByPersonStatus(personStatus);
    }
}
