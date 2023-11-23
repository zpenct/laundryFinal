package com.example.demo.dto;

import java.util.List;

public record LaundryResponseDTO(Long id, String nama, String lokasi, String jam_buka, String jam_tutup,String no_hp, List<FasilitasResponseDTO> fasilitasList) {}
