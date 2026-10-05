package com.haryono.sistempakar.model;

public class RiwayatDiagnosa {
    private int idRiwayat;
    private String tanggal;
    private int idAkun;
    private String namaAkun;
    private String jenisKendaraan;
    private String gejalaDipilih;
    private String kodeKerusakanHasil;
    private String namaKerusakanHasil;
    private double cfAkhir;

    public RiwayatDiagnosa() {
    }

    public int getIdRiwayat() {
        return idRiwayat;
    }

    public void setIdRiwayat(int idRiwayat) {
        this.idRiwayat = idRiwayat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getGejalaDipilih() {
        return gejalaDipilih;
    }

    public void setGejalaDipilih(String gejalaDipilih) {
        this.gejalaDipilih = gejalaDipilih;
    }

    public String getKodeKerusakanHasil() {
        return kodeKerusakanHasil;
    }

    public void setKodeKerusakanHasil(String kodeKerusakanHasil) {
        this.kodeKerusakanHasil = kodeKerusakanHasil;
    }

    public String getNamaKerusakanHasil() {
        return namaKerusakanHasil;
    }

    public void setNamaKerusakanHasil(String namaKerusakanHasil) {
        this.namaKerusakanHasil = namaKerusakanHasil;
    }

    public double getCfAkhir() {
        return cfAkhir;
    }

    public void setCfAkhir(double cfAkhir) {
        this.cfAkhir = cfAkhir;
    }
}
