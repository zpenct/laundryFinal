package com.example.demo.repository;

import com.example.demo.dto.PesananRequestDTO;
import com.example.demo.model.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesananRepos extends JpaRepository<Pesanan, Long> {
    @Query(value = "SELECT * FROM pesanan WHERE nama_outlet = :namaOutlet", nativeQuery = true)
    List<Pesanan> findAllByNamaOutlet(@Param("namaOutlet") String namaOutlet);
}

