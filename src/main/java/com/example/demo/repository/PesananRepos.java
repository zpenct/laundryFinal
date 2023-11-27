package com.example.demo.repository;

import com.example.demo.dto.PesananRequestDTO;
import com.example.demo.model.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesananRepos extends JpaRepository<Pesanan, Long> {
    List<Pesanan> findAllByNama_outlet(String nama_outlet);
}

