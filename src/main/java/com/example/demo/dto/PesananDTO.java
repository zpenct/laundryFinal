package com.example.demo.dto;

import com.example.demo.model.Fasilitas;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PesananDTO {
    private Long id;
    private String nama_pemesan;
    private String nama_outlet;
    private double berat;
    private int hargaKg;
    private double total_bayar;
    private Fasilitas fasilitas;

    public PesananDTO() {
    }

    public PesananDTO(Long id, String nama_pemesan, String nama_outlet, double berat, int hargaKg, double total_bayar, Fasilitas fasilitas) {
        this.id = id;
        this.nama_pemesan = nama_pemesan;
        this.nama_outlet = nama_outlet;
        this.berat = berat;
        this.hargaKg = hargaKg;
        this.total_bayar = total_bayar;
        this.fasilitas = fasilitas;
    }

    public PesananDTO(String nama_pemesan, String nama_outlet, double berat, int hargaKg, double total_bayar, Fasilitas fasilitas) {
        this.nama_pemesan = nama_pemesan;
        this.nama_outlet = nama_outlet;
        this.berat = berat;
        this.hargaKg = hargaKg;
        this.total_bayar = total_bayar;
        this.fasilitas = fasilitas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_pemesan() {
        return nama_pemesan;
    }

    public void setNama_pemesan(String nama_pemesan) {
        this.nama_pemesan = nama_pemesan;
    }

    public String getNama_outlet() {
        return nama_outlet;
    }

    public void setNama_outlet(String nama_outlet) {
        this.nama_outlet = nama_outlet;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public int getHargaKg() {
        return hargaKg;
    }

    public void setHargaKg(int hargaKg) {
        this.hargaKg = hargaKg;
    }

    public double getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(double total_bayar) {
        this.total_bayar = total_bayar;
    }

    public Fasilitas getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(Fasilitas fasilitas) {
        this.fasilitas = fasilitas;
    }
}
