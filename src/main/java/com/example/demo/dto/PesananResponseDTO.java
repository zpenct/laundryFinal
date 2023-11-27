package com.example.demo.dto;

import com.example.demo.model.Fasilitas;

public record PesananResponseDTO(Long id,String nama_pemesan, String nama_outlet, Fasilitas fasilitas, double berat, int hargaKg, double total_bayar) {
}
