package com.sam.moh.repository;

import com.sam.moh.entity.Employee;
import com.sam.moh.entity.enums.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByEmployeeStatus(String employeeStatus);
    List<Employee> findAllByDesignation(Designation designation);
}
