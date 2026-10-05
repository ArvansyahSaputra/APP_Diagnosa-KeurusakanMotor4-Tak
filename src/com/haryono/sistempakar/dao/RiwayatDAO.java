package com.haryono.sistempakar.dao;

import com.haryono.sistempakar.Koneksi;
import com.haryono.sistempakar.model.RiwayatDiagnosa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RiwayatDAO {

    public boolean simpan(RiwayatDiagnosa r) {
        String sql = "INSERT INTO riwayat_diagnosa "
                + "(tanggal, id_akun, jenis_kendaraan, gejala_dipilih, kode_kerusakan_hasil, nama_kerusakan_hasil, cf_akhir) "
                + "VALUES (NOW(), ?, ?, ?, ?, ?, ?)";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, r.getIdAkun());
            ps.setString(2, r.getJenisKendaraan());
            ps.setString(3, r.getGejalaDipilih());
            ps.setString(4, r.getKodeKerusakanHasil());
            ps.setString(5, r.getNamaKerusakanHasil());
            ps.setDouble(6, r.getCfAkhir());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan riwayat diagnosa: " + e.getMessage());
            return false;
        }
    }

    public List<RiwayatDiagnosa> getByAkun(int idAkun) {
        List<RiwayatDiagnosa> list = new ArrayList<>();
        String sql = "SELECT rd.*, a.nama_lengkap FROM riwayat_diagnosa rd "
                + "LEFT JOIN akun a ON a.id_akun = rd.id_akun "
                + "WHERE rd.id_akun = ? ORDER BY rd.tanggal DESC";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAkun);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RiwayatDiagnosa r = new RiwayatDiagnosa();
                    r.setIdRiwayat(rs.getInt("id_riwayat"));
                    r.setTanggal(rs.getString("tanggal"));
                    r.setIdAkun(rs.getInt("id_akun"));
                    r.setNamaAkun(rs.getString("nama_lengkap"));
                    r.setJenisKendaraan(rs.getString("jenis_kendaraan"));
                    r.setGejalaDipilih(rs.getString("gejala_dipilih"));
                    r.setKodeKerusakanHasil(rs.getString("kode_kerusakan_hasil"));
                    r.setNamaKerusakanHasil(rs.getString("nama_kerusakan_hasil"));
                    r.setCfAkhir(rs.getDouble("cf_akhir"));
                    list.add(r);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil riwayat diagnosa: " + e.getMessage());
        }
        return list;
    }

    public List<RiwayatDiagnosa> getAll() {
        List<RiwayatDiagnosa> list = new ArrayList<>();
        String sql = "SELECT rd.*, a.nama_lengkap FROM riwayat_diagnosa rd "
                + "LEFT JOIN akun a ON a.id_akun = rd.id_akun "
                + "ORDER BY rd.tanggal DESC";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RiwayatDiagnosa r = new RiwayatDiagnosa();
                r.setIdRiwayat(rs.getInt("id_riwayat"));
                r.setTanggal(rs.getString("tanggal"));
                r.setIdAkun(rs.getInt("id_akun"));
                r.setNamaAkun(rs.getString("nama_lengkap"));
                r.setJenisKendaraan(rs.getString("jenis_kendaraan"));
                r.setGejalaDipilih(rs.getString("gejala_dipilih"));
                r.setKodeKerusakanHasil(rs.getString("kode_kerusakan_hasil"));
                r.setNamaKerusakanHasil(rs.getString("nama_kerusakan_hasil"));
                r.setCfAkhir(rs.getDouble("cf_akhir"));
                list.add(r);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil riwayat diagnosa: " + e.getMessage());
        }
        return list;
    }

    public boolean hapus(int idRiwayat) {
        String sql = "DELETE FROM riwayat_diagnosa WHERE id_riwayat=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRiwayat);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus riwayat: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusSemua() {
        String sql = "DELETE FROM riwayat_diagnosa";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus semua riwayat: " + e.getMessage());
            return false;
        }
    }
}
