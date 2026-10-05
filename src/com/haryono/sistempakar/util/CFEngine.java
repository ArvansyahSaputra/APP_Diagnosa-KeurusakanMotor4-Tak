package com.haryono.sistempakar.util;

import com.haryono.sistempakar.model.Kerusakan;
import com.haryono.sistempakar.model.Rule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CFEngine {

    public static class HasilDiagnosa {
        private final String kodeKerusakan;
        private String namaKerusakan;
        private String solusi;
        private double cfAkhir;
        private final List<String> ruleTerpicu = new ArrayList<>();

        public HasilDiagnosa(String kodeKerusakan) {
            this.kodeKerusakan = kodeKerusakan;
        }

        public String getKodeKerusakan() {
            return kodeKerusakan;
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

        public double getCfAkhir() {
            return cfAkhir;
        }

        public void setCfAkhir(double cfAkhir) {
            this.cfAkhir = cfAkhir;
        }

        public List<String> getRuleTerpicu() {
            return ruleTerpicu;
        }

        public double getPersentase() {
            return cfAkhir * 100.0;
        }
    }

    public List<HasilDiagnosa> diagnosa(Map<String, Double> cfUserPerGejala,
            List<Rule> semuaRule, List<Kerusakan> daftarKerusakan) {

        Map<String, HasilDiagnosa> hasilPerKerusakan = new LinkedHashMap<>();

        for (Rule rule : semuaRule) {
            List<String> gejalaRule = rule.getKodeGejalaList();
            if (gejalaRule == null || gejalaRule.isEmpty()) {
                continue;
            }

            boolean semuaGejalaTerpenuhi = true;
            double cfPremis = Double.MAX_VALUE;

            for (String kodeGejala : gejalaRule) {
                Double cfUser = cfUserPerGejala.get(kodeGejala);
                if (cfUser == null || cfUser <= 0.0) {
                    semuaGejalaTerpenuhi = false;
                    break;
                }
                cfPremis = Math.min(cfPremis, cfUser);
            }

            if (!semuaGejalaTerpenuhi) {
                continue; // rule tidak terpicu (fakta tidak lengkap)
            }

            double cfRule = cfPremis * rule.getCfPakar();
            String kodeKerusakan = rule.getKodeKerusakan();

            HasilDiagnosa hasil = hasilPerKerusakan.get(kodeKerusakan);
            if (hasil == null) {
                hasil = new HasilDiagnosa(kodeKerusakan);
                hasil.setCfAkhir(cfRule);
                hasilPerKerusakan.put(kodeKerusakan, hasil);
            } else {
                double cfLama = hasil.getCfAkhir();
                double cfCombine = cfLama + cfRule * (1 - cfLama);
                hasil.setCfAkhir(cfCombine);
            }
            hasil.getRuleTerpicu().add(rule.getKodeRule());
        }

        // Lengkapi nama kerusakan & solusi
        for (HasilDiagnosa hasil : hasilPerKerusakan.values()) {
            for (Kerusakan k : daftarKerusakan) {
                if (k.getKodeKerusakan().equals(hasil.getKodeKerusakan())) {
                    hasil.setNamaKerusakan(k.getNamaKerusakan());
                    hasil.setSolusi(k.getSolusi());
                    break;
                }
            }
        }

        List<HasilDiagnosa> hasilList = new ArrayList<>(hasilPerKerusakan.values());
        hasilList.sort(Comparator.comparingDouble(HasilDiagnosa::getCfAkhir).reversed());
        return hasilList;
    }

    public static final String[] LABEL_CF_USER = {
        "Tidak Yakin", "Kurang Yakin", "Ragu-Ragu", "Cukup Yakin", "Yakin", "Sangat Yakin"
    };

    public static final double[] NILAI_CF_USER = {
        0.0, 0.2, 0.4, 0.6, 0.8, 1.0
    };

    public static double labelToCf(String label) {
        for (int i = 0; i < LABEL_CF_USER.length; i++) {
            if (LABEL_CF_USER[i].equals(label)) {
                return NILAI_CF_USER[i];
            }
        }
        return 0.0;
    }
}
