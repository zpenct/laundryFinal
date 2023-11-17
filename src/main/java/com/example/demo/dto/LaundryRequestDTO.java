package com.example.demo.dto;

import java.util.List;

public record  LaundryRequestDTO(String nama, String lokasi, List<FasilitasRequestDTO> fasilitasList) {}
