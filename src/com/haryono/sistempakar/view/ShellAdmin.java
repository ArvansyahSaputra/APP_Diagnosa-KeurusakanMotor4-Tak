package com.haryono.sistempakar.view;

import javax.swing.JFrame;



public class ShellAdmin extends javax.swing.JFrame {

    public ShellAdmin() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Dashboard Admin - Bengkel Motor Haryono");
        setSize(1050, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        postInitComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        panelSidebar = new javax.swing.JPanel();

        setTitle("Dashboard Admin - Bengkel Motor Haryono");

        jPanel1.setBackground(new java.awt.Color(23, 32, 46));

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblHeader.setText("Dashboard Admin");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeader)
                    .addComponent(btnLogout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSidebar.setBackground(new java.awt.Color(23, 32, 46));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelSidebar;
    // End of variables declaration//GEN-END:variables


    // ------- Helper tampilan sidebar (pakai palet & rounded button dari UiKit) -------
    private static final int SIDEBAR_WIDTH = 265;

    private final java.util.List<javax.swing.JButton> sidebarButtons = new java.util.ArrayList<>();

    private javax.swing.ImageIcon muatIkon(String nama) {
        java.net.URL url = getClass().getResource("icons/" + nama);
        return url != null ? new javax.swing.ImageIcon(url) : null;
    }

    private void tataHeader() {
        lblHeader.setForeground(com.haryono.sistempakar.view.ui.UiKit.WHITE);
        lblHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 0, 0));
        btnLogout.setIcon(muatIkon("logout_dark.png"));
        com.haryono.sistempakar.view.ui.UiKit.styleSecondaryButton(btnLogout);
        btnLogout.setBackground(java.awt.Color.WHITE);
    }

    private void tataPanelSidebar() {
        panelSidebar.setBackground(com.haryono.sistempakar.view.ui.UiKit.SIDEBAR_BG);
        panelSidebar.setLayout(new javax.swing.BoxLayout(panelSidebar, javax.swing.BoxLayout.Y_AXIS));
        panelSidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 12, 0));
        panelSidebar.setPreferredSize(new java.awt.Dimension(SIDEBAR_WIDTH, 10));
    }

    private void tataPanelContent() {
        panelContent.setBackground(com.haryono.sistempakar.view.ui.UiKit.CONTENT_BG);
    }

    private void tambahLabelGrup(String teks) {
        javax.swing.JLabel lbl = new javax.swing.JLabel(teks);
        lbl.setForeground(com.haryono.sistempakar.view.ui.UiKit.SIDEBAR_GROUP_TEXT);
        lbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 11));
        
        // Border bawaanmu, silakan sesuaikan angka 24 (kiri) jika kurang lurus dengan ikon button
        lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 24, 6, 20));
        
        // 1. Teksnya diratakan ke kiri
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        // 2. KUNCI UTAMA: Kotak label harus memiliki alignment yang SAMA dengan kotak button
        lbl.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        
        // 3. Samakan lebar kotak label dengan lebar kotak button (SIDEBAR_WIDTH - 24)
        lbl.setMaximumSize(new java.awt.Dimension(SIDEBAR_WIDTH - 24, 40));
        lbl.setPreferredSize(new java.awt.Dimension(SIDEBAR_WIDTH - 24, 40));
        
        panelSidebar.add(lbl);
    }

    private javax.swing.JButton tambahTombolMenu(String teks, String namaIkon, Runnable aksi) {
        javax.swing.JButton btn = new javax.swing.JButton(teks);
        btn.setIcon(muatIkon(namaIkon));
        btn.setIconTextGap(12);
        btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn.setUI(new com.haryono.sistempakar.view.ui.RoundedButtonUI(
                com.haryono.sistempakar.view.ui.UiKit.SIDEBAR_BG,
                com.haryono.sistempakar.view.ui.UiKit.SIDEBAR_TEXT, 10));
        btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
        btn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new java.awt.Dimension(SIDEBAR_WIDTH - 24, 42));
        btn.setPreferredSize(new java.awt.Dimension(SIDEBAR_WIDTH - 24, 42));
        btn.addActionListener(evt -> {
            setTombolAktif(btn);
            aksi.run();
        });
        panelSidebar.add(javax.swing.Box.createVerticalStrut(3));
        panelSidebar.add(btn);
        sidebarButtons.add(btn);
        return btn;
    }

    private void setTombolAktif(javax.swing.JButton aktif) {
        for (javax.swing.JButton b : sidebarButtons) {
            com.haryono.sistempakar.view.ui.RoundedButtonUI ui =
                    (com.haryono.sistempakar.view.ui.RoundedButtonUI) b.getUI();
            boolean isAktif = (b == aktif);
            ui.setColors(
                    isAktif ? com.haryono.sistempakar.view.ui.UiKit.SIDEBAR_BG_ACTIVE
                            : com.haryono.sistempakar.view.ui.UiKit.SIDEBAR_BG,
                    com.haryono.sistempakar.view.ui.UiKit.SIDEBAR_TEXT);
            b.setFont(new java.awt.Font("Segoe UI", isAktif ? java.awt.Font.BOLD : java.awt.Font.PLAIN, 13));
            b.repaint();
        }
    }

    private com.haryono.sistempakar.model.Akun akunLogin;
    private java.awt.CardLayout cardLayout;
    private com.haryono.sistempakar.view.PanelDataGejala panelDataGejala;
    private com.haryono.sistempakar.view.PanelDataKerusakan panelDataKerusakan;
    private com.haryono.sistempakar.view.PanelRuleBase panelRuleBase;
    private com.haryono.sistempakar.view.PanelRiwayatDiagnosa panelRiwayatDiagnosa;
    private com.haryono.sistempakar.view.PanelLaporan panelLaporanGejala;
    private com.haryono.sistempakar.view.PanelLaporan panelLaporanKerusakan;
    private com.haryono.sistempakar.view.PanelLaporan panelLaporanRule;
    private com.haryono.sistempakar.view.PanelLaporan panelLaporanRiwayat;

    public ShellAdmin(com.haryono.sistempakar.model.Akun akunLogin) {
        this();
        this.akunLogin = akunLogin;
        lblHeader.setText("Dashboard Admin - " + akunLogin.getNamaLengkap());
    }

    private void postInitComponents() {
        getContentPane().setBackground(com.haryono.sistempakar.view.ui.UiKit.CONTENT_BG);
        tataHeader();
        tataPanelSidebar();
        tataPanelContent();

        cardLayout = new java.awt.CardLayout();
        panelContent.setLayout(cardLayout);

        panelDataGejala = new com.haryono.sistempakar.view.PanelDataGejala();
        panelDataKerusakan = new com.haryono.sistempakar.view.PanelDataKerusakan();
        panelRuleBase = new com.haryono.sistempakar.view.PanelRuleBase();
        panelRiwayatDiagnosa = new com.haryono.sistempakar.view.PanelRiwayatDiagnosa();
        panelLaporanGejala = new com.haryono.sistempakar.view.PanelLaporan("Laporan Data Gejala");
        panelLaporanKerusakan = new com.haryono.sistempakar.view.PanelLaporan("Laporan Data Kerusakan");
        panelLaporanRule = new com.haryono.sistempakar.view.PanelLaporan("Laporan Rule Base & CF Pakar");
        panelLaporanRiwayat = new com.haryono.sistempakar.view.PanelLaporan("Laporan Riwayat Diagnosa");

        panelContent.add(panelDataGejala, "dataGejala");
        panelContent.add(panelDataKerusakan, "dataKerusakan");
        panelContent.add(panelRuleBase, "ruleBase");
        panelContent.add(panelRiwayatDiagnosa, "riwayat");
        panelContent.add(panelLaporanGejala, "laporanGejala");
        panelContent.add(panelLaporanKerusakan, "laporanKerusakan");
        panelContent.add(panelLaporanRule, "laporanRule");
        panelContent.add(panelLaporanRiwayat, "laporanRiwayat");

        tambahLabelGrup("MASTER");
        javax.swing.JButton b1 = tambahTombolMenu("Data Gejala", "clipboard_white.png",
                () -> { panelDataGejala.muatData(); cardLayout.show(panelContent, "dataGejala"); });
        tambahTombolMenu("Data Kerusakan", "wrench_white.png",
                () -> { panelDataKerusakan.muatData(); cardLayout.show(panelContent, "dataKerusakan"); });

        tambahLabelGrup("RULE BASE");
        tambahTombolMenu("Rule Base & CF Pakar", "gear_white.png",
                () -> { panelRuleBase.muatData(); cardLayout.show(panelContent, "ruleBase"); });

        tambahLabelGrup("TRANSAKSI");
        tambahTombolMenu("Riwayat Diagnosa", "clock_white.png",
                () -> { panelRiwayatDiagnosa.muatData(); cardLayout.show(panelContent, "riwayat"); });

        tambahLabelGrup("REPORT");
        tambahTombolMenu("Laporan Data Gejala", "barchart_white.png",
                () -> { 
                    panelLaporanGejala.tampilkanLaporan(); 
                    cardLayout.show(panelContent, "laporanGejala"); // <-- INI KUNCINYA
                });
        tambahTombolMenu("Laporan Data Kerusakan", "barchart_white.png",
                () -> { panelLaporanKerusakan.tampilkanLaporan(); cardLayout.show(panelContent, "laporanKerusakan"); });
        tambahTombolMenu("Laporan Rule Base", "barchart_white.png",
                () -> { panelLaporanRule.tampilkanLaporan(); cardLayout.show(panelContent, "laporanRule"); });
        tambahTombolMenu("Laporan Riwayat Diagnosa", "barchart_white.png",
                () -> { panelLaporanRiwayat.tampilkanLaporan(); cardLayout.show(panelContent, "laporanRiwayat"); });

        panelSidebar.add(javax.swing.Box.createVerticalGlue());

        setTombolAktif(b1);
        cardLayout.show(panelContent, "dataGejala");
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(this, "Yakin ingin logout?",
                "Konfirmasi Logout", javax.swing.JOptionPane.YES_NO_OPTION);
        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            new FormLogin().setVisible(true);
            dispose();
        }
    }
}
