package com.example.demo.repository;

import com.example.demo.model.Laundry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaundryRepos extends JpaRepository<Laundry,Long> {
    List<Laundry> findAllByLokasiLike(String lokasi);
}
