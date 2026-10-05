package com.haryono.sistempakar.dao;

import com.haryono.sistempakar.Koneksi;
import com.haryono.sistempakar.model.Kerusakan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class KerusakanDAO {

    public List<Kerusakan> getAllByJenis(String jenisKendaraan) {
        List<Kerusakan> list = new ArrayList<>();
        String sql = "SELECT * FROM kerusakan WHERE jenis_kendaraan = ? ORDER BY kode_kerusakan";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, jenisKendaraan);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data kerusakan: " + e.getMessage());
        }
        return list;
    }

    public List<Kerusakan> getAll() {
        List<Kerusakan> list = new ArrayList<>();
        String sql = "SELECT * FROM kerusakan ORDER BY jenis_kendaraan, kode_kerusakan";
        try (Connection con = Koneksi.getKoneksi();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data kerusakan: " + e.getMessage());
        }
        return list;
    }

    public Kerusakan getByKode(String kodeKerusakan, String jenisKendaraan) {
        String sql = "SELECT * FROM kerusakan WHERE kode_kerusakan=? AND jenis_kendaraan=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kodeKerusakan);
            ps.setString(2, jenisKendaraan);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data kerusakan: " + e.getMessage());
        }
        return null;
    }

    public boolean tambah(Kerusakan k) {
        String sql = "INSERT INTO kerusakan (kode_kerusakan, nama_kerusakan, solusi, jenis_kendaraan) VALUES (?,?,?,?)";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, k.getKodeKerusakan());
            ps.setString(2, k.getNamaKerusakan());
            ps.setString(3, k.getSolusi());
            ps.setString(4, k.getJenisKendaraan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah kerusakan: " + e.getMessage());
            return false;
        }
    }

    public boolean edit(Kerusakan k) {
        String sql = "UPDATE kerusakan SET kode_kerusakan=?, nama_kerusakan=?, solusi=?, jenis_kendaraan=? WHERE id_kerusakan=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, k.getKodeKerusakan());
            ps.setString(2, k.getNamaKerusakan());
            ps.setString(3, k.getSolusi());
            ps.setString(4, k.getJenisKendaraan());
            ps.setInt(5, k.getIdKerusakan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah kerusakan: " + e.getMessage());
            return false;
        }
    }

    public boolean hapus(int idKerusakan) {
        String sql = "DELETE FROM kerusakan WHERE id_kerusakan=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idKerusakan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal menghapus kerusakan (mungkin masih dipakai pada Rule Base): " + e.getMessage());
            return false;
        }
    }

    private Kerusakan mapRow(ResultSet rs) throws SQLException {
        Kerusakan k = new Kerusakan();
        k.setIdKerusakan(rs.getInt("id_kerusakan"));
        k.setKodeKerusakan(rs.getString("kode_kerusakan"));
        k.setNamaKerusakan(rs.getString("nama_kerusakan"));
        k.setSolusi(rs.getString("solusi"));
        k.setJenisKendaraan(rs.getString("jenis_kendaraan"));
        return k;
    }
}
