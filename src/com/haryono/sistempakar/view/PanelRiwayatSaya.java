package com.haryono.sistempakar.view;



public class PanelRiwayatSaya extends javax.swing.JPanel {

    public PanelRiwayatSaya() {
        initComponents();
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        scrollTabel = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblJudul.setText("Riwayat Diagnosa Saya");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "Jenis", "Gejala Dipilih", "Kode", "Nama Kerusakan", "CF Akhir (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTabel.setViewportView(tabel);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(368, 368, 368)
                                .addComponent(lblJudul))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCetak)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnCetak))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (akunLogin == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data akun belum dimuat!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Fitur kembali ke tabel
        if (btnCetak.getText().equals("Kembali ke Hasil")) {
            scrollTabel.setViewportView(tabel); // NAMA KOMPONEN DIPERBAIKI
            btnCetak.setText("Cetak"); 
            return; 
        }

        try {
            // Arahkan ke file desain iReport
            String pathJrxml = "src/report/dataRiwayatSaya.jrxml"; 
            
            java.util.HashMap<String, Object> parameters = new java.util.HashMap<>();
            
            // 3. AMBIL ID USER SECARA OTOMATIS (DINAMIS)
            // Tidak perlu pakai angka manual (1 atau 2) lagi!
            int idUserLogin = akunLogin.getIdAkun(); 
            parameters.put("IdAkun", idUserLogin);
            
            // Koneksi & Proses Cetak
            java.sql.Connection conn = com.haryono.sistempakar.Koneksi.getKoneksi(); 
            
            net.sf.jasperreports.engine.JasperReport report = 
                net.sf.jasperreports.engine.JasperCompileManager.compileReport(pathJrxml);
                
            net.sf.jasperreports.engine.JasperPrint print = 
                net.sf.jasperreports.engine.JasperFillManager.fillReport(report, parameters, conn);
            
            // Tampilkan PDF ke Layar
            net.sf.jasperreports.swing.JRViewer viewer = new net.sf.jasperreports.swing.JRViewer(print);
            scrollTabel.setViewportView(viewer); // NAMA KOMPONEN DIPERBAIKI
            
            btnCetak.setText("Kembali ke Hasil");
            
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal mencetak: \n" + ex.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables


    private com.haryono.sistempakar.model.Akun akunLogin;

    public void setAkunLogin(com.haryono.sistempakar.model.Akun akunLogin) {
        this.akunLogin = akunLogin;
        muatData();
    }

    private void postInitComponents() {
        setBackground(java.awt.Color.WHITE);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnCetak);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnRefresh);
        com.haryono.sistempakar.view.ui.UiKit.styleTable(tabel);
        lblJudul.setForeground(com.haryono.sistempakar.view.ui.UiKit.TEXT_DARK);
    }

    public void muatData() {
        if (akunLogin == null) return;
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabel.getModel();
        model.setRowCount(0);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        for (com.haryono.sistempakar.model.RiwayatDiagnosa r
                : new com.haryono.sistempakar.dao.RiwayatDAO().getByAkun(akunLogin.getIdAkun())) {
            model.addRow(new Object[]{
                r.getTanggal(), r.getJenisKendaraan(), r.getGejalaDipilih(),
                r.getKodeKerusakanHasil(), r.getNamaKerusakanHasil(), df.format(r.getCfAkhir() * 100)
            });
        }
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        muatData();
    }
}
