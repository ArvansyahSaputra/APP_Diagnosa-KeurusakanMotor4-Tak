package com.haryono.sistempakar.view.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.AbstractBorder;

/**
 * Border dengan sudut membulat (rounded rectangle), dipakai untuk
 * mempercantik JTextField/JPasswordField/JTextArea/JPanel tanpa perlu
 * mengganti tipe kelas komponennya (aman untuk file .form NetBeans).
 */
public class RoundedBorder extends AbstractBorder {

    private final Color color;
    private final int arc;
    private final int padTop;
    private final int padLeft;
    private final int padBottom;
    private final int padRight;

    public RoundedBorder(Color color, int arc, int pad) {
        this(color, arc, pad, pad + 2, pad, pad + 2);
    }

    public RoundedBorder(Color color, int arc, int padTop, int padLeft, int padBottom, int padRight) {
        this.color = color;
        this.arc = arc;
        this.padTop = padTop;
        this.padLeft = padLeft;
        this.padBottom = padBottom;
        this.padRight = padRight;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(1.3f));
        g2.drawRoundRect(x, y, width - 1, height - 1, arc, arc);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(padTop, padLeft, padBottom, padRight);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(padTop, padLeft, padBottom, padRight);
        return insets;
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
