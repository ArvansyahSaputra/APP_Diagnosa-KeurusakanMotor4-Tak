package com.haryono.sistempakar.view;



public class PanelDiagnosa extends javax.swing.JPanel {

    public PanelDiagnosa() {
        initComponents();
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPilihJenis = new javax.swing.JLabel();
        cmbJenisKendaraan = new javax.swing.JComboBox();
        btnTampilkanGejala = new javax.swing.JButton();
        scrollGejala = new javax.swing.JScrollPane();
        panelDaftarGejala = new javax.swing.JPanel();
        btnProses = new javax.swing.JButton();

        lblPilihJenis.setText("Pilih Jenis Transmisi Sepeda Motor:");

        cmbJenisKendaraan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matic", "Manual" }));

        btnTampilkanGejala.setText("Tampilkan Daftar Gejala");
        btnTampilkanGejala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilkanGejalaActionPerformed(evt);
            }
        });

        panelDaftarGejala.setLayout(new javax.swing.BoxLayout(panelDaftarGejala, javax.swing.BoxLayout.Y_AXIS));
        scrollGejala.setViewportView(panelDaftarGejala);

        btnProses.setText("Proses Diagnosa");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollGejala))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPilihJenis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTampilkanGejala)
                        .addGap(0, 418, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPilihJenis)
                    .addComponent(cmbJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTampilkanGejala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollGejala, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(btnProses)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnTampilkanGejala;
    private javax.swing.JComboBox cmbJenisKendaraan;
    private javax.swing.JLabel lblPilihJenis;
    private javax.swing.JPanel panelDaftarGejala;
    private javax.swing.JScrollPane scrollGejala;
    // End of variables declaration//GEN-END:variables


    private com.haryono.sistempakar.model.Akun akunLogin;
    private final java.util.List<BarisGejala> barisGejalaList = new java.util.ArrayList<>();
    private Runnable onDiagnosaSelesai;

    private static class BarisGejala {
        com.haryono.sistempakar.model.Gejala gejala;
        javax.swing.JCheckBox checkBox;
        javax.swing.JComboBox<String> comboKeyakinan;
    }

    public void setAkunLogin(com.haryono.sistempakar.model.Akun akunLogin) {
        this.akunLogin = akunLogin;
    }

    public void setOnDiagnosaSelesai(Runnable r) {
        this.onDiagnosaSelesai = r;
    }

    private void postInitComponents() {
        btnProses.setEnabled(false);
        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnProses);
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnTampilkanGejala);
        lblPilihJenis.setForeground(com.haryono.sistempakar.view.ui.UiKit.NEUTRAL_TEXT);

        setBackground(java.awt.Color.WHITE);
        panelDaftarGejala.setBackground(java.awt.Color.WHITE);
        scrollGejala.setBorder(new com.haryono.sistempakar.view.ui.RoundedBorder(
                com.haryono.sistempakar.view.ui.UiKit.BORDER, 10, 8));
        scrollGejala.getViewport().setBackground(java.awt.Color.WHITE);
    }

    private void btnTampilkanGejalaActionPerformed(java.awt.event.ActionEvent evt) {
        String jenis = (String) cmbJenisKendaraan.getSelectedItem();
        com.haryono.sistempakar.dao.GejalaDAO gejalaDAO = new com.haryono.sistempakar.dao.GejalaDAO();
        java.util.List<com.haryono.sistempakar.model.Gejala> daftarGejala = gejalaDAO.getAllByJenis(jenis);

        panelDaftarGejala.removeAll();
        barisGejalaList.clear();

        if (daftarGejala.isEmpty()) {
            panelDaftarGejala.add(new javax.swing.JLabel("  Data gejala untuk jenis '" + jenis
                    + "' belum tersedia. Silakan tambahkan melalui menu Admin."));
        }

        for (com.haryono.sistempakar.model.Gejala g : daftarGejala) {
            javax.swing.JPanel baris = new javax.swing.JPanel(new java.awt.BorderLayout(8, 0));
            baris.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(241, 245, 249)),
                    new javax.swing.border.EmptyBorder(8, 6, 8, 6)));
            baris.setBackground(java.awt.Color.WHITE);
            baris.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
            baris.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 40));

            javax.swing.JCheckBox chk = new javax.swing.JCheckBox(g.getKodeGejala() + " - " + g.getNamaGejala());
            chk.setBackground(java.awt.Color.WHITE);
            chk.setFont(com.haryono.sistempakar.view.ui.UiKit.FONT_REGULAR);
            chk.setForeground(com.haryono.sistempakar.view.ui.UiKit.TEXT_DARK);
            javax.swing.JComboBox<String> cmbKeyakinan =
                    new javax.swing.JComboBox<>(com.haryono.sistempakar.util.CFEngine.LABEL_CF_USER);
            cmbKeyakinan.setSelectedItem("Tidak Yakin");
            cmbKeyakinan.setEnabled(false);
            cmbKeyakinan.setFont(com.haryono.sistempakar.view.ui.UiKit.FONT_REGULAR);
            chk.addActionListener(e -> cmbKeyakinan.setEnabled(chk.isSelected()));

            baris.add(chk, java.awt.BorderLayout.CENTER);
            baris.add(cmbKeyakinan, java.awt.BorderLayout.EAST);
            panelDaftarGejala.add(baris);

            BarisGejala bg = new BarisGejala();
            bg.gejala = g;
            bg.checkBox = chk;
            bg.comboKeyakinan = cmbKeyakinan;
            barisGejalaList.add(bg);
        }

        btnProses.setEnabled(!daftarGejala.isEmpty());
        panelDaftarGejala.revalidate();
        panelDaftarGejala.repaint();
    }

    public void resetForm() {
        panelDaftarGejala.removeAll();
        barisGejalaList.clear();
        btnProses.setEnabled(false);
        panelDaftarGejala.revalidate();
        panelDaftarGejala.repaint();
    }

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {
        java.util.Map<String, Double> cfUserPerGejala = new java.util.LinkedHashMap<>();
        StringBuilder ringkasan = new StringBuilder();

        for (BarisGejala bg : barisGejalaList) {
            if (bg.checkBox.isSelected()) {
                String label = (String) bg.comboKeyakinan.getSelectedItem();
                double cf = com.haryono.sistempakar.util.CFEngine.labelToCf(label);
                if (cf > 0) {
                    cfUserPerGejala.put(bg.gejala.getKodeGejala(), cf);
                    if (ringkasan.length() > 0) {
                        ringkasan.append("; ");
                    }
                    ringkasan.append(bg.gejala.getKodeGejala()).append("(").append(label).append(")");
                }
            }
        }

        if (cfUserPerGejala.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Silakan centang minimal satu gejala dan pilih tingkat keyakinan (selain 'Tidak Yakin').",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String jenis = (String) cmbJenisKendaraan.getSelectedItem();
        com.haryono.sistempakar.dao.RuleDAO ruleDAO = new com.haryono.sistempakar.dao.RuleDAO();
        com.haryono.sistempakar.dao.KerusakanDAO kerusakanDAO = new com.haryono.sistempakar.dao.KerusakanDAO();
        java.util.List<com.haryono.sistempakar.model.Rule> semuaRule = ruleDAO.getAllByJenis(jenis);
        java.util.List<com.haryono.sistempakar.model.Kerusakan> semuaKerusakan = kerusakanDAO.getAllByJenis(jenis);

        com.haryono.sistempakar.util.CFEngine engine = new com.haryono.sistempakar.util.CFEngine();
        java.util.List<com.haryono.sistempakar.util.CFEngine.HasilDiagnosa> hasilList =
                engine.diagnosa(cfUserPerGejala, semuaRule, semuaKerusakan);

        if (hasilList.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Kombinasi gejala yang dipilih tidak cocok dengan aturan (rule) manapun\n"
                    + "pada basis pengetahuan. Silakan pilih kombinasi gejala lain atau\n"
                    + "hubungi mekanik untuk pemeriksaan lebih lanjut.",
                    "Tidak Ditemukan Kesimpulan", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        com.haryono.sistempakar.util.CFEngine.HasilDiagnosa hasilTertinggi = hasilList.get(0);
        com.haryono.sistempakar.model.RiwayatDiagnosa riwayat = new com.haryono.sistempakar.model.RiwayatDiagnosa();
        riwayat.setIdAkun(akunLogin.getIdAkun());
        riwayat.setJenisKendaraan(jenis);
        riwayat.setGejalaDipilih(ringkasan.toString());
        riwayat.setKodeKerusakanHasil(hasilTertinggi.getKodeKerusakan());
        riwayat.setNamaKerusakanHasil(hasilTertinggi.getNamaKerusakan());
        riwayat.setCfAkhir(hasilTertinggi.getCfAkhir());
        new com.haryono.sistempakar.dao.RiwayatDAO().simpan(riwayat);

        lastJenis = jenis;
        lastHasilList = hasilList;
        if (onDiagnosaSelesai != null) {
            onDiagnosaSelesai.run();
        }
    }

    private String lastJenis;
    private java.util.List<com.haryono.sistempakar.util.CFEngine.HasilDiagnosa> lastHasilList;

    public String getLastJenis() { return lastJenis; }
    public java.util.List<com.haryono.sistempakar.util.CFEngine.HasilDiagnosa> getLastHasilList() { return lastHasilList; }
}
