package com.sam.moh.controller;

import com.sam.moh.entity.Complain;
import com.sam.moh.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/complains")
@CrossOrigin("http://localhost:4200")
public class ComplainController {
    private ComplainService complainService;

    @Autowired
    public  ComplainController(ComplainService complainService){
        this.complainService = complainService;
    }

    @GetMapping
    public Iterable<Complain> findAll(){
        return complainService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Complain> findById(@PathVariable Integer id) {
        return complainService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody Complain complain){
        complainService.save(complain);
    }
}
