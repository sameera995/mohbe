package com.sam.moh.controller;

import com.sam.moh.entity.ClinicAllocation;
import com.sam.moh.service.ClinicAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinicallocs")
@CrossOrigin("http://localhost:4200")
public class ClinicAllocationController {
    private ClinicAllocationService clinicAllocationService;

    @Autowired
    public ClinicAllocationController(ClinicAllocationService clinicAllocationService){
        this.clinicAllocationService = clinicAllocationService;}

    @GetMapping
    public Iterable<ClinicAllocation> findAll(){
        return clinicAllocationService.findAll();

    }

    @GetMapping("{id}")
    public Optional<ClinicAllocation> findById(@PathVariable Integer id) {
        return clinicAllocationService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody ClinicAllocation clinicAllocation){
        clinicAllocationService.save(clinicAllocation);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        clinicAllocationService.delete(id);
    }

    @PutMapping("/search")
    public List<ClinicAllocation> search(@RequestBody ClinicAllocation clinicAllocation) {
        return clinicAllocationService.search(clinicAllocation);
    }
    
}
