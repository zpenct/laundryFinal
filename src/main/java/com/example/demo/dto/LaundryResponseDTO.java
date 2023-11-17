package com.example.demo.dto;

import java.util.List;

public record LaundryResponseDTO(Long id, String nama, String lokasi, List<FasilitasResponseDTO> fasilitasList) {}
