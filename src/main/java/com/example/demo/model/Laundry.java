package com.example.demo.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "laundry")
public class
Laundry {
    public Laundry(Long id, String nama, String lokasi, String no_hp, String jam_buka, String jam_tutup) {
        this.id = id;
        this.nama = nama;
        this.lokasi = lokasi;
        this.no_hp = no_hp;
        this.jam_buka = jam_buka;
        this.jam_tutup = jam_tutup;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Laundry() {
    }

    @Column(nullable = false,unique = true)
    private String nama;
    @Column(nullable = false)
    private String lokasi;
    @Column(nullable = false, length = 20)
    private String no_hp;
    @Column(nullable = false, length = 4)
    private String jam_buka;

    @Column(nullable = false, length = 4)
    private String jam_tutup;

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getJam_buka() {
        return jam_buka;
    }

    public void setJam_buka(String jam_buka) {
        this.jam_buka = jam_buka;
    }

    public String getJam_tutup() {
        return jam_tutup;
    }

    public void setJam_tutup(String jam_tutup) {
        this.jam_tutup = jam_tutup;
    }

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