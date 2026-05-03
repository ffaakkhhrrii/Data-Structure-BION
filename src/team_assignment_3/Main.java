package team_assignment_3;

/**
 * FAKHRI ZAIN (2902701823)
 * RAIHAN ZAKY NOORDIANTORO (2902693802)
 * CAREN WONG (2902693222)
 * KEVIN LIONEL ANDRIANTO (2902700386)
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PlaylistArray playlistArray = new PlaylistArray();

        // Menu utama
        boolean running = true;
        while (running) {
            System.out.println("\n║ MENU PLAYLIST MUSIK                       ║");
            System.out.println("║  1.  Tampilkan Semua Lagu                 ║");
            System.out.println("║  2.  Tambah Lagu Baru                     ║");
            System.out.println("║  3.  Hapus Lagu Berdasarkan Judul         ║");
            System.out.println("║  4.  Cari Lagu Berdasarkan Judul          ║");
            System.out.println("║  5.  Urutkan Lagu Berdasarkan Durasi      ║");
            System.out.println("║  6.  Urutkan Lagu Berdasarkan Durasi      ║");
            System.out.println("║  7.  Hitung Total Durasi                  ║");
            System.out.println("║  8.  Tampilkan Lagu Terbalik              ║");
            System.out.println("║  9.  Cari Durasi Terpanjang               ║");
            System.out.println("║  10. Keluar                               ║");
            System.out.print("Pilih (1-10): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    playlistArray.tampilkanSemuaLagu();
                    break;
                    
                case 2:
                    System.out.print("Masukkan judul lagu: ");
                    String judul = scanner.nextLine();

                    System.out.print("Masukkan nama artis: ");
                    String artis = scanner.nextLine();

                    System.out.print("Masukkan durasi lagu (dalam menit, contoh : 3 atau 3.5): ");
                    double durasi = scanner.nextDouble();
                    scanner.nextLine();

                    Lagu lagubaru = new Lagu(judul, artis, durasi);
                    playlistArray.tambahLagu(lagubaru);
                    break;
                    
                case 3:
                    System.out.print("Masukkan judul lagu yang ingin dihapus: ");
                    String removeJudul = scanner.nextLine();
                    playlistArray.hapusLagu(removeJudul);
                    break;
                    
                case 4:
                    System.out.print("Masukkan judul lagu yang ingin dicari: ");
                    String searchJudul = scanner.nextLine();
                    playlistArray.cariLagu(searchJudul);
                    break;
                    
                case 5:
                    playlistArray.urutkanLaguBerdasarkanDurasi();
                    break;
                    
                case 6:
                    playlistArray.urutkanLaguBerdasarkanDurasiSelection();
                    break;
                    
                case 7:
                    // FUNGSI REKURSIF: Total Durasi
                    hitungTotalDurasiRekursif(playlistArray);
                    break;
                    
                case 8:
                    // FUNGSI REKURSIF: Tampilkan Mundur
                    tampilkanLaguTerbalikRekursif(playlistArray);
                    break;
                    
                case 9:
                    // FUNGSI REKURSIF: Cari Durasi Terpanjang
                    cariDurasiTerpanjangRekursif(playlistArray);
                    break;
                    
                case 10:
                    running = false;
                    System.out.println("\nTerima kasih telah menggunakan aplikasi playlist musik!");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih antara 1-10.");
            }
        }
        scanner.close();
    }
    
    // FUNGSI REKURSIF TOTAL DURASI
    public static void hitungTotalDurasiRekursif(PlaylistArray playlistArray) {
        Lagu[] daftar = playlistArray.getPlaylist();
        int n = playlistArray.getJumlahLagu();
        
        if (n == 0) {
            System.out.println("\nPlaylist kosong! Tidak ada lagu.");
            return;
        }
        
        // Pengukuran waktu eksekusi
        long startTime = System.nanoTime();
        double total = PlaylistArray.totalDurasi(daftar, n);
        long endTime = System.nanoTime();
        double waktuMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.println("\nHASIL REKURSIF:");
        System.out.println("Total Durasi Lagu = " + String.format("%.2f", total) + " menit");
        System.out.println("Waktu eksekusi: " + String.format("%.4f", waktuMs) + " ms");
    }
    
    // FUNGSI REKURSIF TAMPILKAN LAGU TERBALIK
    public static void tampilkanLaguTerbalikRekursif(PlaylistArray playlistArray) {
        Lagu[] daftar = playlistArray.getPlaylist();
        int n = playlistArray.getJumlahLagu();
        
        if (n == 0) {
            System.out.println("\nPlaylist kosong! Tidak ada lagu.");
            return;
        }
        
        System.out.println("\n DAFTAR LAGU (TERBALIK):");
        
        // Pengukuran waktu eksekusi
        long startTime = System.nanoTime();
        PlaylistArray.tampilkanMundur(daftar, n - 1);
        long endTime = System.nanoTime();
        double waktuMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.println("Waktu eksekusi: " + String.format("%.4f", waktuMs) + " ms");
    }
    
    // FUNGSI REKURSIF CARI DURASI TERPANJANG
    public static void cariDurasiTerpanjangRekursif(PlaylistArray playlistArray) {
        Lagu[] daftar = playlistArray.getPlaylist();
        int n = playlistArray.getJumlahLagu();
        
        if (n == 0) {
            System.out.println("\nPlaylist kosong! Tidak ada lagu.");
            return;
        }
        
        // Pengukuran waktu eksekusi
        long startTime = System.nanoTime();
        double durasiTerpanjang = PlaylistArray.cariDurasiTerpanjang(daftar, n - 1);
        String judulTerpanjang = PlaylistArray.cariJudulTerpanjang(daftar, n - 1, n - 1);
        String artisTerpanjang = PlaylistArray.cariArtisTerpanjang(daftar, n - 1, n - 1);
        long endTime = System.nanoTime();
        double waktuMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.println("\nHASIL REKURSIF:");
        System.out.println("Lagu Terpanjang: " + judulTerpanjang + " - " + artisTerpanjang + " (" + String.format("%.2f", durasiTerpanjang) + " menit)");
        System.out.println("Waktu eksekusi: " + String.format("%.4f", waktuMs) + " ms");
    }
}