package personal_assignment_1_data_structure;


import java.util.Scanner;


public class EduTech {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Object scanner untuk membaca input dari pengguna

        Mahasiswa[] listMahasiswa = new Mahasiswa[5]; // Array untuk menyimpan data mahasiswa

        for(int i = 0; i < listMahasiswa.length; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = scanner.nextLine(); // Membaca nama mahasiswa
            System.out.print("Nim: ");
            String nim = scanner.nextLine(); // Membaca nim mahasiswa
            System.out.print("Jurusan: ");
            String jurusan = scanner.nextLine(); // Membaca jurusan mahasiswa
            System.out.print("IPK: ");
            double ipk = scanner.nextDouble(); // Membaca IPK mahasiswa
            scanner.nextLine(); // Membersihkan buffer setelah membaca angka

            listMahasiswa[i] = new Mahasiswa(nama, nim, jurusan, ipk); // Menyimpan data mahasiswa ke dalam array
        }

        for(Mahasiswa mahasiswa : listMahasiswa) {
            System.out.println("\n==========");
            System.out.println("Informasi Mahasiswa");
            mahasiswa.tampilkanInfo(); // Menampilkan informasi setiap mahasiswa
            System.out.println("==========");
        }

        boolean found = false; // variable untuk menentukan apakah nim ditemukan atau tidak
        System.out.println("\nMasukkan NIM mahasiswa yang ingin diupdate: ");
        String nimToUpdate = scanner.nextLine(); // Membaca NIM mahasiswa yang ingin diperbarui IPK-nya
        for(Mahasiswa mahasiswa : listMahasiswa) {
            if(mahasiswa.getNim().equals(nimToUpdate)) { // Mencari mahasiswa dengan NIM yang sesuai
                System.out.print("Masukkan IPK baru: ");
                double newIpk = scanner.nextDouble(); // Membaca IPK baru
                mahasiswa.updateIpk(newIpk); // Memperbarui IPK mahasiswa
                System.out.println("Data berhasil diperbarui.");

                System.out.println("\n==========");
                System.out.println("Informasi Mahasiswa");
                mahasiswa.tampilkanInfo(); // Menampilkan informasi mahasiswa setelah diperbarui IPK-nya
                System.out.println("==========");

                found = true; // Data ditemukan

                break; // Keluar dari loop setelah memperbarui IPK
            }
        }

        if(!found) {
            System.out.println("Mahasiswa dengan NIM " + nimToUpdate + " tidak ditemukan.");
        }

    }
}