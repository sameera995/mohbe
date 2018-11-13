package com.sam.moh.controller;

import com.sam.moh.entity.Person;
import com.sam.moh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@CrossOrigin("http://localhost:4200")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;}

    @GetMapping
    public Iterable<Person> findAll(){
        return personService.findAll();

    }

    @GetMapping("{id}")
    public Optional<Person> findById(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody Person person){
        personService.save(person);
    }

    @GetMapping("/personStatus/{personStatus}")
    public List<Person> findAllByEmployeeStatus(@PathVariable String personStatus) {
        return personService.findAllByEmployeeStatus(personStatus);
    }

    @PutMapping("/search")
    public List<Person> search(@RequestBody Person person) {
        return personService.search(person);
    }

}
