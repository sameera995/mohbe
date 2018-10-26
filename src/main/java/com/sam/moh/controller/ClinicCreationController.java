package com.sam.moh.controller;

import com.sam.moh.entity.ClinicCreation;
import com.sam.moh.service.ClinicCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliniccreations")
@CrossOrigin("http://localhost:4200")
public class ClinicCreationController {

private ClinicCreationService clinicCreationService;

    @Autowired
    public ClinicCreationController(ClinicCreationService clinicCreationService){
        this.clinicCreationService = clinicCreationService;}

    @GetMapping
    public Iterable<ClinicCreation> findAll(){
        return clinicCreationService.findAll();

    }

    @GetMapping("{id}")
    public Optional<ClinicCreation> findById(@PathVariable Integer id) {
        return clinicCreationService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody ClinicCreation clinicCreation){
        clinicCreationService.save(clinicCreation);

    }


//    public void update(Employee employee){
//       employeeService.update(employee);
//    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        clinicCreationService.delete(id);
    }

    @PutMapping("/search")
    public List<ClinicCreation> search(@RequestBody ClinicCreation clinicCreation) {
        return clinicCreationService.search(clinicCreation);
    }


}
