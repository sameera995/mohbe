package com.sam.moh.service;

import com.sam.moh.entity.Area;
import com.sam.moh.entity.enums.AreaType;
import com.sam.moh.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class AreaService {
    private AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository){
        this.areaRepository= areaRepository;
    }

    @Transactional
    public Iterable<Area> findAll(){
        return areaRepository.findAll();
    }

    @Transactional
    public Optional<Area> findById(Integer id){
        return areaRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody Area clinic) { areaRepository.save(clinic);
    }

    @Transactional
    public void delete(Integer id){
        areaRepository.deleteById(id);
    }


    @Transactional
    public Iterable<Area> findAllByAreaType(AreaType areaType){ return areaRepository.findAllByAreaType(areaType);}
}
