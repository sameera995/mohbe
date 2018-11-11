package com.sam.moh.controller;

import com.sam.moh.entity.Area;
import com.sam.moh.entity.enums.AreaType;
import com.sam.moh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/areas")
@CrossOrigin("http://localhost:4200")
public class AreaController {
    private AreaService areaService;

    @Autowired
    public  AreaController(AreaService areaService){
        this.areaService = areaService;
    }

    @GetMapping
    public Iterable<Area> findAll(){
        return areaService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Area> findById(@PathVariable Integer id) {
        return areaService.findById(id);
    }

    @GetMapping("areaType/{areaType}")
    public Iterable<Area> findAllByAreaType(@PathVariable AreaType areaType){
        return areaService.findAllByAreaType(areaType);
    }

    @PutMapping
    public void save(@RequestBody Area area){
        areaService.save(area);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        areaService.delete(id);
    }

}
