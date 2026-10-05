package com.haryono.sistempakar.model;

public class Gejala {
    private int idGejala;
    private String kodeGejala;
    private String namaGejala;
    private String jenisKendaraan; 

    public Gejala() {
    }

    public Gejala(int idGejala, String kodeGejala, String namaGejala, String jenisKendaraan) {
        this.idGejala = idGejala;
        this.kodeGejala = kodeGejala;
        this.namaGejala = namaGejala;
        this.jenisKendaraan = jenisKendaraan;
    }

    public int getIdGejala() {
        return idGejala;
    }

    public void setIdGejala(int idGejala) {
        this.idGejala = idGejala;
    }

    public String getKodeGejala() {
        return kodeGejala;
    }

    public void setKodeGejala(String kodeGejala) {
        this.kodeGejala = kodeGejala;
    }

    public String getNamaGejala() {
        return namaGejala;
    }

    public void setNamaGejala(String namaGejala) {
        this.namaGejala = namaGejala;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    @Override
    public String toString() {
        return kodeGejala + " - " + namaGejala;
    }
}
