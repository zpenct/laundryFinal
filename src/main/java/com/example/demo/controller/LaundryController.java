package com.example.demo.controller;


import com.example.demo.dto.LaundryRequestDTO;
import com.example.demo.service.LaundryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1/laundry")

public class LaundryController {
    private final LaundryService service;

    public LaundryController(LaundryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody LaundryRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity getAll(@RequestParam(name = "lokasi", required = false) String lokasi) {
        return ResponseEntity.ok(service.getAll(lokasi));
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }

}
