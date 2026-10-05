package com.haryono.sistempakar;

import com.haryono.sistempakar.view.FormLogin;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Entry point aplikasi Sistem Pakar Diagnosa Kerusakan Sepeda Motor 4-Tak
 * (Metode Forward Chaining & Certainty Factor)
 * Studi Kasus: Bengkel Motor Haryono, Kota Depok.
 *
 * Tugas Akhir - Arfansyah Saputra (202243502025)
 * Teknik Informatika, Universitas Indraprasta PGRI
 */
public class Main {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new FormLogin().setVisible(true));
    }
}
