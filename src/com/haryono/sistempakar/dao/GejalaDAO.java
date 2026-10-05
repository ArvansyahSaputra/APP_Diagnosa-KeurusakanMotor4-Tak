package com.haryono.sistempakar.dao;

import com.haryono.sistempakar.Koneksi;
import com.haryono.sistempakar.model.Gejala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GejalaDAO {

    public List<Gejala> getAllByJenis(String jenisKendaraan) {
        List<Gejala> list = new ArrayList<>();
        String sql = "SELECT * FROM gejala WHERE jenis_kendaraan = ? ORDER BY kode_gejala";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, jenisKendaraan);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data gejala: " + e.getMessage());
        }
        return list;
    }

    public List<Gejala> getAll() {
        List<Gejala> list = new ArrayList<>();
        String sql = "SELECT * FROM gejala ORDER BY jenis_kendaraan, kode_gejala";
        try (Connection con = Koneksi.getKoneksi();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data gejala: " + e.getMessage());
        }
        return list;
    }

    public boolean tambah(Gejala g) {
        String sql = "INSERT INTO gejala (kode_gejala, nama_gejala, jenis_kendaraan) VALUES (?,?,?)";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, g.getKodeGejala());
            ps.setString(2, g.getNamaGejala());
            ps.setString(3, g.getJenisKendaraan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah gejala: " + e.getMessage());
            return false;
        }
    }

    public boolean edit(Gejala g) {
        String sql = "UPDATE gejala SET kode_gejala=?, nama_gejala=?, jenis_kendaraan=? WHERE id_gejala=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, g.getKodeGejala());
            ps.setString(2, g.getNamaGejala());
            ps.setString(3, g.getJenisKendaraan());
            ps.setInt(4, g.getIdGejala());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah gejala: " + e.getMessage());
            return false;
        }
    }

    public boolean hapus(int idGejala) {
        String sql = "DELETE FROM gejala WHERE id_gejala=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idGejala);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal menghapus gejala (mungkin masih dipakai pada Rule Base): " + e.getMessage());
            return false;
        }
    }

    private Gejala mapRow(ResultSet rs) throws SQLException {
        Gejala g = new Gejala();
        g.setIdGejala(rs.getInt("id_gejala"));
        g.setKodeGejala(rs.getString("kode_gejala"));
        g.setNamaGejala(rs.getString("nama_gejala"));
        g.setJenisKendaraan(rs.getString("jenis_kendaraan"));
        return g;
    }
}
