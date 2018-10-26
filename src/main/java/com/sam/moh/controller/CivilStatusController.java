package com.sam.moh.controller;

import com.sam.moh.entity.enums.CivilStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/civilstatus")
@CrossOrigin("http://localhost:4200")
public class CivilStatusController {

    @GetMapping
    public ResponseEntity<CivilStatus[]> findAll() {
        return ResponseEntity.ok(CivilStatus.values());
    }
}
