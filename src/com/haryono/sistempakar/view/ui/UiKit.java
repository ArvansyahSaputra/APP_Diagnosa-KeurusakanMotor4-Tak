package com.haryono.sistempakar.view.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;

/**
 * Kumpulan warna dan method bantu untuk mempercantik komponen Swing standar
 * (tombol, tabel, text field) secara konsisten di seluruh aplikasi, tanpa
 * perlu mengubah file .form NetBeans - semua dipanggil dari kode Java biasa
 * (postInitComponents()) yang tidak dikunci oleh GUI Builder.
 */
public class UiKit {

    public static final Color PRIMARY = new Color(37, 99, 235);
    public static final Color PRIMARY_DARK = new Color(29, 78, 216);
    public static final Color DANGER = new Color(185, 28, 28);
    public static final Color DANGER_BG = new Color(254, 226, 226);
    public static final Color NEUTRAL_BG = new Color(241, 245, 249);
    public static final Color NEUTRAL_TEXT = new Color(51, 65, 85);
    public static final Color BORDER = new Color(203, 213, 225);
    public static final Color TEXT_MUTED = new Color(100, 116, 139);
    public static final Color TEXT_DARK = new Color(15, 23, 42);
    public static final Color CONTENT_BG = new Color(248, 250, 252);
    public static final Color WHITE = Color.WHITE;

    public static final Color SIDEBAR_BG = new Color(23, 32, 46);
    public static final Color SIDEBAR_BG_ACTIVE = PRIMARY;
    public static final Color SIDEBAR_TEXT = Color.WHITE;
    public static final Color SIDEBAR_GROUP_TEXT = new Color(148, 163, 184);

    public static final Font FONT_REGULAR = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_BOLD = new Font("Segoe UI", Font.BOLD, 13);

    private UiKit() {
    }

    public static void stylePrimaryButton(AbstractButton b) {
        b.setUI(new RoundedButtonUI(PRIMARY, Color.WHITE, 10));
        b.setFont(FONT_BOLD);
    }

    public static void styleSecondaryButton(AbstractButton b) {
        b.setUI(new RoundedButtonUI(NEUTRAL_BG, NEUTRAL_TEXT, 10));
        b.setFont(FONT_REGULAR);
    }

    public static void styleDangerButton(AbstractButton b) {
        b.setUI(new RoundedButtonUI(DANGER_BG, DANGER, 10));
        b.setFont(FONT_REGULAR);
    }

    public static void styleLinkButton(AbstractButton b) {
        b.setForeground(PRIMARY);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setFont(FONT_REGULAR);
    }

    public static void styleTextField(JTextComponent tf) {
        tf.setBorder(new RoundedBorder(BORDER, 8, 6));
        tf.setFont(FONT_REGULAR);
        tf.setForeground(TEXT_DARK);
    }

    public static void styleTable(JTable table) {
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(new Color(219, 234, 254));
        table.setSelectionForeground(TEXT_DARK);
        table.setFont(FONT_REGULAR);
        table.setFillsViewportHeight(true);

        JTableHeader header = table.getTableHeader();
        header.setBackground(SIDEBAR_BG);
        header.setForeground(Color.WHITE);
        header.setFont(FONT_BOLD);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 36));
        header.setReorderingAllowed(false);
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            {
                setHorizontalAlignment(SwingConstants.LEFT);
                setOpaque(true);
            }

            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected,
                    boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, col);
                setBackground(SIDEBAR_BG);
                setForeground(Color.WHITE);
                setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 8));
                return this;
            }
        });

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected,
                    boolean hasFocus, int row, int col) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, col);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : CONTENT_BG);
                    c.setForeground(TEXT_DARK);
                }
                setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 8));
                return c;
            }
        });
    }
}
