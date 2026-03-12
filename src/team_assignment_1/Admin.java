package team_assignment_1;

import java.util.ArrayList;

public class Admin extends User {

    // Atribut Admin
    private ArrayList<Lagu> playlist;  // Reference ke ArrayList playlist
    
    // Constructor
    public Admin(String username, String email, ArrayList<Lagu> playlist) {
        super(username, email);
        this.playlist = playlist;
    }
    
    // Method untuk menambahkan lagu
    public boolean tambahLagu(Lagu lagu) {
        return playlist.add(lagu);
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

    
    // Menampilkan hak akses dari user Admin
    @Override
    public void tampilkanAkses() {
        System.out.println("\n=== INFORMASI ADMIN ===");
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Role: ADMIN (Pengelola Playlist)");
        System.out.println("Akses: Dapat menambahkan lagu, melihat semua lagu, dan mengelola playlist");
    }
}

