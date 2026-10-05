package com.haryono.sistempakar.view;



public class PanelDataKerusakan extends javax.swing.JPanel {

    public PanelDataKerusakan() {
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
        lblSolusi = new javax.swing.JLabel();
        txtSolusi = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        scrollTabel = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        lblKode.setText("Kode Kerusakan:");

        txtKode.setColumns(8);

        lblJenis.setText("Jenis Kendaraan:");

        cmbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matic", "Manual" }));

        lblNama.setText("Nama Kerusakan:");

        txtNama.setColumns(40);

        lblSolusi.setText("Solusi:");

        txtSolusi.setColumns(40);
        txtSolusi.setLineWrap(true);
        txtSolusi.setRows(3);
        txtSolusi.setWrapStyleWord(true);

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
                "ID", "Kode", "Nama Kerusakan", "Solusi", "Jenis Kendaraan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKode)
                            .addComponent(lblNama)
                            .addComponent(lblSolusi))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNama)
                            .addComponent(txtKode)
                            .addComponent(txtSolusi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJenis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBersihkan)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKode)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJenis)
                    .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSolusi)
                    .addComponent(txtSolusi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnBersihkan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
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
    private javax.swing.JLabel lblSolusi;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextArea txtSolusi;
    // End of variables declaration//GEN-END:variables


    private final com.haryono.sistempakar.dao.KerusakanDAO kerusakanDAO = new com.haryono.sistempakar.dao.KerusakanDAO();
    private int idTerpilih = -1;

    private void postInitComponents() {
        setBackground(java.awt.Color.WHITE);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnTambah);
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnEdit);
        com.haryono.sistempakar.view.ui.UiKit.styleDangerButton(btnHapus);
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnBersihkan);
        com.haryono.sistempakar.view.ui.UiKit.styleTextField(txtKode);
        com.haryono.sistempakar.view.ui.UiKit.styleTextField(txtNama);
        com.haryono.sistempakar.view.ui.UiKit.styleTextField(txtSolusi);
        com.haryono.sistempakar.view.ui.UiKit.styleTable(tabel);
        lblKode.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblNama.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblJenis.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblSolusi.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);

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
        for (com.haryono.sistempakar.model.Kerusakan k : kerusakanDAO.getAll()) {
            model.addRow(new Object[]{k.getIdKerusakan(), k.getKodeKerusakan(), k.getNamaKerusakan(),
                k.getSolusi(), k.getJenisKendaraan()});
        }
    }

    private void isiFormDariTabel() {
        int row = tabel.getSelectedRow();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabel.getModel();
        idTerpilih = (int) model.getValueAt(row, 0);
        txtKode.setText((String) model.getValueAt(row, 1));
        txtNama.setText((String) model.getValueAt(row, 2));
        txtSolusi.setText((String) model.getValueAt(row, 3));
        cmbJenis.setSelectedItem((String) model.getValueAt(row, 4));
    }

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {
        idTerpilih = -1;
        txtKode.setText("");
        txtNama.setText("");
        txtSolusi.setText("");
        tabel.clearSelection();
    }

    private boolean validasiForm() {
        if (txtKode.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Kode dan Nama Kerusakan wajib diisi.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validasiForm()) return;
        com.haryono.sistempakar.model.Kerusakan k = new com.haryono.sistempakar.model.Kerusakan();
        k.setKodeKerusakan(txtKode.getText().trim());
        k.setNamaKerusakan(txtNama.getText().trim());
        k.setSolusi(txtSolusi.getText().trim());
        k.setJenisKendaraan((String) cmbJenis.getSelectedItem());
        if (kerusakanDAO.tambah(k)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data kerusakan berhasil ditambahkan.");
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
        com.haryono.sistempakar.model.Kerusakan k = new com.haryono.sistempakar.model.Kerusakan();
        k.setIdKerusakan(idTerpilih);
        k.setKodeKerusakan(txtKode.getText().trim());
        k.setNamaKerusakan(txtNama.getText().trim());
        k.setSolusi(txtSolusi.getText().trim());
        k.setJenisKendaraan((String) cmbJenis.getSelectedItem());
        if (kerusakanDAO.edit(k)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data kerusakan berhasil diubah.");
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
            if (kerusakanDAO.hapus(idTerpilih)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data kerusakan berhasil dihapus.");
                muatData();
                btnBersihkanActionPerformed(evt);
            }
        }
    }
}
