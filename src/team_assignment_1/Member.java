package team_assignment_1;

import java.util.ArrayList;

public class Member extends User {
    
    // Atribut Member
    private ArrayList<Lagu> playlist; // Reference ke ArrayList playlist dari Main
    
    // Constructor
    public Member(String username, String email, String role, String password, ArrayList<Lagu> playlist) {
        super(username, email, role, password);
        this.playlist = playlist;
    }

    // Method untuk menampilkan lagu
    public void tampilkanSemuaLagu() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist kosong!");
            return;
        }

        System.out.println("\n=== DAFTAR SEMUA LAGU DALAM PLAYLIST ===");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println("\n[Lagu ke-" + (i + 1) + "]");
            playlist.get(i).tampilkanInfo();
        }
    }
    
    // Method untuk mencari lagu berdasarkan judul
    public boolean cariLagu(String judul) {
        for (Lagu lagu : playlist) {
            if (lagu.getJudul().equalsIgnoreCase(judul)) {
                System.out.println("\n=== LAGU DITEMUKAN ===");
                lagu.tampilkanInfo();
                return true;
            }
        }
        
        System.out.println("Lagu dengan judul '" + judul + "' tidak ditemukan!");
        return false;
    }
    

    // Method untuk melihat detail lagu
    public void lihatDetailLagu(int nomor) {
        if (nomor < 1 || nomor > playlist.size()) {
            System.out.println("Nomor lagu tidak valid!");
            return;
        }
        
        System.out.println("\n=== DETAIL LAGU ===");

        // Nomor dikurang 1 karena dalam index array dimulai dari angka 0
        playlist.get(nomor - 1).tampilkanInfo();
    }
    

    // Method untuk menghitung rata rata durasi
    public double hitungRataRataDurasi() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist kosong! Tidak dapat menghitung rata-rata.");
            return 0;
        }
        
        double totalDurasi = 0;
        
        // Menjumlahkan semua durasi lagu
        for (Lagu lagu : playlist) {
            totalDurasi += lagu.getDurasi();
        }
        
        // Menghitung rata-rata
        double rataRata = totalDurasi / playlist.size();
        
        System.out.println("\n=== STATISTIK PLAYLIST ===");
        System.out.println("Total Lagu: " + playlist.size());
        System.out.println("Total Durasi: " + totalDurasi + " menit");
        System.out.println("Rata-rata Durasi: " + String.format("%.2f", rataRata) + " menit");
        
        return rataRata;
    }

    // Menampilkan hak akses dari user Member
    @Override
    public void tampilkanAkses() {
        System.out.println("\n=== INFORMASI MEMBER ===");
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Role: MEMBER (Pengguna Playlist)");
        System.out.println("Akses: Dapat melihat daftar lagu, mencari lagu, dan melihat statistik playlist");
    }
}


