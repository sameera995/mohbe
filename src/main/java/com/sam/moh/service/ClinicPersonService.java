package com.sam.moh.service;

import com.sam.moh.entity.ClinicPerson;
import com.sam.moh.repository.ClinicPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
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
        return clinicPersonRepository.findAllByOrderByDateDesc();
    }

    @Transactional
    public Iterable<ClinicPerson> findAllByPersonId(Integer id){
        return clinicPersonRepository.findAllByPersonId(id);
    }

    @Transactional
    public Optional<ClinicPerson> findById(Integer id){
        return clinicPersonRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody ClinicPerson clinicPerson) {
            clinicPerson.setDate(LocalDate.now());

            double w = Double.parseDouble(clinicPerson.getWeight().toString())/1000;
            double h = Double.parseDouble(clinicPerson.getHeight().toString())/1000;
            double hSquare = h*h;
            double bmi = w/hSquare;
            clinicPerson.setBmi(bmi);
        clinicPersonRepository.save(clinicPerson);
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
