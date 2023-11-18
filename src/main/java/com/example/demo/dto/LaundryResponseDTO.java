package com.example.demo.dto;

import java.util.List;

public record LaundryResponseDTO(Long id, String nama, String lokasi,String no_hp, String jam_buka, String jam_tutup, List<FasilitasResponseDTO> fasilitasList) {}
