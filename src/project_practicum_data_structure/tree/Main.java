package project_practicum_data_structure.tree;

import java.util.Scanner;

// Main Class (CLI)
public class Main {
    public static void main(String[] args) {
        BinarySearchTree sistemMhs = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n=== Sistem Manajemen Mahasiswa ===");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data (In-Order)");
            System.out.println("3. Tampilkan Data (Pre-Order)");
            System.out.println("4. Tampilkan Data (Post-Order)");
            System.out.println("5. Cari Data Mahasiswa");
            System.out.println("6. Hapus Data Mahasiswa");
            System.out.println("7. Keluar");
            System.out.print("Pilih Menu [1-7]: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM  : ");
                    int nim = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama : ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan IPK  : ");
                    double ipk = scanner.nextDouble();
                    scanner.nextLine();
                    
                    long startInsert = System.nanoTime();
                    sistemMhs.insert(nim, nama, ipk);
                    long endInsert = System.nanoTime();
                    long timeInsert = endInsert - startInsert;
                    
                    System.out.println("Data berhasil disimpan ke dalam sistem.");
                    System.out.println("Waktu proses: " + (timeInsert / 1_000_000.0) + " ms");
                    break;

                case 2:
                    System.out.print("Hasil In-Order (Urut NIM): ");
                    long startInOrder = System.nanoTime();
                    sistemMhs.inOrder();
                    long endInOrder = System.nanoTime();
                    long timeInOrder = endInOrder - startInOrder;
                    
                    System.out.println("Waktu proses: " + (timeInOrder / 1_000_000.0) + " ms");
                    break;

                case 3:
                    System.out.print("Hasil Pre-Order          : ");
                    long startPreOrder = System.nanoTime();
                    sistemMhs.preOrder();
                    long endPreOrder = System.nanoTime();
                    long timePreOrder = endPreOrder - startPreOrder;
                    
                    System.out.println("Waktu proses: " + (timePreOrder / 1_000_000.0) + " ms");
                    break;

                case 4:
                    System.out.print("Hasil Post-Order         : ");
                    long startPostOrder = System.nanoTime();
                    sistemMhs.postOrder();
                    long endPostOrder = System.nanoTime();
                    long timePostOrder = endPostOrder - startPostOrder;
                    
                    System.out.println("Waktu proses: " + (timePostOrder / 1_000_000.0) + " ms");
                    break;

                case 5:
                    System.out.print("Masukkan NIM yang dicari : ");
                    int nimCari = scanner.nextInt();
                    scanner.nextLine();
                    
                    long startSearch = System.nanoTime();
                    Node hasilCari = sistemMhs.search(nimCari);
                    long endSearch = System.nanoTime();
                    long timeSearch = endSearch - startSearch;
                    
                    if (hasilCari != null) {
                        System.out.println("Data ditemukan!");
                        System.out.println("NIM  : " + hasilCari.nim);
                        System.out.println("Nama : " + hasilCari.nama);
                        System.out.println("IPK  : " + hasilCari.ipk);
                    } else {
                        System.out.println("Data dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    System.out.println("Waktu proses: " + (timeSearch / 1_000_000.0) + " ms");
                    break;

                case 6:
                    System.out.print("Masukkan NIM yang akan dihapus : ");
                    int nimHapus = scanner.nextInt();
                    scanner.nextLine();
                    
                    long startDelete = System.nanoTime();
                    sistemMhs.delete(nimHapus);
                    long endDelete = System.nanoTime();
                    long timeDelete = endDelete - startDelete;
                    
                    System.out.println("Data dengan NIM " + nimHapus + " berhasil dihapus dari sistem.");
                    System.out.println("Waktu proses: " + (timeDelete / 1_000_000.0) + " ms");
                    break;

                case 7:
                    berjalan = false;
                    System.out.println("Sistem ditutup. Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan masukkan angka 1 sampai 7.");
                    break;
            }
        }
        scanner.close();
    }
}