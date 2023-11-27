package com.example.demo.controller;

import com.example.demo.dto.PesananDTO;
import com.example.demo.dto.PesananRequestDTO;
import com.example.demo.model.Pesanan;
import com.example.demo.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/pesanan")

public class PesananController {
    private final PesananService pesananService;

    @Autowired
    public PesananController(PesananService pesananService) {
        this.pesananService = pesananService;
    }

    @GetMapping
    public ResponseEntity<List<Pesanan>> getAllPesanan() {
        List<Pesanan> pesananList = pesananService.getAllPesanan();
        return new ResponseEntity<>(pesananList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pesanan> getPesananById(@PathVariable Long id) {
        Pesanan pesanan = pesananService.getPesananById(id);
        if (pesanan != null) {
            return new ResponseEntity<>(pesanan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pesanan> createPesanan(@RequestBody PesananDTO dto) {
        Pesanan pesanan = pesananService.createPesanan(dto);
        return new ResponseEntity<>(pesanan, HttpStatus.CREATED);
    }

    @GetMapping("/name/{nama_outlet}")
    public ResponseEntity<List<Pesanan>> findAllByNama_outlet(@PathVariable String nama_outlet) {
        List<Pesanan> pesananList = pesananService.findAllByNama_outlet(nama_outlet);
        return new ResponseEntity<>(pesananList, HttpStatus.OK);
    }


}