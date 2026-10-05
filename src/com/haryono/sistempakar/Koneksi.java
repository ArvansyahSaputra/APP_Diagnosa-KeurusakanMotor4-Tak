package com.haryono.sistempakar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Arfansyah Saputra
 */
public class Koneksi {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB_NAME = "db_sistempakar_haryono";
    private static final String USER = "root";
    private static final String PASS = "";

    private static final String URL =
            "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME
            + "?useSSL=false&serverTimezone=Asia/Jakarta&allowPublicKeyRetrieval=true";

    private static Connection koneksi;

    public static Connection getKoneksi() {
        try {
            if (koneksi == null || koneksi.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                koneksi = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Driver MySQL (mysql-connector-j) tidak ditemukan.\n"
                    + "Silakan tambahkan file JAR mysql-connector-j pada Libraries project NetBeans.",
                    "Driver Tidak Ditemukan", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal terhubung ke database:\n" + e.getMessage()
                    + "\n\nPastikan XAMPP (Apache & MySQL) sudah berjalan dan\n"
                    + "database '" + DB_NAME + "' sudah diimport melalui phpMyAdmin.",
                    "Koneksi Database Gagal", JOptionPane.ERROR_MESSAGE);
        }
        return koneksi;
    }

    public static void tutupKoneksi() {
        try {
            if (koneksi != null && !koneksi.isClosed()) {
                koneksi.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
