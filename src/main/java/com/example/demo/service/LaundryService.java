package com.example.demo.service;

import com.example.demo.dto.LaundryRequestDto;
import com.example.demo.dto.LaundryResponseDto;
import com.example.demo.model.Laundry;
import com.example.demo.repository.LaundryRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaundryService {
    private final LaundryRepos laundryRepository;

    public ResponseEntity create(LaundryRequestDto requestDto){
        try {
            Laundry laundry = Laundry.builder()
                    .nama(requestDto.getNama())
                    .no_hp(requestDto.getNo_hp())
                    .jam_buka(requestDto.getJam_buka())
                    .jam_tutup(requestDto.getJam_tutup())
                    .lokasi(requestDto.getLokasi())
                    .build();
            laundryRepository.save(laundry);
            return new ResponseEntity<>("Laundry created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create laundry", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public List<Laundry> getAll(){
        return laundryRepository.findAll();
    }

    public List<Laundry> getByLokasi(String lokasi){
        return laundryRepository.findAllByLokasiLike(lokasi);
    }

    public LaundryResponseDto getById(Long id){
        Laundry laundry = laundryRepository.getById(id);
        return LaundryResponseDto.builder()
                .nama(laundry.getNama())
                .no_hp(laundry.getNo_hp())
                .jam_buka(laundry.getJam_buka())
                .jam_tutup(laundry.getJam_tutup())
                .lokasi(laundry.getLokasi())
                .build();
    }
}