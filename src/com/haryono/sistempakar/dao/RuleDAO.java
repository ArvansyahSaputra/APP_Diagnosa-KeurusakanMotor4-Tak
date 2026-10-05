package com.haryono.sistempakar.dao;

import com.haryono.sistempakar.Koneksi;
import com.haryono.sistempakar.model.Rule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RuleDAO {

    public List<Rule> getAllByJenis(String jenisKendaraan) {
        List<Rule> list = new ArrayList<>();
        String sql = "SELECT * FROM rule WHERE jenis_kendaraan = ? ORDER BY kode_rule";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, jenisKendaraan);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data rule: " + e.getMessage());
        }
        // Catatan: daftar gejala tiap rule dilengkapi SETELAH ResultSet di atas
        // ditutup (bukan di dalam while-nya), karena satu koneksi MySQL tidak
        // boleh menjalankan dua query sekaligus secara bersamaan.
        for (Rule r : list) {
            r.setKodeGejalaList(getGejalaForRule(r.getIdRule()));
        }
        return list;
    }

    public List<Rule> getAll() {
        List<Rule> list = new ArrayList<>();
        String sql = "SELECT * FROM rule ORDER BY jenis_kendaraan, kode_rule";
        try (Connection con = Koneksi.getKoneksi();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data rule: " + e.getMessage());
        }
        for (Rule r : list) {
            r.setKodeGejalaList(getGejalaForRule(r.getIdRule()));
        }
        return list;
    }

    private List<String> getGejalaForRule(int idRule) {
        List<String> gejalaList = new ArrayList<>();
        String sql = "SELECT g.kode_gejala FROM rule_gejala rg "
                + "JOIN gejala g ON g.id_gejala = rg.id_gejala "
                + "WHERE rg.id_rule = ? ORDER BY g.kode_gejala";
        try (Connection con = Koneksi.getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRule);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gejalaList.add(rs.getString("kode_gejala"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil gejala rule: " + e.getMessage());
        }
        return gejalaList;
    }

    public boolean tambah(Rule r, List<Integer> idGejalaTerpilih) {
        String sqlRule = "INSERT INTO rule (kode_rule, kode_kerusakan, cf_pakar, jenis_kendaraan) VALUES (?,?,?,?)";
        String sqlDetail = "INSERT INTO rule_gejala (id_rule, id_gejala) VALUES (?,?)";
        try (Connection con = Koneksi.getKoneksi()) {
            con.setAutoCommit(false);
            int idRuleBaru;
            try (PreparedStatement ps = con.prepareStatement(sqlRule, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, r.getKodeRule());
                ps.setString(2, r.getKodeKerusakan());
                ps.setDouble(3, r.getCfPakar());
                ps.setString(4, r.getJenisKendaraan());
                ps.executeUpdate();
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        idRuleBaru = keys.getInt(1);
                    } else {
                        con.rollback();
                        return false;
                    }
                }
            }
            try (PreparedStatement ps2 = con.prepareStatement(sqlDetail)) {
                for (Integer idGejala : idGejalaTerpilih) {
                    ps2.setInt(1, idRuleBaru);
                    ps2.setInt(2, idGejala);
                    ps2.addBatch();
                }
                ps2.executeBatch();
            }
            con.commit();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah rule: " + e.getMessage());
            return false;
        }
    }

    public boolean edit(Rule r, List<Integer> idGejalaTerpilih) {
        String sqlUpdate = "UPDATE rule SET kode_rule=?, kode_kerusakan=?, cf_pakar=?, jenis_kendaraan=? WHERE id_rule=?";
        String sqlHapusDetail = "DELETE FROM rule_gejala WHERE id_rule=?";
        String sqlDetail = "INSERT INTO rule_gejala (id_rule, id_gejala) VALUES (?,?)";
        try (Connection con = Koneksi.getKoneksi()) {
            con.setAutoCommit(false);
            try (PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
                ps.setString(1, r.getKodeRule());
                ps.setString(2, r.getKodeKerusakan());
                ps.setDouble(3, r.getCfPakar());
                ps.setString(4, r.getJenisKendaraan());
                ps.setInt(5, r.getIdRule());
                ps.executeUpdate();
            }
            try (PreparedStatement ps = con.prepareStatement(sqlHapusDetail)) {
                ps.setInt(1, r.getIdRule());
                ps.executeUpdate();
            }
            try (PreparedStatement ps2 = con.prepareStatement(sqlDetail)) {
                for (Integer idGejala : idGejalaTerpilih) {
                    ps2.setInt(1, r.getIdRule());
                    ps2.setInt(2, idGejala);
                    ps2.addBatch();
                }
                ps2.executeBatch();
            }
            con.commit();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah rule: " + e.getMessage());
            return false;
        }
    }

    public boolean hapus(int idRule) {
        String sqlDetail = "DELETE FROM rule_gejala WHERE id_rule=?";
        String sqlRule = "DELETE FROM rule WHERE id_rule=?";
        try (Connection con = Koneksi.getKoneksi()) {
            con.setAutoCommit(false);
            try (PreparedStatement ps = con.prepareStatement(sqlDetail)) {
                ps.setInt(1, idRule);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = con.prepareStatement(sqlRule)) {
                ps.setInt(1, idRule);
                ps.executeUpdate();
            }
            con.commit();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus rule: " + e.getMessage());
            return false;
        }
    }

    private Rule mapRow(ResultSet rs) throws SQLException {
        Rule r = new Rule();
        r.setIdRule(rs.getInt("id_rule"));
        r.setKodeRule(rs.getString("kode_rule"));
        r.setKodeKerusakan(rs.getString("kode_kerusakan"));
        r.setCfPakar(rs.getDouble("cf_pakar"));
        r.setJenisKendaraan(rs.getString("jenis_kendaraan"));
        return r;
    }
}
