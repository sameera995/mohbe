package com.sam.moh.controller;

import com.sam.moh.entity.enums.Designation;
import com.sam.moh.service.EmployeeService;
import com.sam.moh.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @GetMapping("/employeeStatus/{employeeStatus}")
    public List<Employee> findAllByEmployeeStatus(@PathVariable String employeeStatus) {
        return employeeService.findAllByEmployeeStatus(employeeStatus);
    }

    @GetMapping("/designation/{designation}")
    public List<Employee> findAllByDesignation(@PathVariable Designation designation) {
        return employeeService.findAllByDesignation(designation);
    }

    @GetMapping("/getAvailable")
    public List<Employee> getAvailable(
            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @RequestParam LocalTime startTime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @RequestParam LocalTime endTime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate date
            )
    {
       return employeeService.getAvailable(startTime, endTime, date);
    }

    @PutMapping
    public void save(@RequestBody Employee employee){
    employeeService.save(employee);
    }

    @PutMapping("/search")
    public List<Employee> search(@RequestBody Employee employee) {
        return employeeService.search(employee);
    }


}
