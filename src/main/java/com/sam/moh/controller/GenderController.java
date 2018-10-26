package com.sam.moh.controller;

import com.sam.moh.entity.enums.Gender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genders")
@CrossOrigin("http://localhost:4200")
public class GenderController {


    @GetMapping
    public ResponseEntity<Gender[]> findAll() {
        return ResponseEntity.ok(Gender.values());
    }

}
