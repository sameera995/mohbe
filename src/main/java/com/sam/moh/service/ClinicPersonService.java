package com.sam.moh.service;

import com.sam.moh.entity.ClinicPerson;
import com.sam.moh.repository.ClinicPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicPersonService {
    private ClinicPersonRepository clinicPersonRepository;

    @Autowired
    public ClinicPersonService(ClinicPersonRepository clinicPersonRepository){
        this.clinicPersonRepository = clinicPersonRepository;
    }

    @Transactional
    public Iterable<ClinicPerson> findAll(){
        return clinicPersonRepository.findAll();
    }

    @Transactional
    public Optional<ClinicPerson> findById(Integer id){
        return clinicPersonRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody ClinicPerson clinicPerson) { clinicPersonRepository.save(clinicPerson);
    }

    @Transactional
    public void delete(Integer id){
        clinicPersonRepository.deleteById(id);
    }

    @Transactional
    public void update(ClinicPerson clinicPerson) {
        clinicPersonRepository.save(clinicPerson);
    }

    @Transactional
    public List<ClinicPerson> search(ClinicPerson clinicPerson) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<ClinicPerson> example = Example.of(clinicPerson, matcher);
        return clinicPersonRepository.findAll(example);
    }
}
