package com.sam.moh.service;

import com.sam.moh.entity.ClinicAllocation;
import com.sam.moh.repository.ClinicAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicAllocationService {
    private ClinicAllocationRepository clinicAllocationRepository;

    @Autowired
    public ClinicAllocationService(ClinicAllocationRepository clinicAllocationRepository){
        this.clinicAllocationRepository = clinicAllocationRepository;
    }

    @Transactional
    public Iterable<ClinicAllocation> findAll(){
        return clinicAllocationRepository.findAll();
    }

    @Transactional
    public Optional<ClinicAllocation> findById(Integer id){
        return clinicAllocationRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody ClinicAllocation clinicAllocation) { clinicAllocationRepository.save(clinicAllocation);
    }

    @Transactional
    public void delete(Integer id){
        clinicAllocationRepository.deleteById(id);
    }

    @Transactional
    public void update(ClinicAllocation clinicAllocation) {
        clinicAllocationRepository.save(clinicAllocation);
    }

    @Transactional
    public List<ClinicAllocation> search(ClinicAllocation clinicAllocation) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<ClinicAllocation> example = Example.of(clinicAllocation, matcher);
        return clinicAllocationRepository.findAll(example);
    }
}
