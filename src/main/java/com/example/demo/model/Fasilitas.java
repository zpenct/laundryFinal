package com.example.demo.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fasilitas")
public class Fasilitas {
    public Fasilitas(Long id, String fasilitas, Integer harga, Laundry laundry) {
        this.id = id;
        this.fasilitas = fasilitas;
        this.harga = harga;
        this.laundry = laundry;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fasilitas;
    private Integer harga;
    @ManyToOne
    @JoinColumn(name = "id_laundry", referencedColumnName = "id")
    private Laundry laundry;

    @OneToMany(mappedBy = "fasilitas")
    private List<Pesanan> pesananList;

    public Fasilitas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Laundry getLoundry() {
        return laundry;
    }

    public void setLoundry(Laundry laundry) {
        this.laundry = laundry;
    }
}
