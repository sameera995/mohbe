package com.sam.moh.service;

import com.sam.moh.entity.Employee;
import com.sam.moh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;}

    @Transactional
    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Transactional
    public Optional<Employee> findById(Integer id){
        return employeeRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody Employee employee) { employeeRepository.save(employee);
    }

    @Transactional
    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> search(Employee employee) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Employee> example = Example.of(employee, matcher);
        return employeeRepository.findAll(example);
    }
}
