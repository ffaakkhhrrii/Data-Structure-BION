package team_assignment_2;

public class PlaylistArray {
    private Lagu[] playlist = new Lagu[10]; // Array untuk menyimpan lagu dengan kapasitas maksimal 10

    void tampilkanSemuaLagu() { // Traversal
        System.out.println("\n== Daftar Lagu Saat Ini ==");

        // Memeriksa apakah playlist kosong
        boolean adaLagu = false;
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                adaLagu = true;
                System.out.println((i + 1) + ". " + playlist[i].getJudul() + " - " + playlist[i].getArtis() + " (" + playlist[i].getDurasi() + " menit)");
            }
        }

        // Jika tidak ada lagu, tampilkan pesan kosong
        if (!adaLagu) {
            System.out.println("Playlist kosong. Belum ada lagu yang ditambahkan.");
        }
    }

    void tambahLagu(Lagu lagu) { // Insertion
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] == null) {
                playlist[i] = lagu; // Menambahkan lagu ke posisi pertama yang kosong
                System.out.println("Lagu '" + lagu.getJudul() + "' berhasil ditambahkan ke playlist.");
                tampilkanSemuaLagu();
                return;
            }
        }
        // Jika looping selesai dan tidak ada posisi kosong, playlist penuh
        System.out.println("Playlist penuh! Tidak dapat menambahkan lagu baru (Maksimal 10 lagu).");
    }

    void hapusLagu(String judulLagu) { // Deletion
            int posisiLagu = -1;
        
        // Mencari posisi lagu yang akan dihapus (Linear Search)
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null && playlist[i].getJudul().equalsIgnoreCase(judulLagu)) {
                posisiLagu = i;
                break;
            }
        }
        
        // Jika lagu ditemukan, lakukan penghapusan dengan shifting
        if (posisiLagu != -1) {
            System.out.println("Lagu '" + playlist[posisiLagu].getJudul() + "' berhasil dihapus dari playlist.");
            
            // Geser elemen-elemen setelah posisi penghapusan ke kiri agar data tetap rapat
            for (int i = posisiLagu; i < playlist.length - 1; i++) {
                playlist[i] = playlist[i + 1];
            }
            
            // Set posisi terakhir ke null
            playlist[playlist.length - 1] = null;
            tampilkanSemuaLagu();
        } else {
            System.out.println("Lagu dengan judul '" + judulLagu + "' tidak ditemukan dalam playlist.");
        }
    }

    void cariLagu(String judulLagu) {
        for (Lagu lagu : playlist) {
            if (lagu != null && lagu.getJudul().equalsIgnoreCase(judulLagu)) {
                System.out.println("\nLagu ditemukan: ");
                lagu.tampilkanInfo();
                return;
            }
        }
        System.out.println("Lagu dengan judul '" + judulLagu + "' tidak ditemukan dalam playlist.");
    }

    void urutkanLaguBerdasarkanDurasi(){
        for (int i = 0; i < playlist.length - 1; i++) {
            for (int j = 0; j < playlist.length - i - 1; j++) {
                if (playlist[j] != null && playlist[j + 1] != null && playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Menukar posisi lagu jika durasi lagu saat ini lebih besar dari durasi lagu berikutnya
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }
        System.out.println("Lagu berhasil diurutkan berdasarkan durasi.");
        tampilkanSemuaLagu();
    }


}
