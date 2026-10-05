package com.haryono.sistempakar.view;



public class PanelDataGejala extends javax.swing.JPanel {

    public PanelDataGejala() {
        initComponents();
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKode = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        lblJenis = new javax.swing.JLabel();
        cmbJenis = new javax.swing.JComboBox();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        scrollTabel = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        lblKode.setText("Kode Gejala:");

        txtKode.setColumns(8);

        lblJenis.setText("Jenis Kendaraan:");

        cmbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matic", "Manual" }));

        lblNama.setText("Nama Gejala:");

        txtNama.setColumns(40);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Simpan Perubahan");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBersihkan.setText("Bersihkan Form");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode Gejala", "Nama Gejala", "Jenis Kendaraan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTabel.setViewportView(tabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNama)
                                    .addComponent(lblKode))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKode)
                                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 58, Short.MAX_VALUE)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBersihkan))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJenis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 52, Short.MAX_VALUE)))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJenis)
                        .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKode)
                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHapus)
                        .addComponent(btnBersihkan))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambah)
                        .addComponent(btnEdit)))
                .addGap(18, 18, 18)
                .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox cmbJenis;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblNama;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables


    private final com.haryono.sistempakar.dao.GejalaDAO gejalaDAO = new com.haryono.sistempakar.dao.GejalaDAO();
    private int idTerpilih = -1;

    private void postInitComponents() {
        setBackground(java.awt.Color.WHITE);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnTambah);
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnEdit);
        com.haryono.sistempakar.view.ui.UiKit.styleDangerButton(btnHapus);
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnBersihkan);
        com.haryono.sistempakar.view.ui.UiKit.styleTextField(txtKode);
        com.haryono.sistempakar.view.ui.UiKit.styleTextField(txtNama);
        com.haryono.sistempakar.view.ui.UiKit.styleTable(tabel);
        lblKode.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblNama.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblJenis.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);

        muatData();
        tabel.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabel.getSelectedRow() != -1) {
                isiFormDariTabel();
            }
        });
    }

    public void muatData() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabel.getModel();
        model.setRowCount(0);
        for (com.haryono.sistempakar.model.Gejala g : gejalaDAO.getAll()) {
            model.addRow(new Object[]{g.getIdGejala(), g.getKodeGejala(), g.getNamaGejala(), g.getJenisKendaraan()});
        }
    }

    private void isiFormDariTabel() {
        int row = tabel.getSelectedRow();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabel.getModel();
        idTerpilih = (int) model.getValueAt(row, 0);
        txtKode.setText((String) model.getValueAt(row, 1));
        txtNama.setText((String) model.getValueAt(row, 2));
        cmbJenis.setSelectedItem((String) model.getValueAt(row, 3));
    }

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {
        idTerpilih = -1;
        txtKode.setText("");
        txtNama.setText("");
        tabel.clearSelection();
    }

    private boolean validasiForm() {
        if (txtKode.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Kode dan Nama Gejala wajib diisi.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validasiForm()) return;
        com.haryono.sistempakar.model.Gejala g = new com.haryono.sistempakar.model.Gejala();
        g.setKodeGejala(txtKode.getText().trim());
        g.setNamaGejala(txtNama.getText().trim());
        g.setJenisKendaraan((String) cmbJenis.getSelectedItem());
        if (gejalaDAO.tambah(g)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data gejala berhasil ditambahkan.");
            muatData();
            btnBersihkanActionPerformed(evt);
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (idTerpilih == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data pada tabel terlebih dahulu.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!validasiForm()) return;
        com.haryono.sistempakar.model.Gejala g = new com.haryono.sistempakar.model.Gejala();
        g.setIdGejala(idTerpilih);
        g.setKodeGejala(txtKode.getText().trim());
        g.setNamaGejala(txtNama.getText().trim());
        g.setJenisKendaraan((String) cmbJenis.getSelectedItem());
        if (gejalaDAO.edit(g)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data gejala berhasil diubah.");
            muatData();
            btnBersihkanActionPerformed(evt);
        }
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        if (idTerpilih == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data pada tabel terlebih dahulu.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?",
                "Konfirmasi Hapus", javax.swing.JOptionPane.YES_NO_OPTION);
        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            if (gejalaDAO.hapus(idTerpilih)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data gejala berhasil dihapus.");
                muatData();
                btnBersihkanActionPerformed(evt);
            }
        }
    }
}
