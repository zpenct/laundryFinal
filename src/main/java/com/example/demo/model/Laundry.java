package com.example.demo.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "laundry")
public class Laundry {
    public Laundry(Long id, String nama, String lokasi) {
        this.id = id;
        this.nama = nama;
        this.lokasi = lokasi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Laundry() {
    }

    private String nama;
    private String lokasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public List<Fasilitas> getFasilitasList() {
        return fasilitasList;
    }

    public void setFasilitasList(List<Fasilitas> fasilitasList) {
        this.fasilitasList = fasilitasList;
    }

    @OneToMany(mappedBy = "laundry")
    private List<Fasilitas> fasilitasList;

}