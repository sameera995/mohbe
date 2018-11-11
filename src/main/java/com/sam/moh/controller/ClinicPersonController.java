package com.sam.moh.controller;

import com.sam.moh.entity.ClinicPerson;
import com.sam.moh.service.ClinicPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinics")
@CrossOrigin("http://localhost:4200")
public class ClinicPersonController {
    private ClinicPersonService clinicPersonService;

    @Autowired
    public ClinicPersonController(ClinicPersonService clinicPersonService){
        this.clinicPersonService = clinicPersonService;}

    @GetMapping
    public Iterable<ClinicPerson> findAll(){
        return clinicPersonService.findAll();

    }

    @GetMapping("{id}")
    public Optional<ClinicPerson> findById(@PathVariable Integer id) {
        return clinicPersonService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody ClinicPerson clinicPerson){
        clinicPersonService.save(clinicPerson);

    }


//    public void update(Employee employee){
//       employeeService.update(employee);
//    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        clinicPersonService.delete(id);
    }

    @PutMapping("/search")
    public List<ClinicPerson> search(@RequestBody ClinicPerson clinicPerson) {
        return clinicPersonService.search(clinicPerson);
    }
}
