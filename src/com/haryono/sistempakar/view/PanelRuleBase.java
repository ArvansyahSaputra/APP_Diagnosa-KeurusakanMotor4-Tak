package com.haryono.sistempakar.view;



public class PanelRuleBase extends javax.swing.JPanel {

    public PanelRuleBase() {
        initComponents();
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKodeRule = new javax.swing.JLabel();
        txtKodeRule = new javax.swing.JTextField();
        lblJenis = new javax.swing.JLabel();
        cmbJenis = new javax.swing.JComboBox();
        lblCf = new javax.swing.JLabel();
        txtCfPakar = new javax.swing.JTextField();
        lblKerusakan = new javax.swing.JLabel();
        cmbKerusakan = new javax.swing.JComboBox<>();
        lblGejala = new javax.swing.JLabel();
        scrollListGejala = new javax.swing.JScrollPane();
        listGejala = new javax.swing.JList<>();
        lblInfo = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        scrollTabel = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        lblKodeRule.setText("Kode Rule:");

        txtKodeRule.setColumns(8);

        lblJenis.setText("Jenis Kendaraan:");

        cmbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matic", "Manual" }));

        lblCf.setText("CF Pakar (0.0-1.0):");

        txtCfPakar.setColumns(8);

        lblKerusakan.setText("Kesimpulan (THEN):");

        cmbKerusakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKerusakanActionPerformed(evt);
            }
        });

        lblGejala.setText("Kombinasi Gejala (IF):");

        scrollListGejala.setViewportView(listGejala);

        lblInfo.setText("(Tahan CTRL untuk memilih lebih dari satu gejala sebagai kombinasi AND)");

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
                "ID", "Kode Rule", "Kombinasi Gejala (IF)", "Kerusakan (THEN)", "CF Pakar", "Jenis"
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

        jLabel2.setText("<html>Skala Nilai CF Pakar:<br>\n0.90 - 1.00 = Sangat Yakin<br>\n0.70 - 0.89 = Yakin<br>\n0.50 - 0.69 = Cukup Yakin<br>\n0.30 - 0.49 = Ragu-Ragu<br>\n0.10 - 0.29 = Kurang Yakin<br>\n0.00 - 0.09 = Tidak Yakin</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBersihkan))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblKodeRule)
                                        .addGap(71, 71, 71)
                                        .addComponent(txtKodeRule))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCf)
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCfPakar, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblKerusakan)
                                            .addComponent(lblJenis, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(lblGejala))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollListGejala)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblInfo)
                                            .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbKerusakan, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 53, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(lblKodeRule))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(txtKodeRule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCfPakar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lblCf)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(cmbKerusakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollListGejala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnTambah)
                                .addComponent(btnEdit))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBersihkan)
                                .addComponent(btnHapus))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lblKerusakan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGejala)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKerusakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKerusakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKerusakanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox cmbJenis;
    private javax.swing.JComboBox<com.haryono.sistempakar.model.Kerusakan> cmbKerusakan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCf;
    private javax.swing.JLabel lblGejala;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblKerusakan;
    private javax.swing.JLabel lblKodeRule;
    private javax.swing.JList<com.haryono.sistempakar.model.Gejala> listGejala;
    private javax.swing.JScrollPane scrollListGejala;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtCfPakar;
    private javax.swing.JTextField txtKodeRule;
    // End of variables declaration//GEN-END:variables


    private final com.haryono.sistempakar.dao.RuleDAO ruleDAO = new com.haryono.sistempakar.dao.RuleDAO();
    private final com.haryono.sistempakar.dao.GejalaDAO gejalaDAO = new com.haryono.sistempakar.dao.GejalaDAO();
    private final com.haryono.sistempakar.dao.KerusakanDAO kerusakanDAO = new com.haryono.sistempakar.dao.KerusakanDAO();
    private int idTerpilih = -1;

    private void postInitComponents() {
        setBackground(java.awt.Color.WHITE);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnTambah);
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnEdit);
        com.haryono.sistempakar.view.ui.UiKit.styleDangerButton(btnHapus);
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnBersihkan);
        com.haryono.sistempakar.view.ui.UiKit.styleTextField(txtKodeRule);
        com.haryono.sistempakar.view.ui.UiKit.styleTextField(txtCfPakar);
        com.haryono.sistempakar.view.ui.UiKit.styleTable(tabel);
        scrollListGejala.setBorder(new com.haryono.sistempakar.view.ui.RoundedBorder(
                com.haryono.sistempakar.view.ui.UiKit.BORDER, 8, 4));
        lblKodeRule.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblJenis.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblCf.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblKerusakan.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblGejala.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);
        lblInfo.setForeground(com.haryono.sistempakar.view.ui.UiKit.TEXT_MUTED);

        cmbJenis.addActionListener(evt -> {
            muatKerusakanDropdown();
            muatGejalaList();
        });
        muatKerusakanDropdown();
        muatGejalaList();
        muatData();
        tabel.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabel.getSelectedRow() != -1) {
                isiFormDariTabel();
            }
        });
    }

    private void muatKerusakanDropdown() {
        String jenis = (String) cmbJenis.getSelectedItem();
        cmbKerusakan.removeAllItems();
        for (com.haryono.sistempakar.model.Kerusakan k : kerusakanDAO.getAllByJenis(jenis)) {
            cmbKerusakan.addItem(k);
        }
    }

    private void muatGejalaList() {
        String jenis = (String) cmbJenis.getSelectedItem();
        javax.swing.DefaultListModel<com.haryono.sistempakar.model.Gejala> modelList = new javax.swing.DefaultListModel<>();
        for (com.haryono.sistempakar.model.Gejala g : gejalaDAO.getAllByJenis(jenis)) {
            modelList.addElement(g);
        }
        listGejala.setModel(modelList);
    }

    public void muatData() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabel.getModel();
        model.setRowCount(0);
        for (com.haryono.sistempakar.model.Rule r : ruleDAO.getAll()) {
            model.addRow(new Object[]{r.getIdRule(), r.getKodeRule(), r.getGejalaGabungan(),
                r.getKodeKerusakan(), r.getCfPakar(), r.getJenisKendaraan()});
        }
    }

    private void isiFormDariTabel() {
        int row = tabel.getSelectedRow();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabel.getModel();
        idTerpilih = (int) model.getValueAt(row, 0);
        txtKodeRule.setText((String) model.getValueAt(row, 1));
        cmbJenis.setSelectedItem((String) model.getValueAt(row, 5));
        muatKerusakanDropdown();
        muatGejalaList();

        String kodeKerusakan = (String) model.getValueAt(row, 3);
        for (int i = 0; i < cmbKerusakan.getItemCount(); i++) {
            if (cmbKerusakan.getItemAt(i).getKodeKerusakan().equals(kodeKerusakan)) {
                cmbKerusakan.setSelectedIndex(i);
                break;
            }
        }

        txtCfPakar.setText(String.valueOf(model.getValueAt(row, 4)));

        String gejalaGabungan = (String) model.getValueAt(row, 2);
        java.util.List<String> kodeList = new java.util.ArrayList<>();
        for (String s : gejalaGabungan.split(" AND ")) {
            kodeList.add(s.trim());
        }
        java.util.List<Integer> indeksTerpilih = new java.util.ArrayList<>();
        javax.swing.ListModel<com.haryono.sistempakar.model.Gejala> lm = listGejala.getModel();
        for (int i = 0; i < lm.getSize(); i++) {
            if (kodeList.contains(lm.getElementAt(i).getKodeGejala())) {
                indeksTerpilih.add(i);
            }
        }
        int[] arr = indeksTerpilih.stream().mapToInt(Integer::intValue).toArray();
        listGejala.setSelectedIndices(arr);
    }

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {
        idTerpilih = -1;
        txtKodeRule.setText("");
        txtCfPakar.setText("");
        listGejala.clearSelection();
        tabel.clearSelection();
    }

    private boolean validasiForm() {
        if (txtKodeRule.getText().trim().isEmpty() || txtCfPakar.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Kode Rule dan Nilai CF Pakar wajib diisi.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (cmbKerusakan.getSelectedItem() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih kesimpulan kerusakan (THEN) terlebih dahulu.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (listGejala.getSelectedValuesList().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih minimal satu gejala sebagai kombinasi (IF).",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            double cf = Double.parseDouble(txtCfPakar.getText().trim());
            if (cf < 0 || cf > 1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Nilai CF Pakar harus di antara 0.0 sampai 1.0.",
                        "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nilai CF Pakar harus berupa angka desimal, contoh: 0.80",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private java.util.List<Integer> ambilIdGejalaTerpilih() {
        java.util.List<Integer> hasil = new java.util.ArrayList<>();
        for (com.haryono.sistempakar.model.Gejala g : listGejala.getSelectedValuesList()) {
            hasil.add(g.getIdGejala());
        }
        return hasil;
    }

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validasiForm()) return;
        com.haryono.sistempakar.model.Rule r = new com.haryono.sistempakar.model.Rule();
        r.setKodeRule(txtKodeRule.getText().trim());
        r.setKodeKerusakan(((com.haryono.sistempakar.model.Kerusakan) cmbKerusakan.getSelectedItem()).getKodeKerusakan());
        r.setCfPakar(Double.parseDouble(txtCfPakar.getText().trim()));
        r.setJenisKendaraan((String) cmbJenis.getSelectedItem());
        if (ruleDAO.tambah(r, ambilIdGejalaTerpilih())) {
            javax.swing.JOptionPane.showMessageDialog(this, "Rule berhasil ditambahkan.");
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
        com.haryono.sistempakar.model.Rule r = new com.haryono.sistempakar.model.Rule();
        r.setIdRule(idTerpilih);
        r.setKodeRule(txtKodeRule.getText().trim());
        r.setKodeKerusakan(((com.haryono.sistempakar.model.Kerusakan) cmbKerusakan.getSelectedItem()).getKodeKerusakan());
        r.setCfPakar(Double.parseDouble(txtCfPakar.getText().trim()));
        r.setJenisKendaraan((String) cmbJenis.getSelectedItem());
        if (ruleDAO.edit(r, ambilIdGejalaTerpilih())) {
            javax.swing.JOptionPane.showMessageDialog(this, "Rule berhasil diubah.");
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
        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus rule ini?",
                "Konfirmasi Hapus", javax.swing.JOptionPane.YES_NO_OPTION);
        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            if (ruleDAO.hapus(idTerpilih)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Rule berhasil dihapus.");
                muatData();
                btnBersihkanActionPerformed(evt);
            }
        }
    }
}
