package com.sam.moh.service;

import com.sam.moh.entity.ClinicAllocation;
import com.sam.moh.entity.Employee;
import com.sam.moh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    public List<Employee> findAllByEmployeeStatus(String employeeStatus) {
        return employeeRepository.findAllByEmployeeStatus(employeeStatus);
    }

    @Transactional
    public void save(@RequestBody Employee employee) {
        employeeRepository.save(employee);
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

    @Transactional
    public List<Employee> getAvailable(LocalTime startTime, LocalTime endTime, LocalDate date) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getEmployeeStatus().equals("Active"))
                .filter(employee -> {
                    boolean allowed = true;
                    for (ClinicAllocation clinicAllocation : employee.getClinicAllocationList()) {
                        if (clinicAllocation.getDate().compareTo(date) == 0) {
                            if (startTime.isBefore(clinicAllocation.getEndTime())) {
                                if (endTime.isAfter(clinicAllocation.getStartTime())) {
                                    allowed = false;
                                } else {
                                    allowed = true;
                                }
                            } else {
                                allowed = true;
                            }
                        } else {
                            allowed = true;
                        }
                    }
                    return allowed;
                })
                .collect(Collectors.toList());

    }

}

