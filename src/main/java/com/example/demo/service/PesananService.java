package com.example.demo.service;

import com.example.demo.dto.PesananDTO;
import com.example.demo.dto.PesananRequestDTO;
import com.example.demo.dto.PesananResponseDTO;
import com.example.demo.model.Pesanan;

import java.util.List;

public interface PesananService {
    Pesanan createPesanan(PesananDTO dto);
    List<Pesanan> findAllByNama_outlet(String nama_outlet);

    List<Pesanan> getAllPesanan();

    Pesanan getPesananById(Long id);
}

