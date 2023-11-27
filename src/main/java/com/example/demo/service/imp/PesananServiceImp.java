package com.example.demo.service.imp;

import com.example.demo.dto.LaundryResponseDTO;
import com.example.demo.dto.PesananDTO;
import com.example.demo.dto.PesananRequestDTO;
import com.example.demo.dto.PesananResponseDTO;
import com.example.demo.mapper.PesananMapper;
import com.example.demo.model.Laundry;
import com.example.demo.model.Pesanan;
import com.example.demo.repository.FasilitasRepos;
import com.example.demo.repository.PesananRepos;
import com.example.demo.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class PesananServiceImp implements PesananService {
    private final PesananRepos pesananRepos;
//    private final FasilitasRepos fasilitasRepos;

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Autowired
    public PesananServiceImp(PesananRepos pesananRepos) {
        this.pesananRepos = pesananRepos;
    }

    @Override
    public Pesanan createPesanan(PesananDTO dto) {
        if (dto == null ||
                isNullOrEmpty(dto.getNama_outlet()) ||
                isNullOrEmpty(dto.getNama_pemesan())
        ){
            throw new IllegalArgumentException("Data pesanan tidak boleh kosong");
        }

        Pesanan pesanan = new Pesanan();
        pesanan.setNama_pemesan(dto.getNama_pemesan());
        pesanan.setNama_outlet(dto.getNama_outlet());
        pesanan.setFasilitas(dto.getFasilitas());
        pesanan.setBerat(dto.getBerat());
        pesanan.setHargaKg(dto.getHargaKg());
        pesanan.setTotal_bayar(dto.getTotal_bayar());

        Pesanan pesananResponse = pesananRepos.save(pesanan);
        return pesananResponse;
    }

    public List<Pesanan> getAllPesanan() {
        return pesananRepos.findAll();
    }

    public Pesanan getPesananById(Long id) {
        return pesananRepos.findById(id).orElse(null);
    }

    public List<Pesanan> findAllByNama_outlet(String nama_outlet) {
        return pesananRepos.findAllByNama_outlet(nama_outlet);
    }
}
