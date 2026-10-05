package com.haryono.sistempakar.model;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private int idRule;
    private String kodeRule;          
    private String kodeKerusakan;     
    private double cfPakar;           
    private String jenisKendaraan;    
    private List<String> kodeGejalaList = new ArrayList<>(); 

    public Rule() {
    }

    public Rule(int idRule, String kodeRule, String kodeKerusakan, double cfPakar, String jenisKendaraan) {
        this.idRule = idRule;
        this.kodeRule = kodeRule;
        this.kodeKerusakan = kodeKerusakan;
        this.cfPakar = cfPakar;
        this.jenisKendaraan = jenisKendaraan;
    }

    public int getIdRule() {
        return idRule;
    }

    public void setIdRule(int idRule) {
        this.idRule = idRule;
    }

    public String getKodeRule() {
        return kodeRule;
    }

    public void setKodeRule(String kodeRule) {
        this.kodeRule = kodeRule;
    }

    public String getKodeKerusakan() {
        return kodeKerusakan;
    }

    public void setKodeKerusakan(String kodeKerusakan) {
        this.kodeKerusakan = kodeKerusakan;
    }

    public double getCfPakar() {
        return cfPakar;
    }

    public void setCfPakar(double cfPakar) {
        this.cfPakar = cfPakar;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public List<String> getKodeGejalaList() {
        return kodeGejalaList;
    }

    public void setKodeGejalaList(List<String> kodeGejalaList) {
        this.kodeGejalaList = kodeGejalaList;
    }

    public String getGejalaGabungan() {
        return String.join(" AND ", kodeGejalaList);
    }

    @Override
    public String toString() {
        return kodeRule + " : IF " + getGejalaGabungan() + " THEN " + kodeKerusakan
                + " (CF=" + cfPakar + ")";
    }
}
