package com.haryono.sistempakar.view;



public class PanelHasilDiagnosa extends javax.swing.JPanel {

    public PanelHasilDiagnosa() {
        initComponents();
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        scrollTabelHasil = new javax.swing.JScrollPane();
        tabelHasil = new javax.swing.JTable();
        lblKesimpulan = new javax.swing.JLabel();
        txtSolusi = new javax.swing.JTextArea();
        btnDiagnosaLagi = new javax.swing.JButton();

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblJudul.setText("Kesimpulan Diagnosa");

        tabelHasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Jenis Kerusakan", "Nilai CF", "Persentase Keyakinan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTabelHasil.setViewportView(tabelHasil);

        lblKesimpulan.setText("Kesimpulan utama akan tampil di sini.");

        txtSolusi.setColumns(50);
        txtSolusi.setLineWrap(true);
        txtSolusi.setRows(4);
        txtSolusi.setWrapStyleWord(true);

        btnDiagnosaLagi.setText("Diagnosa Lagi");
        btnDiagnosaLagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagnosaLagiActionPerformed(evt);
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
                        .addComponent(scrollTabelHasil))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblKesimpulan))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtSolusi, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(388, 388, 388)
                                .addComponent(lblJudul)))
                        .addGap(0, 377, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDiagnosaLagi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTabelHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKesimpulan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSolusi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(btnDiagnosaLagi)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiagnosaLagi;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKesimpulan;
    private javax.swing.JScrollPane scrollTabelHasil;
    private javax.swing.JTable tabelHasil;
    private javax.swing.JTextArea txtSolusi;
    // End of variables declaration//GEN-END:variables


    private Runnable onDiagnosaLagi;

    public void setOnDiagnosaLagi(Runnable r) {
        this.onDiagnosaLagi = r;
    }

    private void postInitComponents() {
        txtSolusi.setEditable(false);
        setBackground(java.awt.Color.WHITE);

        com.haryono.sistempakar.view.ui.UiKit.stylePrimaryButton(btnDiagnosaLagi);
        com.haryono.sistempakar.view.ui.UiKit.styleTable(tabelHasil);
        txtSolusi.setBorder(new com.haryono.sistempakar.view.ui.RoundedBorder(
                com.haryono.sistempakar.view.ui.UiKit.BORDER, 10, 10));
        txtSolusi.setBackground(com.haryono.sistempakar.view.ui.UiKit.CONTENT_BG);
        txtSolusi.setFont(com.haryono.sistempakar.view.ui.UiKit.FONT_REGULAR);
    }

    public void tampilkanHasil(String jenisKendaraan,
            java.util.List<com.haryono.sistempakar.util.CFEngine.HasilDiagnosa> hasilList) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        com.haryono.sistempakar.util.CFEngine.HasilDiagnosa terbaik = hasilList.get(0);

        lblJudul.setText("<html><center><b>Kesimpulan Diagnosa</b><br>Jenis Kendaraan: "
                + jenisKendaraan + "</center></html>");

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelHasil.getModel();
        model.setRowCount(0);
        for (com.haryono.sistempakar.util.CFEngine.HasilDiagnosa h : hasilList) {
            model.addRow(new Object[]{
                h.getKodeKerusakan(), h.getNamaKerusakan(),
                df.format(h.getCfAkhir()), df.format(h.getPersentase()) + " %"
            });
        }

        lblKesimpulan.setText("<html><b>" + terbaik.getKodeKerusakan() + " - " + terbaik.getNamaKerusakan()
                + "</b> dengan tingkat keyakinan <b>" + df.format(terbaik.getPersentase()) + "%</b></html>");

        txtSolusi.setText("Solusi/Rekomendasi Penanganan:\n"
                + (terbaik.getSolusi() != null && !terbaik.getSolusi().isEmpty()
                        ? terbaik.getSolusi()
                        : "Segera lakukan pemeriksaan pada komponen terkait di bengkel."));
    }

   

    private void btnDiagnosaLagiActionPerformed(java.awt.event.ActionEvent evt) {
        if (onDiagnosaLagi != null) {
            onDiagnosaLagi.run();
        }
    }
}
