# Aplikasi Diagnosa Kerusakan Motor 4 Tak

Aplikasi sistem pakar untuk mendiagnosa kerusakan sepeda motor 4 tak berdasarkan gejala yang dialami pelanggan, menggunakan metode **Forward Chaining** dan **Certainty Factor**.

## Fitur

### Halaman Admin / Mekanik
- Login dan logout
- Kelola **Data Gejala** (CRUD)
- Kelola **Data Kerusakan** (CRUD)
- Kelola **Rule Base** dan **CF Pakar** (CRUD)
- Kelola **Riwayat Diagnosa** pelanggan (CRUD)
- **Laporan** dari seluruh data di atas

### Halaman User / Pelanggan
- Registrasi akun (wajib bagi pelanggan yang belum punya akun)
- Login dan logout
- Input gejala yang dialami beserta tingkat keyakinan
- Hasil diagnosa lengkap dengan persentase keyakinan
- Melihat riwayat diagnosa milik sendiri
- Cetak hasil diagnosa ke **PDF**

## Teknologi
- Java (NetBeans 8.2)
- MySQL (XAMPP)
- Metode: Forward Chaining dan Certainty Factor

## Cara Menjalankan
1. Install JDK, NetBeans 8.2, dan XAMPP.
2. Jalankan **Apache** dan **MySQL** di XAMPP.
3. Buka phpMyAdmin, buat database baru, lalu import file `.sql` dari project ini.
4. Clone repo:
5. Buka NetBeans → **File** → **Open Project**, pilih folder hasil clone.
6. Sesuaikan koneksi database (nama database, user, password) di class koneksi bila perlu.
7. Klik **Run Project** (F6).

## Struktur Folder
- `src/` : source code aplikasi
- `test/` : file pengujian
- `nbproject/` : konfigurasi project NetBeans

## Author
link demo : https://youtu.be/aDpgGemTEx0?si=sdqcGzZPbo4UUQAh
Arfansyah Saputra
