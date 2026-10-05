package com.haryono.sistempakar.view.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * ButtonUI kustom yang menggambar tombol dengan sudut membulat (rounded)
 * beserta efek hover dan pressed, menggantikan tampilan kotak standar Swing.
 * Dipasang lewat button.setUI(new RoundedButtonUI(...)) - tidak mengubah
 * tipe kelas komponen aslinya (tetap javax.swing.JButton), jadi aman
 * dipakai bersama file .form NetBeans.
 */
public class RoundedButtonUI extends BasicButtonUI {

    private Color bg;
    private Color bgHover;
    private Color bgPressed;
    private Color fg;
    private final int arc;

    public RoundedButtonUI(Color bg, Color fg, int arc) {
        this.arc = arc;
        setColors(bg, fg);
    }

    public void setColors(Color bg, Color fg) {
        this.bg = bg;
        this.fg = fg;
        this.bgHover = shade(bg, 0.08f);
        this.bgPressed = shade(bg, -0.10f);
    }

    private static Color shade(Color c, float amt) {
        int r = clamp(c.getRed() + Math.round(255 * amt));
        int g = clamp(c.getGreen() + Math.round(255 * amt));
        int b = clamp(c.getBlue() + Math.round(255 * amt));
        return new Color(r, g, b);
    }

    private static int clamp(int v) {
        return Math.max(0, Math.min(255, v));
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton b = (AbstractButton) c;
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setRolloverEnabled(true);
        b.setForeground(fg);
        b.setBorder(BorderFactory.createEmptyBorder(9, 16, 9, 16));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color fill = bg;
        if (!model.isEnabled()) {
            fill = shade(bg, 0.25f);
        } else if (model.isPressed()) {
            fill = bgPressed;
        } else if (model.isRollover()) {
            fill = bgHover;
        }

        g2.setColor(fill);
        g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight() - 1, arc, arc);
        g2.dispose();

        b.setForeground(fg);
        super.paint(g, c);
    }
}
