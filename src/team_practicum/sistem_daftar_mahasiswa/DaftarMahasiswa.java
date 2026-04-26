package team_practicum.sistem_daftar_mahasiswa;

import java.util.Scanner;

public class DaftarMahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MahasiswaLinkedList daftar = new MahasiswaLinkedList();
        
        System.out.println("=========================================");
        System.out.println("   SISTEM MANAJEMEN DATA MAHASISWA");
        System.out.println("    (Linked List berbasis Single Link)");
        System.out.println("=========================================");
        
        int pilihan;
        
        do {
            System.out.println("\n========== MENU UTAMA ==========");
            System.out.println("1. Tambah Mahasiswa Baru");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            
            switch (pilihan) {
                case 1:
                    tambahMahasiswaBaru(scanner, daftar);
                    break;
                    
                case 2:
                    hapusMahasiswa(scanner, daftar);
                    break;
                    
                case 3:
                    updateNilai(scanner, daftar);
                    break;
                    
                case 4:
                    daftar.tampilkanDaftar();
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
    
    // Menu tambah mahasiswa baru
    private static void tambahMahasiswaBaru(Scanner scanner, MahasiswaLinkedList daftar) {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Nilai (0-100): ");
        String nilaiStr = scanner.nextLine();
        
        try {
            double nilai = Double.parseDouble(nilaiStr);
            daftar.tambahMahasiswa(nim, nama, nilai);
        } catch (NumberFormatException e) {
            System.out.println("\nError: Nilai harus berupa angka!");
        }
    }

    // Menu hapus mahasiswa
    private static void hapusMahasiswa(Scanner scanner, MahasiswaLinkedList daftar) {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();
        
        daftar.hapusMahasiswa(nim);
    }
    
    // Menu update nilai mahasiswa
    private static void updateNilai(Scanner scanner, MahasiswaLinkedList daftar) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        
        Mahasiswa mahasiswa = daftar.cariByNim(nim);
        if (mahasiswa == null) {
            System.out.println("\nError: Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
            return;
        }
        
        System.out.println("Nilai saat ini: " + mahasiswa.getNilai());
        System.out.print("Masukkan nilai baru (0-100): ");
        String nilaiStr = scanner.nextLine();
        
        try {
            double nilai = Double.parseDouble(nilaiStr);
            daftar.updateNilai(nim, nilai);
        } catch (NumberFormatException e) {
            System.out.println("\nError: Nilai harus berupa angka!");
        }
    }

}

