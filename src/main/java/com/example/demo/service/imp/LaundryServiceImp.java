package com.example.demo.service.imp;

import com.example.demo.dto.LaundryRequestDTO;
import com.example.demo.dto.LaundryResponseDTO;
import com.example.demo.mapper.LaundryMapper;
import com.example.demo.model.Fasilitas;
import com.example.demo.model.Laundry;
import com.example.demo.repository.FasilitasRepos;
import com.example.demo.repository.LaundryRepos;
import com.example.demo.service.LaundryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class LaundryServiceImp implements LaundryService {
    private final LaundryRepos laundryRepos;
    private final FasilitasRepos fasilitasRepos;

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public LaundryServiceImp(LaundryRepos laundryRepos, FasilitasRepos fasilitasRepos) {
        this.laundryRepos = laundryRepos;
        this.fasilitasRepos = fasilitasRepos;
    }

    @Override
    @Transactional
    public LaundryResponseDTO create(LaundryRequestDTO dto) {
        if (dto == null ||
                isNullOrEmpty(dto.nama()) ||
                isNullOrEmpty(dto.lokasi()) ||
                isNullOrEmpty(dto.jam_buka()) ||
                isNullOrEmpty(dto.jam_tutup()) ||
                isNullOrEmpty(dto.no_hp())
            ) {
            throw new IllegalArgumentException("Data Laundry tidak boleh kosong");
        }
        // save loundry
        Laundry loundryResponse = laundryRepos.save(LaundryMapper.toEntity(dto));

        // save fasilitas
        List<Fasilitas> fasilitasResponse = fasilitasRepos.saveAll(
                dto.fasilitasList()
                        .stream()
                        .map(fasilitasRequestDTO -> LaundryMapper.toEntity(fasilitasRequestDTO, loundryResponse))
                        .collect(Collectors.toList())
        );

        return LaundryMapper.toDTO(loundryResponse, fasilitasResponse);
    }

    @Override
    public List<LaundryResponseDTO> getAll(String lokasi) {
        List<Laundry> loundryList = new ArrayList<>();
        if(null != lokasi && !lokasi.isBlank())
            loundryList = laundryRepos.findAllByLokasiLike("%"+lokasi+"%");
        else
            loundryList = laundryRepos.findAll();

        if(loundryList.size() == 0)
            return new ArrayList<>();

        return loundryList
                .stream()
                .map(loundry -> LaundryMapper.toDTO(loundry, loundry.getFasilitasList()))
                .collect(Collectors.toList());
    }

    @Override
    public LaundryResponseDTO get(Long id) {
        Laundry laundryResponse = laundryRepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Laundry with ID " + id + " not found"));
        return LaundryMapper.toDTO(laundryResponse, laundryResponse.getFasilitasList());

    }


}
