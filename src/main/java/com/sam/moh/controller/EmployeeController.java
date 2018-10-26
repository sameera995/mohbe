package com.sam.moh.controller;

import com.sam.moh.service.EmployeeService;
import com.sam.moh.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;}

    @GetMapping
    public Iterable<Employee> findAll(){
        return employeeService.findAll();

    }

    @GetMapping("{id}")
    public Optional<Employee> findById(@PathVariable Integer id) {
        return employeeService.findById(id);

    }

    @PutMapping
    public void save(@RequestBody Employee employee){
    employeeService.save(employee);

    }


//    public void update(Employee employee){
//       employeeService.update(employee);
//    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        employeeService.delete(id);
    }

    @PutMapping("/search")
    public List<Employee> search(@RequestBody Employee employee) {
        return employeeService.search(employee);
    }


}
