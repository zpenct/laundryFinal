package com.example.demo.mapper;

import com.example.demo.dto.FasilitasRequestDTO;
import com.example.demo.dto.FasilitasResponseDTO;
import com.example.demo.dto.PesananRequestDTO;
import com.example.demo.dto.PesananResponseDTO;
import com.example.demo.model.Fasilitas;
import com.example.demo.model.Laundry;
import com.example.demo.model.Pesanan;

public class PesananMapper {
    public PesananMapper() {
    }
    public static Pesanan toEntity(PesananRequestDTO dto, Pesanan pesanan){
        return new Pesanan(null,
                dto.nama_pemesan(),
                dto.nama_outlet(),
                dto.fasilitas(),
                dto.berat(),
                dto.hargaKg(),
                dto.total_bayar());
    }

    public static PesananResponseDTO toDTO(Pesanan pesanan){
        return new PesananResponseDTO(pesanan.getId(),
                pesanan.getNama_pemesan(),
                pesanan.getNama_outlet(),
                pesanan.getFasilitas(),
                pesanan.getBerat(),
                pesanan.getHargaKg(),
                pesanan.getTotal_bayar());
    }
}
