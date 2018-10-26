package com.sam.moh.controller;

import com.sam.moh.entity.enums.Designation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/designations")
@CrossOrigin("http://localhost:4200")
public class DesignationController {

    @GetMapping
    public ResponseEntity<Designation[]> findAll() {
        return ResponseEntity.ok(Designation.values());
    }

}