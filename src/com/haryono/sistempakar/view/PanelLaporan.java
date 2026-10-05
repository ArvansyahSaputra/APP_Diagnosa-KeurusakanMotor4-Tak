package com.haryono.sistempakar.view;

import java.sql.Connection;
import com.haryono.sistempakar.Koneksi;

public class PanelLaporan extends javax.swing.JPanel {

    public PanelLaporan() {
        initComponents();
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        scrollTabel = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblJudul.setText("Laporan");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTabel.setViewportView(tabel);

        btnCetak.setText("Cetak / Simpan sebagai PDF");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCetak)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables


    private String jenisLaporan = "Laporan Data Gejala";

    public PanelLaporan(String jenisLaporan) {
        this();
        this.jenisLaporan = jenisLaporan;
        lblJudul.setText(jenisLaporan);
        tampilkanLaporan();
    }

    private void postInitComponents() {
        setBackground(java.awt.Color.WHITE);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnCetak);
        com.haryono.sistempakar.view.ui.UiKit.styleTable(tabel);
        lblJudul.setForeground(com.haryono.sistempakar.view.ui.UiKit.TEXT_DARK);
    }

    public void tampilkanLaporan() {
        switch (jenisLaporan) {
            case "Laporan Data Gejala": laporanGejala(); break;
            case "Laporan Data Kerusakan": laporanKerusakan(); break;
            case "Laporan Rule Base & CF Pakar": laporanRule(); break;
            case "Laporan Riwayat Diagnosa": laporanRiwayat(); break;
            default: break;
        }
    }

    private void laporanGejala() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new String[]{"Kode Gejala", "Nama Gejala", "Jenis Kendaraan"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (com.haryono.sistempakar.model.Gejala g : new com.haryono.sistempakar.dao.GejalaDAO().getAll()) {
            model.addRow(new Object[]{g.getKodeGejala(), g.getNamaGejala(), g.getJenisKendaraan()});
        }
        tabel.setModel(model);
    }

    private void laporanKerusakan() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new String[]{"Kode Kerusakan", "Nama Kerusakan", "Solusi", "Jenis Kendaraan"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (com.haryono.sistempakar.model.Kerusakan k : new com.haryono.sistempakar.dao.KerusakanDAO().getAll()) {
            model.addRow(new Object[]{k.getKodeKerusakan(), k.getNamaKerusakan(), k.getSolusi(), k.getJenisKendaraan()});
        }
        tabel.setModel(model);
    }

    private void laporanRule() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new String[]{"Kode Rule", "Kombinasi Gejala (IF)", "Kerusakan (THEN)", "CF Pakar", "Jenis Kendaraan"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (com.haryono.sistempakar.model.Rule r : new com.haryono.sistempakar.dao.RuleDAO().getAll()) {
            model.addRow(new Object[]{r.getKodeRule(), r.getGejalaGabungan(), r.getKodeKerusakan(),
                r.getCfPakar(), r.getJenisKendaraan()});
        }
        tabel.setModel(model);
    }

    private void laporanRiwayat() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new String[]{"Tanggal", "Pengguna", "Jenis Kendaraan", "Gejala Dipilih",
                        "Kode Kerusakan", "Nama Kerusakan", "CF Akhir (%)"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        for (com.haryono.sistempakar.model.RiwayatDiagnosa r : new com.haryono.sistempakar.dao.RiwayatDAO().getAll()) {
            model.addRow(new Object[]{r.getTanggal(), r.getNamaAkun(), r.getJenisKendaraan(), r.getGejalaDipilih(),
                r.getKodeKerusakanHasil(), r.getNamaKerusakanHasil(), df.format(r.getCfAkhir() * 100)});
        }
        tabel.setModel(model);
    }

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {
    if (btnCetak.getText().equals("Kembali ke Tabel")) {
        scrollTabel.setViewportView(tabel); // Kembalikan komponen tabel ke layar
        btnCetak.setText("Cetak / Simpan sebagai PDF"); // Kembalikan nama tombol
        return; // Hentikan proses eksekusi di sini
    }

    try {
        // 1. KITA UBAH EKSTENSI MENJADI .jrxml (BUKAN .jasper LAGI)
        String pathJrxml = "";
        
        switch (jenisLaporan) {
            case "Laporan Data Gejala": 
                pathJrxml = "src/report/dataGejala.jrxml"; 
                break;
            case "Laporan Data Kerusakan": 
                pathJrxml = "src/report/dataKerusakan.jrxml"; 
                break;
            case "Laporan Rule Base & CF Pakar": 
                pathJrxml = "src/report/dataRulebase.jrxml"; 
                break;
            case "Laporan Riwayat Diagnosa": 
                pathJrxml = "src/report/dataRiwayat.jrxml"; 
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(this, "Jenis laporan belum tersedia!");
                return; 
        }
        
        java.util.HashMap<String, Object> parameters = new java.util.HashMap<>();
        java.sql.Connection conn = com.haryono.sistempakar.Koneksi.getKoneksi(); 
        
        // 2. COMPILE PAKSA FILE .jrxml SECARA LANGSUNG
        net.sf.jasperreports.engine.JasperReport report = 
            net.sf.jasperreports.engine.JasperCompileManager.compileReport(pathJrxml);
        
        // 3. RENDER HASIL COMPILE BARU TERSEBUT
        net.sf.jasperreports.engine.JasperPrint print = 
            net.sf.jasperreports.engine.JasperFillManager.fillReport(report, parameters, conn);
        
        // 4. MASUKKAN KE PANEL SEPERTI BIASA
        net.sf.jasperreports.swing.JRViewer viewer = new net.sf.jasperreports.swing.JRViewer(print);
        scrollTabel.setViewportView(viewer);
        btnCetak.setText("Kembali ke Tabel");
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: \n" + e.getMessage(), 
            "Error Cetak Laporan", javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
}
