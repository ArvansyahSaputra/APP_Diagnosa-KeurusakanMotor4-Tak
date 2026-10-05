package com.haryono.sistempakar.model;

public class Kerusakan {
    private int idKerusakan;
    private String kodeKerusakan;
    private String namaKerusakan;
    private String solusi;
    private String jenisKendaraan; 

    public Kerusakan() {
    }

    public Kerusakan(int idKerusakan, String kodeKerusakan, String namaKerusakan,
            String solusi, String jenisKendaraan) {
        this.idKerusakan = idKerusakan;
        this.kodeKerusakan = kodeKerusakan;
        this.namaKerusakan = namaKerusakan;
        this.solusi = solusi;
        this.jenisKendaraan = jenisKendaraan;
    }

    public int getIdKerusakan() {
        return idKerusakan;
    }

    public void setIdKerusakan(int idKerusakan) {
        this.idKerusakan = idKerusakan;
    }

    public String getKodeKerusakan() {
        return kodeKerusakan;
    }

    public void setKodeKerusakan(String kodeKerusakan) {
        this.kodeKerusakan = kodeKerusakan;
    }

    public String getNamaKerusakan() {
        return namaKerusakan;
    }

    public void setNamaKerusakan(String namaKerusakan) {
        this.namaKerusakan = namaKerusakan;
    }

    public String getSolusi() {
        return solusi;
    }

    public void setSolusi(String solusi) {
        this.solusi = solusi;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    @Override
    public String toString() {
        return kodeKerusakan + " - " + namaKerusakan;
    }
}
