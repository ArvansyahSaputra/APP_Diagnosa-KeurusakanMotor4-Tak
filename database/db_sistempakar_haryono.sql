-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 26 Agu 2026 pada 07.21
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sistempakar_haryono`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE `akun` (
  `id_akun` int(11) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum('admin','user') NOT NULL DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`id_akun`, `nama_lengkap`, `username`, `password`, `role`) VALUES
(1, 'Admin Bengkel Haryono', 'admin', 'admin123', 'admin'),
(2, 'Pelanggan Contoh', 'pelanggan1', 'pelanggan123', 'user'),
(3, 'arfansyah', 'arfan', 'arfan123', 'user'),
(4, 'Arfansyah Saputra', 'Arfansyah', 'Arfan123', 'user');

-- --------------------------------------------------------

--
-- Struktur dari tabel `gejala`
--

CREATE TABLE `gejala` (
  `id_gejala` int(11) NOT NULL,
  `kode_gejala` varchar(10) NOT NULL,
  `nama_gejala` varchar(150) NOT NULL,
  `jenis_kendaraan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `gejala`
--

INSERT INTO `gejala` (`id_gejala`, `kode_gejala`, `nama_gejala`, `jenis_kendaraan`) VALUES
(1, 'G01', 'Suara kasar/berdecit pada area CVT', 'Matic'),
(2, 'G02', 'Tarikan motor terasa berat saat awal jalan', 'Matic'),
(3, 'G03', 'Getaran berlebih saat motor berakselerasi', 'Matic'),
(4, 'G04', 'Motor bergetar saat idle/langsam', 'Matic'),
(5, 'G05', 'Mesin tidak bisa menyala/hidup', 'Matic'),
(6, 'G06', 'Motor sulit dihidupkan (starter berat)', 'Matic'),
(7, 'G07', 'Bahan bakar terasa boros', 'Matic'),
(8, 'G08', 'Mesin brebet/tersendat saat digas', 'Matic'),
(9, 'G09', 'Asap knalpot berwarna putih/hitam pekat', 'Matic'),
(10, 'G10', 'Lampu indikator redup saat mesin hidup', 'Matic'),
(11, 'G11', 'Aki cepat soak/tekor meski baru diisi', 'Matic'),
(12, 'G12', 'Suara mesin kasar dari dalam blok mesin', 'Matic'),
(13, 'G13', 'Oli mesin cepat habis/rembes dari blok', 'Matic'),
(14, 'G14', 'Mesin cepat panas (overheat)', 'Matic'),
(15, 'G15', 'Motor mati mendadak saat berjalan', 'Matic'),
(16, 'G01', 'Tuas kopling terasa keras/berat', 'Manual'),
(17, 'G02', 'Perpindahan gigi terasa kasar/susah masuk', 'Manual'),
(18, 'G03', 'Motor tetap jalan meski tuas kopling ditarik penuh (kopling selip)', 'Manual'),
(19, 'G04', 'Suara berisik/berdecit dari area rantai', 'Manual'),
(20, 'G05', 'Rantai kendor/kocak berlebih', 'Manual'),
(21, 'G06', 'Mesin tidak bisa menyala/hidup', 'Manual'),
(22, 'G07', 'Motor sulit dihidupkan (starter berat)', 'Manual'),
(23, 'G08', 'Bahan bakar terasa boros', 'Manual'),
(24, 'G09', 'Mesin brebet/tersendat saat digas', 'Manual'),
(25, 'G10', 'Asap knalpot berwarna putih/hitam pekat', 'Manual'),
(26, 'G11', 'Lampu indikator redup saat mesin hidup', 'Manual'),
(27, 'G12', 'Aki cepat soak/tekor meski baru diisi', 'Manual'),
(28, 'G13', 'Suara mesin kasar dari dalam blok mesin', 'Manual'),
(29, 'G14', 'Oli mesin cepat habis/rembes dari blok', 'Manual'),
(30, 'G15', 'Mesin cepat panas (overheat)', 'Manual'),
(31, 'G16', 'Motor mati mendadak saat berjalan', 'Manual'),
(32, 'G17', 'Gir/sproket terlihat aus/tajam pada gigi-giginya', 'Manual'),
(36, 'G111', 'susah di stater', 'Matic'),
(37, 'G112', 'kopling', 'Manual');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kerusakan`
--

CREATE TABLE `kerusakan` (
  `id_kerusakan` int(11) NOT NULL,
  `kode_kerusakan` varchar(10) NOT NULL,
  `nama_kerusakan` varchar(150) NOT NULL,
  `solusi` text DEFAULT NULL,
  `jenis_kendaraan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kerusakan`
--

INSERT INTO `kerusakan` (`id_kerusakan`, `kode_kerusakan`, `nama_kerusakan`, `solusi`, `jenis_kendaraan`) VALUES
(1, 'K01', 'Kerusakan V-Belt (CVT)', 'Periksa kondisi V-Belt, ganti apabila sudah retak/aus melebihi batas pemakaian.', 'Matic'),
(2, 'K02', 'Kerusakan Roller CVT', 'Periksa dan ganti roller yang sudah aus/peyang agar tarikan awal kembali normal.', 'Matic'),
(3, 'K03', 'Kerusakan Kampas Kopling Ganda (Centrifugal Clutch)', 'Periksa kampas kopling ganda, ganti apabila sudah tipis atau selip.', 'Matic'),
(4, 'K04', 'Kerusakan Busi', 'Bersihkan atau ganti busi yang sudah lemah/mati agar pengapian normal kembali.', 'Matic'),
(5, 'K05', 'Kerusakan Karburator/Injektor', 'Bersihkan karburator/injektor dari kotoran dan periksa setelan campuran bahan bakar.', 'Matic'),
(6, 'K06', 'Kerusakan Aki (Accu)', 'Periksa tegangan aki, isi ulang atau ganti aki apabila sudah soak.', 'Matic'),
(7, 'K07', 'Kerusakan Kiprok/Spul', 'Periksa output kiprok/spul menggunakan multitester, ganti apabila rusak.', 'Matic'),
(8, 'K08', 'Kerusakan Filter Udara', 'Bersihkan atau ganti filter udara yang kotor agar campuran udara-bahan bakar optimal.', 'Matic'),
(9, 'K09', 'Kerusakan Oli Mesin/Sistem Pelumasan', 'Ganti oli mesin secara berkala dan periksa kebocoran pada blok mesin.', 'Matic'),
(10, 'K10', 'Kerusakan CDI/Sistem Pengapian', 'Periksa modul CDI dan kabel pengapian, ganti apabila percikan api lemah.', 'Matic'),
(11, 'K01', 'Kerusakan Kampas Kopling Manual', 'Periksa dan ganti kampas kopling yang sudah tipis/aus agar tenaga tersalur normal.', 'Manual'),
(12, 'K02', 'Kerusakan Rantai (kendor/aus/putus)', 'Setel ulang kekencangan rantai atau ganti rantai yang sudah aus/molor.', 'Manual'),
(13, 'K03', 'Kerusakan Gigi Transmisi/Persneling', 'Periksa mekanisme gigi transmisi, perbaiki atau ganti komponen yang aus.', 'Manual'),
(14, 'K04', 'Kerusakan Busi', 'Bersihkan atau ganti busi yang sudah lemah/mati agar pengapian normal kembali.', 'Manual'),
(15, 'K05', 'Kerusakan Karburator/Injektor', 'Bersihkan karburator/injektor dari kotoran dan periksa setelan campuran bahan bakar.', 'Manual'),
(16, 'K06', 'Kerusakan Aki (Accu)', 'Periksa tegangan aki, isi ulang atau ganti aki apabila sudah soak.', 'Manual'),
(17, 'K07', 'Kerusakan Kiprok/Spul', 'Periksa output kiprok/spul menggunakan multitester, ganti apabila rusak.', 'Manual'),
(18, 'K08', 'Kerusakan Sproket (Gir Depan/Belakang)', 'Periksa gir depan/belakang, ganti satu set bersama rantai apabila sudah aus/tajam.', 'Manual'),
(19, 'K09', 'Kerusakan Oli Mesin/Sistem Pelumasan', 'Ganti oli mesin secara berkala dan periksa kebocoran pada blok mesin.', 'Manual'),
(20, 'K10', 'Kerusakan CDI/Sistem Pengapian', 'Periksa modul CDI dan kabel pengapian, ganti apabila percikan api lemah.', 'Manual'),
(22, 'K50', 'Kerusakan Aki', 'Ganti aku', 'Matic');

-- --------------------------------------------------------

--
-- Struktur dari tabel `riwayat_diagnosa`
--

CREATE TABLE `riwayat_diagnosa` (
  `id_riwayat` int(11) NOT NULL,
  `tanggal` datetime NOT NULL,
  `id_akun` int(11) DEFAULT NULL,
  `jenis_kendaraan` varchar(10) NOT NULL,
  `gejala_dipilih` text DEFAULT NULL,
  `kode_kerusakan_hasil` varchar(10) DEFAULT NULL,
  `nama_kerusakan_hasil` varchar(150) DEFAULT NULL,
  `cf_akhir` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `riwayat_diagnosa`
--

INSERT INTO `riwayat_diagnosa` (`id_riwayat`, `tanggal`, `id_akun`, `jenis_kendaraan`, `gejala_dipilih`, `kode_kerusakan_hasil`, `nama_kerusakan_hasil`, `cf_akhir`) VALUES
(1, '2026-08-10 14:23:27', 2, 'Matic', 'G01(Ragu-Ragu); G03(Ragu-Ragu)', 'K01', 'Kerusakan V-Belt (CVT)', 0.32000000000000006),
(2, '2026-08-10 14:23:37', 2, 'Matic', 'G01(Ragu-Ragu); G03(Ragu-Ragu)', 'K01', 'Kerusakan V-Belt (CVT)', 0.32000000000000006),
(3, '2026-08-10 16:56:13', 2, 'Matic', 'G01(Kurang Yakin); G02(Ragu-Ragu); G03(Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.31120000000000003),
(4, '2026-08-10 17:00:54', 2, 'Matic', 'G01(Sangat Yakin); G02(Yakin); G03(Kurang Yakin)', 'K02', 'Kerusakan Roller CVT', 0.6000000000000001),
(5, '2026-08-10 17:02:06', 2, 'Matic', 'G01(Yakin); G02(Ragu-Ragu); G03(Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.7696000000000001),
(6, '2026-08-10 17:03:49', 2, 'Matic', 'G01(Ragu-Ragu); G02(Cukup Yakin); G03(Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.5648000000000001),
(7, '2026-08-11 13:59:14', 2, 'Manual', 'G01(Ragu-Ragu); G02(Ragu-Ragu)', 'K01', 'Kerusakan Kampas Kopling Manual', 0.30000000000000004),
(8, '2026-08-11 14:01:29', 2, 'Matic', 'G01(Yakin); G02(Yakin); G03(Ragu-Ragu)', 'K02', 'Kerusakan Roller CVT', 0.6000000000000001),
(9, '2026-08-13 18:23:55', 2, 'Matic', 'G01(Kurang Yakin); G02(Yakin); G03(Kurang Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.31120000000000003),
(10, '2026-08-13 18:34:48', 2, 'Matic', 'G01(Kurang Yakin); G02(Yakin); G03(Kurang Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.31120000000000003),
(11, '2026-08-13 19:05:35', 2, 'Matic', 'G01(Kurang Yakin); G02(Ragu-Ragu); G03(Kurang Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.31120000000000003),
(12, '2026-08-13 19:07:27', 2, 'Matic', 'G01(Cukup Yakin); G02(Ragu-Ragu); G03(Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.6672),
(13, '2026-08-13 19:13:50', 2, 'Matic', 'G01(Cukup Yakin); G02(Ragu-Ragu); G03(Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.6672),
(14, '2026-08-13 19:41:16', 2, 'Matic', 'G01(Ragu-Ragu); G02(Ragu-Ragu); G03(Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.5648000000000001),
(15, '2026-08-13 19:42:23', 2, 'Matic', 'G01(Cukup Yakin); G02(Ragu-Ragu); G03(Ragu-Ragu)', 'K01', 'Kerusakan V-Belt (CVT)', 0.5648000000000001),
(16, '2026-08-13 19:44:39', 2, 'Matic', 'G01(Cukup Yakin); G02(Kurang Yakin); G03(Cukup Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.5736),
(17, '2026-08-13 19:46:15', 3, 'Matic', 'G01(Cukup Yakin); G02(Yakin); G03(Ragu-Ragu)', 'K01', 'Kerusakan V-Belt (CVT)', 0.5648000000000001),
(18, '2026-08-13 20:20:11', 2, 'Matic', 'G01(Kurang Yakin); G02(Cukup Yakin); G03(Ragu-Ragu)', 'K01', 'Kerusakan V-Belt (CVT)', 0.31120000000000003),
(19, '2026-08-14 11:05:27', 3, 'Manual', 'G01(Cukup Yakin); G02(Kurang Yakin)', 'K01', 'Kerusakan Kampas Kopling Manual', 0.15000000000000002),
(20, '2026-08-14 11:17:12', 4, 'Matic', 'G01(Cukup Yakin); G02(Yakin); G03(Sangat Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.7608),
(21, '2026-08-16 13:22:10', 4, 'Matic', 'G01(Sangat Yakin); G02(Cukup Yakin)', 'K02', 'Kerusakan Roller CVT', 0.44999999999999996),
(22, '2026-08-16 13:22:48', 4, 'Matic', 'G01(Ragu-Ragu); G03(Kurang Yakin); G04(Yakin)', 'K02', 'Kerusakan Roller CVT', 0.17),
(23, '2026-08-16 13:23:32', 4, 'Matic', 'G07(Yakin); G08(Yakin); G09(Yakin)', 'K05', 'Kerusakan Karburator/Injektor', 0.8720000000000001),
(24, '2026-08-16 13:24:36', 4, 'Matic', 'G10(Sangat Yakin); G11(Yakin); G15(Sangat Yakin)', 'K06', 'Kerusakan Aki (Accu)', 0.9104000000000001),
(25, '2026-08-16 13:25:29', 4, 'Manual', 'G02(Sangat Yakin); G03(Sangat Yakin); G09(Ragu-Ragu)', 'K01', 'Kerusakan Kampas Kopling Manual', 0.85),
(26, '2026-08-16 13:26:05', 4, 'Manual', 'G10(Ragu-Ragu); G13(Cukup Yakin); G15(Sangat Yakin)', 'K09', 'Kerusakan Oli Mesin/Sistem Pelumasan', 0.34),
(27, '2026-08-16 13:26:38', 4, 'Manual', 'G13(Ragu-Ragu); G14(Yakin); G15(Sangat Yakin)', 'K09', 'Kerusakan Oli Mesin/Sistem Pelumasan', 0.36000000000000004),
(28, '2026-08-16 13:27:05', 4, 'Manual', 'G06(Sangat Yakin); G07(Sangat Yakin); G10(Ragu-Ragu)', 'K04', 'Kerusakan Busi', 0.85),
(29, '2026-08-16 13:27:51', 4, 'Manual', 'G04(Kurang Yakin); G05(Yakin); G17(Sangat Yakin)', 'K02', 'Kerusakan Rantai (kendor/aus/putus)', 0.31120000000000003),
(30, '2026-08-16 13:28:04', 4, 'Manual', 'G04(Kurang Yakin); G05(Yakin); G17(Sangat Yakin)', 'K02', 'Kerusakan Rantai (kendor/aus/putus)', 0.31120000000000003),
(31, '2026-08-18 10:29:11', 4, 'Matic', 'G01(Yakin); G03(Cukup Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.48),
(32, '2026-08-20 15:42:00', 4, 'Matic', 'G01(Ragu-Ragu); G02(Sangat Yakin); G03(Sangat Yakin)', 'K01', 'Kerusakan V-Belt (CVT)', 0.5648000000000001);

-- --------------------------------------------------------

--
-- Struktur dari tabel `rule`
--

CREATE TABLE `rule` (
  `id_rule` int(11) NOT NULL,
  `kode_rule` varchar(10) NOT NULL,
  `kode_kerusakan` varchar(10) NOT NULL,
  `cf_pakar` double NOT NULL,
  `jenis_kendaraan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rule`
--

INSERT INTO `rule` (`id_rule`, `kode_rule`, `kode_kerusakan`, `cf_pakar`, `jenis_kendaraan`) VALUES
(1, 'R01', 'K01', 0.8, 'Matic'),
(2, 'R02', 'K02', 0.75, 'Matic'),
(3, 'R03', 'K03', 0.7, 'Matic'),
(4, 'R04', 'K04', 0.85, 'Matic'),
(5, 'R05', 'K05', 0.75, 'Matic'),
(6, 'R06', 'K06', 0.85, 'Matic'),
(7, 'R07', 'K07', 0.7, 'Matic'),
(8, 'R08', 'K08', 0.65, 'Matic'),
(9, 'R09', 'K01', 0.9, 'Matic'),
(10, 'R10', 'K02', 0.85, 'Matic'),
(11, 'R11', 'K03', 0.8, 'Matic'),
(12, 'R12', 'K10', 0.8, 'Matic'),
(13, 'R13', 'K05', 0.85, 'Matic'),
(14, 'R14', 'K09', 0.85, 'Matic'),
(15, 'R15', 'K06', 0.9, 'Matic'),
(16, 'R16', 'K09', 0.9, 'Matic'),
(17, 'R01', 'K01', 0.75, 'Manual'),
(18, 'R02', 'K01', 0.85, 'Manual'),
(19, 'R03', 'K02', 0.8, 'Manual'),
(20, 'R04', 'K08', 0.75, 'Manual'),
(21, 'R05', 'K04', 0.85, 'Manual'),
(22, 'R06', 'K05', 0.75, 'Manual'),
(23, 'R07', 'K06', 0.85, 'Manual'),
(24, 'R08', 'K07', 0.7, 'Manual'),
(25, 'R09', 'K01', 0.9, 'Manual'),
(26, 'R10', 'K03', 0.8, 'Manual'),
(27, 'R11', 'K02', 0.9, 'Manual'),
(28, 'R12', 'K10', 0.8, 'Manual'),
(29, 'R13', 'K05', 0.85, 'Manual'),
(30, 'R14', 'K09', 0.85, 'Manual'),
(31, 'R15', 'K06', 0.9, 'Manual'),
(32, 'R16', 'K09', 0.9, 'Manual'),
(34, 'R19', 'K50', 0.8, 'Matic');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rule_gejala`
--

CREATE TABLE `rule_gejala` (
  `id_rule_gejala` int(11) NOT NULL,
  `id_rule` int(11) NOT NULL,
  `id_gejala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rule_gejala`
--

INSERT INTO `rule_gejala` (`id_rule_gejala`, `id_rule`, `id_gejala`) VALUES
(1, 1, 1),
(2, 1, 3),
(3, 2, 1),
(4, 2, 2),
(5, 3, 2),
(6, 3, 4),
(7, 4, 5),
(8, 4, 6),
(9, 5, 7),
(10, 5, 8),
(11, 6, 10),
(12, 6, 11),
(13, 7, 10),
(14, 7, 15),
(15, 8, 7),
(16, 8, 9),
(17, 9, 1),
(18, 9, 2),
(19, 9, 3),
(20, 10, 1),
(21, 10, 3),
(22, 10, 4),
(23, 11, 2),
(24, 11, 3),
(25, 11, 4),
(26, 12, 5),
(27, 12, 6),
(28, 12, 9),
(29, 13, 7),
(30, 13, 8),
(31, 13, 9),
(32, 14, 9),
(33, 14, 12),
(34, 14, 14),
(35, 15, 10),
(36, 15, 11),
(37, 15, 15),
(38, 16, 12),
(39, 16, 13),
(40, 16, 14),
(41, 17, 16),
(42, 17, 17),
(43, 18, 17),
(44, 18, 18),
(45, 19, 19),
(46, 19, 20),
(47, 20, 19),
(48, 20, 32),
(49, 21, 21),
(50, 21, 22),
(51, 22, 23),
(52, 22, 24),
(53, 23, 26),
(54, 23, 27),
(55, 24, 26),
(56, 24, 31),
(57, 25, 16),
(58, 25, 17),
(59, 25, 18),
(60, 26, 17),
(61, 26, 18),
(62, 26, 24),
(63, 27, 19),
(64, 27, 20),
(65, 27, 32),
(66, 28, 21),
(67, 28, 22),
(68, 28, 25),
(69, 29, 23),
(70, 29, 24),
(71, 29, 25),
(72, 30, 25),
(73, 30, 28),
(74, 30, 30),
(75, 31, 26),
(76, 31, 27),
(77, 31, 31),
(78, 32, 28),
(79, 32, 29),
(80, 32, 30),
(87, 34, 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id_akun`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `gejala`
--
ALTER TABLE `gejala`
  ADD PRIMARY KEY (`id_gejala`);

--
-- Indeks untuk tabel `kerusakan`
--
ALTER TABLE `kerusakan`
  ADD PRIMARY KEY (`id_kerusakan`);

--
-- Indeks untuk tabel `riwayat_diagnosa`
--
ALTER TABLE `riwayat_diagnosa`
  ADD PRIMARY KEY (`id_riwayat`),
  ADD KEY `id_akun` (`id_akun`);

--
-- Indeks untuk tabel `rule`
--
ALTER TABLE `rule`
  ADD PRIMARY KEY (`id_rule`);

--
-- Indeks untuk tabel `rule_gejala`
--
ALTER TABLE `rule_gejala`
  ADD PRIMARY KEY (`id_rule_gejala`),
  ADD KEY `id_rule` (`id_rule`),
  ADD KEY `id_gejala` (`id_gejala`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `akun`
--
ALTER TABLE `akun`
  MODIFY `id_akun` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `gejala`
--
ALTER TABLE `gejala`
  MODIFY `id_gejala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT untuk tabel `kerusakan`
--
ALTER TABLE `kerusakan`
  MODIFY `id_kerusakan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT untuk tabel `riwayat_diagnosa`
--
ALTER TABLE `riwayat_diagnosa`
  MODIFY `id_riwayat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT untuk tabel `rule`
--
ALTER TABLE `rule`
  MODIFY `id_rule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT untuk tabel `rule_gejala`
--
ALTER TABLE `rule_gejala`
  MODIFY `id_rule_gejala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `riwayat_diagnosa`
--
ALTER TABLE `riwayat_diagnosa`
  ADD CONSTRAINT `riwayat_diagnosa_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`) ON DELETE SET NULL;

--
-- Ketidakleluasaan untuk tabel `rule_gejala`
--
ALTER TABLE `rule_gejala`
  ADD CONSTRAINT `rule_gejala_ibfk_1` FOREIGN KEY (`id_rule`) REFERENCES `rule` (`id_rule`) ON DELETE CASCADE,
  ADD CONSTRAINT `rule_gejala_ibfk_2` FOREIGN KEY (`id_gejala`) REFERENCES `gejala` (`id_gejala`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
