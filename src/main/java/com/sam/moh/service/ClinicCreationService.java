package com.sam.moh.service;

import com.sam.moh.entity.ClinicCreation;
import com.sam.moh.repository.ClinicCreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicCreationService {
    private ClinicCreationRepository clinicCreationRepository;

    @Autowired
    public ClinicCreationService(ClinicCreationRepository clinicCreationRepository){
        this.clinicCreationRepository = clinicCreationRepository;
    }

    @Transactional
    public Iterable<ClinicCreation> findAll(){
        return clinicCreationRepository.findAll();
    }

    @Transactional
    public Optional<ClinicCreation> findById(Integer id){
        return clinicCreationRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody ClinicCreation clinicCreation) { clinicCreationRepository.save(clinicCreation);
    }

    @Transactional
    public void delete(Integer id){
        clinicCreationRepository.deleteById(id);
    }

    @Transactional
    public void update(ClinicCreation clinicCreation) {
        clinicCreationRepository.save(clinicCreation);
    }

    @Transactional
    public List<ClinicCreation> search(ClinicCreation clinicCreation) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<ClinicCreation> example = Example.of(clinicCreation, matcher);
        return clinicCreationRepository.findAll(example);
    }

}
