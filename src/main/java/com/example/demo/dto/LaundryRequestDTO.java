package com.example.demo.dto;

import java.util.List;

public record  LaundryRequestDTO(String nama, String lokasi, String jam_buka, String jam_tutup,String no_hp, List<FasilitasRequestDTO> fasilitasList) {}
