package com.sam.moh.controller;

import com.sam.moh.entity.enums.ClinicType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinicTypes")
@CrossOrigin("http://localhost:4200")
public class ClinicTypeController {
    @GetMapping
    public ResponseEntity<ClinicType[]> findAll() {
        return ResponseEntity.ok(ClinicType.values());
    }

}
