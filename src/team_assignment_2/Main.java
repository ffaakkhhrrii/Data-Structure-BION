/**
 * FAKHRI ZAIN (2902701823)
 * RAIHAN ZAKY NOORDIANTORO (2902693802)
 * CAREN WONG (2902693222)
 * KEVIN LIONEL ANDRIANTO (2902700386)
 */
package team_assignment_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PlaylistArray playlistArray = new PlaylistArray();

        // Menu utama
        boolean running = true;
        while (running) {
            System.out.println("\nMenu Playlist Musik");
            System.out.println("1. Tampilkan Semua Lagu");
            System.out.println("2. Tambah Lagu Baru");
            System.out.println("3. Hapus Lagu Berdasarkan Judul");
            System.out.println("4. Cari Lagu Berdasarkan Judul");
            System.out.println("5. Urutkan Lagu Berdasarkan Durasi");
            System.out.println("6. Urutkan Lagu Berdasarkan Durasi (Selection Sort)");
            System.out.println("7. Keluar");
            System.out.print("Pilih (1-7): ");

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

                    System.out.print("Masukkan durasi lagu (dalam menit, contoh : 3 atau 3,4): ");
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
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi playlist musik!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih antara 1-6.");
            }
        }
        scanner.close();
    }
}
