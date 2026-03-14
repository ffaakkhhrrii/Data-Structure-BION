package team_assignment_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat daftar lagu menggunakan ArrayList
        ArrayList<Lagu> daftarLagu = new ArrayList<>();
        
        // Inisialisasi daftar lagu
        daftarLagu.add(new Lagu("Shape of You", "Ed Sheeran", 4.24));
        daftarLagu.add(new Lagu("Blinding Lights", "The Weeknd", 3.20));
        daftarLagu.add(new Lagu("Levitating", "Dua Lipa", 3.23));

        // Membuat instance Admin dan Member
        Admin admin = new Admin("admin1", "admin@gmail.com", "1234", "admin", daftarLagu);
        Member member = new Member("member1", "member@gmail.com", "member", "1234", daftarLagu);

        // Menu utama
        boolean running = true;
        while (running) {
            System.out.println("Sistem Manajemen Playlist");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Member");
            System.out.println("3. Keluar");
            System.out.print("Pilih (1-3): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline
            
            switch (pilihan) {
                case 1:
                    menuAdmin(admin, scanner);
                    break;
                case 2:
                    menuMember(member, scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("\nTerima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silahkan coba lagi.");
            }
        }
        
        scanner.close();
    }
    
    // Method untuk menu Admin
    public static void menuAdmin(Admin admin, Scanner scanner) {
        admin.tampilkanAkses();

        // Disini saya menggunakan variable variable inAdminMenu untuk mengontrol loop menu admin, sehingga ketika user memilih untuk kembali ke menu utama, loop akan berhenti dan kembali ke menu utama.
        boolean inAdminMenu = true;
        while (inAdminMenu) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Tambahkan Lagu Baru");
            System.out.println("2. Lihat Semua Lagu");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih (1-3): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    // Menambahkan lagu baru
                    System.out.print("Masukkan judul lagu: ");
                    String judul = scanner.nextLine();
                    
                    System.out.print("Masukkan nama artis: ");
                    String artis = scanner.nextLine();
                    
                    System.out.print("Masukkan durasi lagu (dalam menit): ");
                    double durasi = scanner.nextDouble();
                    scanner.nextLine();
                    
                    Lagu lagubaru = new Lagu(judul, artis, durasi);
                    
                    if (admin.tambahLagu(lagubaru)) {
                        System.out.println("Lagu '" + judul + "' berhasil ditambahkan!");
                    } else {
                        System.out.println("Gagal menambahkan lagu!");
                    }
                    break;
                case 2:
                    // Menampilkan semua lagu
                    admin.tampilkanSemuaLagu();
                    break;
                    
                case 3:
                    // Kembali ke menu utama
                    inAdminMenu = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    // Method untuk menu Member
    public static void menuMember(Member member, Scanner scanner) {
        member.tampilkanAkses();

        // Disini saya menggunakan variable variable inMemberMenu untuk mengontrol loop menu member, sehingga ketika user memilih untuk kembali ke menu utama, loop akan berhenti dan kembali ke menu utama.
        boolean inMemberMenu = true;
        while (inMemberMenu) {
            System.out.println("\n--- Menu Member ---");
            System.out.println("1. Lihat Daftar Lagu");
            System.out.println("2. Cari Lagu Berdasarkan Judul");
            System.out.println("3. Lihat Detail Lagu Tertentu");
            System.out.println("4. Lihat Statistik Playlist");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    // Melihat daftar semua lagu
                    member.tampilkanSemuaLagu();
                    break;
                    
                case 2:
                    // Mencari lagu berdasarkan judul
                    // NOTE : pencarian harus mengetik full nama lagu tanpa mengkhawatirkan kapital
                    System.out.print("Masukkan judul lagu yang dicari: ");
                    String judulCari = scanner.nextLine();
                    member.cariLagu(judulCari);
                    break;
                    
                case 3:
                    // Menampilkan daftar lagu saat ini untuk dipilih
                    System.out.println("Daftar lagu saat ini");
                    member.tampilkanSemuaLagu();
                    // Melihat detail lagu tertentu
                    System.out.print("Masukkan nomor lagu (1 - n): ");
                    int nomorLagu = scanner.nextInt();
                    scanner.nextLine();
                    member.lihatDetailLagu(nomorLagu);
                    break;
                    
                case 4:
                    // Melihat statistik playlist
                    member.hitungRataRataDurasi();
                    break;
                    
                case 5:
                    // Kembali ke menu utama
                    inMemberMenu = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
