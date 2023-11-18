package com.example.demo.service;

import com.example.demo.dto.LaundryRequestDTO;
import com.example.demo.dto.LaundryResponseDTO;

import java.util.List;

public interface LaundryService {
    LaundryResponseDTO create(LaundryRequestDTO dto);
    List<LaundryResponseDTO> getAll(String lokasi); // lokasi optional
    LaundryResponseDTO get(Long id);
}
