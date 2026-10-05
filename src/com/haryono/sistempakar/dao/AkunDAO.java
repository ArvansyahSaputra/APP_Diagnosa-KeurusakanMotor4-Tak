package com.haryono.sistempakar.dao;

import com.haryono.sistempakar.Koneksi;
import com.haryono.sistempakar.model.Akun;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AkunDAO {

    public Akun login(String username, String password) {
        String sql = "SELECT * FROM akun WHERE username=? AND password=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memverifikasi login: " + e.getMessage());
        }
        return null;
    }

    public boolean usernameSudahAda(String username) {
        String sql = "SELECT id_akun FROM akun WHERE username=?";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memeriksa username: " + e.getMessage());
            return true; // anggap sudah ada supaya proses daftar dihentikan (aman)
        }
    }

    public boolean registrasi(Akun akun) {
        String sql = "INSERT INTO akun (nama_lengkap, username, password, role) VALUES (?,?,?,'user')";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, akun.getNamaLengkap());
            ps.setString(2, akun.getUsername());
            ps.setString(3, akun.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mendaftarkan akun: " + e.getMessage());
            return false;
        }
    }

    private Akun mapRow(ResultSet rs) throws SQLException {
        Akun a = new Akun();
        a.setIdAkun(rs.getInt("id_akun"));
        a.setNamaLengkap(rs.getString("nama_lengkap"));
        a.setUsername(rs.getString("username"));
        a.setPassword(rs.getString("password"));
        a.setRole(rs.getString("role"));
        return a;
    }
}
