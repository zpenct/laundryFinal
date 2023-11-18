package com.example.demo.mapper;

import com.example.demo.dto.FasilitasRequestDTO;
import com.example.demo.dto.FasilitasResponseDTO;
import com.example.demo.dto.LaundryRequestDTO;
import com.example.demo.dto.LaundryResponseDTO;
import com.example.demo.model.Fasilitas;
import com.example.demo.model.Laundry;

import java.util.List;
import java.util.stream.Collectors;

public class LaundryMapper {
    private LaundryMapper(){

    }
    public static Fasilitas toEntity(FasilitasRequestDTO dto, Laundry loundry){
        return new Fasilitas(null, dto.fasilitas(), dto.harga(), loundry);
    }
    public static FasilitasResponseDTO toDTO(Fasilitas fasilitas){
        return new FasilitasResponseDTO(fasilitas.getId(), fasilitas.getFasilitas(), fasilitas.getHarga());
    }
    public static Laundry toEntity(LaundryRequestDTO dto){
        return new Laundry(null, dto.nama(), dto.lokasi(), dto.jam_buka(), dto.jam_tutup(), dto.no_hp(),null);
    }
    public static LaundryResponseDTO toDTO(Laundry laundry, List<Fasilitas> fasilitas){
        return new LaundryResponseDTO(
                laundry.getId(),
                laundry.getNama(),
                laundry.getLokasi(),
                laundry.getNo_hp(),
                laundry.getJam_buka(),
                laundry.getJam_tutup(),
                fasilitas
                        .stream()
                        .map(LaundryMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }
}
