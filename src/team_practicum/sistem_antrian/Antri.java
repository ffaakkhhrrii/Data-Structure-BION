package team_practicum.sistem_antrian;

import java.util.Scanner;

//MAIN
public class Antri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrean = new Queue();
        
        System.out.println("=========================================");
        System.out.println("   SISTEM MANAJEMEN ANTREAN CUSTOMER");
        System.out.println("         (Queue berbasis Linked List)");
        System.out.println("=========================================");
        
        int pilihan;
        
        do {
            System.out.println("\n========== MENU UTAMA ==========");
            System.out.println("1. Tambah Pelanggan Baru");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Daftar Antrean");
            System.out.println("4. Lihat Pelanggan Berikutnya");
            System.out.println("5. Total Antrean Saat Ini");
            System.out.println("0. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            
            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    if (nama.trim().isEmpty()) {
                        System.out.println("Nama tidak boleh kosong!");
                    } else {
                        antrean.enqueue(nama);
                    }
                    break;
                    
                case 2:
                    antrean.dequeue();
                    break;
                    
                case 3:
                    antrean.display();
                    break;
                    
                case 4:
                    antrean.peek();
                    break;
                    
                case 5:
                    System.out.println("\nTotal pelanggan dalam antrean: " + 
                                     antrean.getJumlahPelanggan());
                    break;
                    
                case 0:
                    System.out.println("\nTerima kasih telah menggunakan sistem ini!");
                    break;
                    
                default:
                    System.out.println("\nPilihan tidak valid! Silakan coba lagi.");
            }
            
        } while (pilihan != 0);
        
        scanner.close();
    }
}