package project_practicum_data_structure.hashtable;

import java.util.Scanner;

//Class main
public class Main{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Membuat objek sistem
        SistemMahasiswa sistem = new SistemMahasiswa();

        int pilihan;

        do {
            System.out.println("\n=== SISTEM DATA MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Cari Mahasiswa");
            System.out.println("3. Hapus Mahasiswa");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan){

                case 1:
                    //Penambahan data mahasiswa
                    System.out.print("Masukkan NIM: ");
                    String nimBaru = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan IPK: ");
                    double ipkBaru = scanner.nextDouble();
                    scanner.nextLine();

                    long startTambah = System.nanoTime();
                    sistem.tambahMahasiswa(nimBaru, namaBaru, ipkBaru);
                    long endTambah = System.nanoTime();
                    long timeTambah = endTambah - startTambah;
                    
                    System.out.println("Waktu proses: " + (timeTambah / 1_000_000.0) + " ms");
                    break;

                case 2:
                    //Pencarian data
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = scanner.nextLine();

                    long startCari = System.nanoTime();
                    sistem.cariMahasiswa(nimCari);
                    long endCari = System.nanoTime();
                    long timeCari = endCari - startCari;
                    
                    System.out.println("Waktu proses: " + (timeCari / 1_000_000.0) + " ms");
                    break;

                case 3:
                    //Penghapusan data
                    System.out.print("Masukkan NIM yang dihapus: ");
                    String nimHapus = scanner.nextLine();

                    long startHapus = System.nanoTime();
                    sistem.hapusMahasiswa(nimHapus);
                    long endHapus = System.nanoTime();
                    long timeHapus = endHapus - startHapus;
                    
                    System.out.println("Waktu proses: " + (timeHapus / 1_000_000.0) + " ms");
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);
        scanner.close();
    }
}