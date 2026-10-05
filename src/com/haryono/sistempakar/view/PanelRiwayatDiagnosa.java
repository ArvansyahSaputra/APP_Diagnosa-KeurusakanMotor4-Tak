package com.haryono.sistempakar.view;



public class PanelRiwayatDiagnosa extends javax.swing.JPanel {

    public PanelRiwayatDiagnosa() {
        initComponents();
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        scrollTabel = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnHapusTerpilih = new javax.swing.JButton();
        btnHapusSemua = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        lblJudul.setText("Riwayat Hasil Diagnosa Pelanggan");
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tanggal", "Pengguna", "Jenis", "Gejala Dipilih", "Kode", "Nama Kerusakan", "CF Akhir (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTabel.setViewportView(tabel);

        btnHapusTerpilih.setText("Hapus Data Terpilih");
        btnHapusTerpilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusTerpilihActionPerformed(evt);
            }
        });

        btnHapusSemua.setText("Hapus Semua Riwayat");
        btnHapusSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusSemuaActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblJudul)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapusTerpilih)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusSemua)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapusTerpilih)
                    .addComponent(btnHapusSemua)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusSemua;
    private javax.swing.JButton btnHapusTerpilih;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables


    private final com.haryono.sistempakar.dao.RiwayatDAO riwayatDAO = new com.haryono.sistempakar.dao.RiwayatDAO();

    private void postInitComponents() {
        setBackground(java.awt.Color.WHITE);
        com.haryono.sistempakar.view.ui.UiKit.styleDangerButton(btnHapusTerpilih);
        com.haryono.sistempakar.view.ui.UiKit.styleDangerButton(btnHapusSemua);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnRefresh);
        com.haryono.sistempakar.view.ui.UiKit.styleTable(tabel);
        muatData();
    }

    public void muatData() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabel.getModel();
        model.setRowCount(0);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        for (com.haryono.sistempakar.model.RiwayatDiagnosa r : riwayatDAO.getAll()) {
            model.addRow(new Object[]{
                r.getIdRiwayat(), r.getTanggal(), r.getNamaAkun(), r.getJenisKendaraan(), r.getGejalaDipilih(),
                r.getKodeKerusakanHasil(), r.getNamaKerusakanHasil(), df.format(r.getCfAkhir() * 100)
            });
        }
    }

    private void btnHapusTerpilihActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tabel.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data pada tabel terlebih dahulu.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) tabel.getModel().getValueAt(row, 0);
        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus riwayat ini?",
                "Konfirmasi Hapus", javax.swing.JOptionPane.YES_NO_OPTION);
        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            riwayatDAO.hapus(id);
            muatData();
        }
    }

    private void btnHapusSemuaActionPerformed(java.awt.event.ActionEvent evt) {
        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus SEMUA data riwayat diagnosa? Tindakan ini tidak dapat dibatalkan.",
                "Konfirmasi Hapus Semua", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            riwayatDAO.hapusSemua();
            muatData();
        }
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        muatData();
    }
}
