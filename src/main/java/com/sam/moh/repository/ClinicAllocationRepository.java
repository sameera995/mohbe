package com.sam.moh.repository;

import com.sam.moh.entity.ClinicAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicAllocationRepository extends JpaRepository<ClinicAllocation,Integer> {

    List<ClinicAllocation>findAllByOrderById();

}
