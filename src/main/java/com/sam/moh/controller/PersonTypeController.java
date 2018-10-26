package com.sam.moh.controller;

import com.sam.moh.entity.enums.PersonType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persontypes")
@CrossOrigin("http://localhost:4200")
public class PersonTypeController {
    @GetMapping
    public ResponseEntity<PersonType[]> findAll() {
        return ResponseEntity.ok(PersonType.values());
    }
}