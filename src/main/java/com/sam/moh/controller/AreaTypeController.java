package com.sam.moh.controller;

import com.sam.moh.entity.enums.AreaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areatypes")
@CrossOrigin("http://localhost:4200")
public class AreaTypeController {
    @GetMapping
    public ResponseEntity<AreaType[]> findAll() {
        return ResponseEntity.ok(AreaType.values());
    }
}
