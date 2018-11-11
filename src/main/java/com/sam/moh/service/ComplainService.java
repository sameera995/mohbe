package com.sam.moh.service;

import com.sam.moh.entity.Complain;
import com.sam.moh.repository.ComplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ComplainService {

    private ComplainRepository complainRepository;

    @Autowired
    public ComplainService(ComplainRepository complainRepository){
        this.complainRepository= complainRepository;
    }

    @Transactional
    public Iterable<Complain> findAll(){
        return complainRepository.findAll();
    }

    @Transactional
    public Optional<Complain> findById(Integer id){
        return complainRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody Complain clinic) { complainRepository.save(clinic);
    }
}
