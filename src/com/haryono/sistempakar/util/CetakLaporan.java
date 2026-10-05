package com.haryono.sistempakar.util;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CetakLaporan implements Printable {
    private final String judulLaporan;
    private final String[] kolom;
    private final Object[][] data;
    private final int[] lebarKolom;

    private static final String NAMA_INSTANSI = "BENGKEL MOTOR HARYONO";
    private static final String ALAMAT = "Jl. H. Dimun Raya, Kec. Cilodong, Kota Depok, Jawa Barat";
    private static final String TELEPON = "Telp. 0812-xxxx-xxxx";

    // ==== Data buat blok tanda tangan ====
    private static final String KOTA_TANDA_TANGAN = "Depok";
    private static final String JABATAN_PEMILIK = "Pemilik Bengkel Motor Haryono";
    private static final String NAMA_PEMILIK = "Haryono"; // <-- GANTI kalau ada nama lengkapnya

    private static final Color WARNA_HEADER_TABEL = new Color(30, 41, 59);
    private static final Color WARNA_ZEBRA = new Color(241, 245, 249);
    private static final Color WARNA_AKSEN = new Color(37, 99, 235);

    private static final int TINGGI_BARIS = 20;
    private static final int TINGGI_KOP_HALAMAN_PERTAMA = 200; 
    private static final int TINGGI_AWAL_HALAMAN_LANJUTAN = 55; 
    private static final int MARGIN_BAWAH = 25;
    private static final int TINGGI_BLOK_TANDA_TANGAN = 165;

    private static BufferedImage logoCache;
    private static boolean sudahCobaMuatLogo = false;

    private List<Integer> awalBarisPerHalaman;
    private boolean tandaTanganPisahHalaman;
    private int totalHalaman = -1;

    private CetakLaporan(String judulLaporan, String[] kolom, Object[][] data, int[] lebarKolom) {
        this.judulLaporan = judulLaporan;
        this.kolom = kolom;
        this.data = data;
        this.lebarKolom = lebarKolom;
    }

    public static void cetak(String judulLaporan, String[] kolom, Object[][] data, int[] lebarKolom) {
        CetakLaporan laporan = new CetakLaporan(judulLaporan, kolom, data, lebarKolom);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(laporan);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, "Gagal mencetak: " + e.getMessage());
            }
        }
    }

    private static BufferedImage muatLogo() {
        if (sudahCobaMuatLogo) {
            return logoCache;
        }
        sudahCobaMuatLogo = true;
        try (InputStream in = CetakLaporan.class.getResourceAsStream("images/logoo.png")) {
            if (in != null) {
                logoCache = ImageIO.read(in);
            }
        } catch (IOException e) {
            logoCache = null;
        }
        return logoCache;
    }

    private void hitungPembagianHalaman(PageFormat pf) {
        if (totalHalaman != -1) {
            return;
        }
        int tinggiHalaman = (int) pf.getImageableHeight();

        awalBarisPerHalaman = new ArrayList<>();
        int barisSudah = 0;
        boolean halamanPertama = true;

        do {
            awalBarisPerHalaman.add(barisSudah);
            int yMulai = halamanPertama ? TINGGI_KOP_HALAMAN_PERTAMA : TINGGI_AWAL_HALAMAN_LANJUTAN;
            int kapasitas = (tinggiHalaman - yMulai - MARGIN_BAWAH - TINGGI_BARIS) / TINGGI_BARIS;
            if (kapasitas < 1) {
                kapasitas = 1;
            }
            barisSudah += kapasitas;
            halamanPertama = false;
        } while (barisSudah < data.length);

        int halamanTerakhirIdx = awalBarisPerHalaman.size() - 1;
        int barisAwalHalamanTerakhir = awalBarisPerHalaman.get(halamanTerakhirIdx);
        int barisDiHalamanTerakhir = data.length - barisAwalHalamanTerakhir;
        int yMulaiHalamanTerakhir = (halamanTerakhirIdx == 0)
                ? TINGGI_KOP_HALAMAN_PERTAMA : TINGGI_AWAL_HALAMAN_LANJUTAN;
        int yAkhirTabel = yMulaiHalamanTerakhir + TINGGI_BARIS + (barisDiHalamanTerakhir * TINGGI_BARIS) + 20;

        tandaTanganPisahHalaman = (tinggiHalaman - yAkhirTabel) < TINGGI_BLOK_TANDA_TANGAN;
        totalHalaman = awalBarisPerHalaman.size() + (tandaTanganPisahHalaman ? 1 : 0);
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        hitungPembagianHalaman(pf);
        if (pageIndex >= totalHalaman) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pf.getImageableX(), pf.getImageableY());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int lebarHalaman = (int) pf.getImageableWidth();
        boolean halamanBerisiTabel = pageIndex < awalBarisPerHalaman.size();
        int y;

        if (pageIndex == 0) {
            y = gambarKopSurat(g2, lebarHalaman);
        } else if (halamanBerisiTabel) {
            y = 20;
            g2.setFont(new Font("SansSerif", Font.ITALIC, 10));
            g2.setColor(Color.GRAY);
            g2.drawString("Lanjutan - " + judulLaporan, 0, y += 12);
            y += 15;
        } else {
            y = 20; // halaman khusus tanda tangan (tidak ada tabel lagi)
        }

        if (halamanBerisiTabel) {
            int barisAwal = awalBarisPerHalaman.get(pageIndex);
            int barisAkhir = (pageIndex + 1 < awalBarisPerHalaman.size())
                    ? awalBarisPerHalaman.get(pageIndex + 1) : data.length;

            g2.setColor(WARNA_HEADER_TABEL);
            g2.fillRect(0, y, lebarHalaman, TINGGI_BARIS + 2);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("SansSerif", Font.BOLD, 10));
            int x = 6;
            for (int c = 0; c < kolom.length; c++) {
                g2.drawString(kolom[c], x, y + 14);
                x += lebarKolom[c];
            }
            y += TINGGI_BARIS + 2;

            g2.setFont(new Font("SansSerif", Font.PLAIN, 9));
            for (int r = barisAwal; r < barisAkhir; r++) {
                if ((r - barisAwal) % 2 == 1) {
                    g2.setColor(WARNA_ZEBRA);
                    g2.fillRect(0, y, lebarHalaman, TINGGI_BARIS);
                }
                g2.setColor(Color.BLACK);
                x = 6;
                for (int c = 0; c < data[r].length; c++) {
                    String teks = potongTeks(g2, String.valueOf(data[r][c]), lebarKolom[c] - 10);
                    g2.drawString(teks, x, y + 14);
                    x += lebarKolom[c];
                }
                y += TINGGI_BARIS;
            }

            boolean halamanTerakhirTabel = (pageIndex == awalBarisPerHalaman.size() - 1);
            if (halamanTerakhirTabel) {
                y += 18;
                g2.setFont(new Font("SansSerif", Font.ITALIC, 9));
                g2.setColor(Color.BLACK);
                g2.drawString("Total data: " + data.length, 0, y);

                // Kalau tanda tangan masih muat, gambar langsung di sini juga
                if (!tandaTanganPisahHalaman) {
                    gambarTandaTangan(g2, lebarHalaman, y + 45);
                }
            }
        } else {
            // Halaman khusus buat tanda tangan (dipakai kalau di halaman terakhir tabel sudah penuh)
            gambarTandaTangan(g2, lebarHalaman, y + 40);
        }

        return PAGE_EXISTS;
    }

    // Menggambar logo + nama bengkel + judul laporan. Cuma dipanggil di halaman pertama.
    // Mengembalikan posisi Y terakhir supaya tabel bisa mulai digambar setelahnya.
    private int gambarKopSurat(Graphics2D g2, int lebarHalaman) {
        BufferedImage logo = muatLogo();
        int tinggiLogo = 50;
        int lebarLogo = 0;
        if (logo != null) {
            lebarLogo = (int) (tinggiLogo * ((double) logo.getWidth() / logo.getHeight()));
            g2.drawImage(logo, 0, 0, lebarLogo, tinggiLogo, null);
        }

        int xTeksKop = (lebarLogo > 0) ? lebarLogo + 15 : 0;
        g2.setFont(new Font("SansSerif", Font.BOLD, 13));
        g2.setColor(WARNA_AKSEN);
        g2.drawString(NAMA_INSTANSI, xTeksKop, 16);

        g2.setFont(new Font("SansSerif", Font.PLAIN, 9));
        g2.setColor(Color.DARK_GRAY);
        g2.drawString(ALAMAT, xTeksKop, 30);
        g2.drawString(TELEPON, xTeksKop, 42);

        int y = Math.max(tinggiLogo, 46) + 10;
        g2.setColor(Color.BLACK);
        g2.drawLine(0, y, lebarHalaman, y);
        y += 25;

        g2.setFont(new Font("SansSerif", Font.BOLD, 15));
        int lebarJudul = g2.getFontMetrics().stringWidth(judulLaporan);
        g2.drawString(judulLaporan, (lebarHalaman - lebarJudul) / 2, y += 5);
        y += 18;

        g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
        String subjudul = "Sistem Pakar Diagnosa Kerusakan Sepeda Motor 4-Tak - Forward Chaining & Certainty Factor";
        int lebarSub = g2.getFontMetrics().stringWidth(subjudul);
        g2.drawString(subjudul, (lebarHalaman - lebarSub) / 2, y += 2);
        y += 14;

        String tglCetak = "Dicetak: " + new SimpleDateFormat("dd MMMM yyyy, HH:mm").format(new Date()) + " WIB";
        int lebarTgl = g2.getFontMetrics().stringWidth(tglCetak);
        g2.drawString(tglCetak, (lebarHalaman - lebarTgl) / 2, y += 2);
        y += 20;

        return y;
    }

    // Menggambar blok tanda tangan (kota+tanggal otomatis, jabatan, dan nama pemilik
    // tebal+garis bawah), rata kanan, mulai dari posisi Y yang diberikan.
    private void gambarTandaTangan(Graphics2D g2, int lebarHalaman, int y) {
        g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
        g2.setColor(Color.BLACK);

        String tempatTanggal = KOTA_TANDA_TANGAN + ", "
                + new SimpleDateFormat("dd MMMM yyyy").format(new Date());
        int lebarTT = g2.getFontMetrics().stringWidth(tempatTanggal);
        g2.drawString(tempatTanggal, lebarHalaman - lebarTT, y);

        int lebarJabatan = g2.getFontMetrics().stringWidth(JABATAN_PEMILIK);
        g2.drawString(JABATAN_PEMILIK, lebarHalaman - lebarJabatan, y + 14);

        y += 14 + 55; // ruang kosong buat tanda tangan asli (tulis tangan)

        g2.setFont(new Font("SansSerif", Font.BOLD, 11));
        int lebarNama = g2.getFontMetrics().stringWidth(NAMA_PEMILIK);
        int xNama = lebarHalaman - lebarNama;
        g2.drawString(NAMA_PEMILIK, xNama, y);
        g2.drawLine(xNama, y + 3, xNama + lebarNama, y + 3);
    }

    private String potongTeks(Graphics2D g2, String teks, int maxLebar) {
        FontMetrics fm = g2.getFontMetrics();
        if (fm.stringWidth(teks) <= maxLebar) {
            return teks;
        }
        while (teks.length() > 3 && fm.stringWidth(teks + "...") > maxLebar) {
            teks = teks.substring(0, teks.length() - 1);
        }
        return teks + "...";
    }
}
