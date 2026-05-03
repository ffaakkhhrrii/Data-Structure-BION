package team_assignment_3;

/**
 * FAKHRI ZAIN (2902701823)
 * RAIHAN ZAKY NOORDIANTORO (2902693802)
 * CAREN WONG (2902693222)
 * KEVIN LIONEL ANDRIANTO (2902700386)
 */

public class PlaylistArray {
    private Lagu[] playlist = new Lagu[10]; // Array untuk menyimpan lagu dengan kapasitas maksimal 10
    
    void tampilkanSemuaLagu() { // Traversal
        System.out.println("\n== Daftar Lagu Saat Ini ==");

        boolean adaLagu = false;
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                adaLagu = true;
                System.out.println((i + 1) + ". " + playlist[i].getJudul() + " - " + playlist[i].getArtis() + " (" + playlist[i].getDurasi() + " menit)");
            }
        }

        if (!adaLagu) {
            System.out.println("Playlist kosong. Belum ada lagu yang ditambahkan.");
        }
    }

    void tambahLagu(Lagu lagu) { // Insertion
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] == null) {
                playlist[i] = lagu;
                System.out.println("Lagu '" + lagu.getJudul() + "' berhasil ditambahkan ke playlist.");
                tampilkanSemuaLagu();
                return;
            }
        }
        System.out.println("Playlist penuh! Tidak dapat menambahkan lagu baru (Maksimal 10 lagu).");
    }

    void hapusLagu(String judulLagu) { // Deletion
        int posisiLagu = -1;
        
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null && playlist[i].getJudul().equalsIgnoreCase(judulLagu)) {
                posisiLagu = i;
                break;
            }
        }
        
        if (posisiLagu != -1) {
            System.out.println("Lagu '" + playlist[posisiLagu].getJudul() + "' berhasil dihapus dari playlist.");
            
            for (int i = posisiLagu; i < playlist.length - 1; i++) {
                playlist[i] = playlist[i + 1];
            }
            
            playlist[playlist.length - 1] = null;
            tampilkanSemuaLagu();
        } else {
            System.out.println("Lagu dengan judul '" + judulLagu + "' tidak ditemukan dalam playlist.");
        }
    }

    void cariLagu(String judulLagu) { // Searching
        for (Lagu lagu : playlist) {
            if (lagu != null && lagu.getJudul().equalsIgnoreCase(judulLagu)) {
                System.out.println("\nLagu ditemukan: ");
                lagu.tampilkanInfo();
                return;
            }
        }
        System.out.println("Lagu dengan judul '" + judulLagu + "' tidak ditemukan dalam playlist.");
    }

    void urutkanLaguBerdasarkanDurasi() { // Sorting (Bubble Sort)
        for (int i = 0; i < playlist.length - 1; i++) {
            for (int j = 0; j < playlist.length - i - 1; j++) {
                if (playlist[j] != null && playlist[j + 1] != null && playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }
        System.out.println("Lagu berhasil diurutkan berdasarkan durasi.");
        tampilkanSemuaLagu();
    }

    void urutkanLaguBerdasarkanDurasiSelection() { // Sorting (Selection Sort)
        int n = playlist.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (playlist[j] != null && (playlist[min_idx] == null || playlist[j].getDurasi() < playlist[min_idx].getDurasi())) {
                    min_idx = j;
                }
            }
            if (min_idx != i && playlist[i] != null && playlist[min_idx] != null) {
                Lagu temp = playlist[i];
                playlist[i] = playlist[min_idx];
                playlist[min_idx] = temp;
            }
        }
        System.out.println("Lagu berhasil diurutkan berdasarkan durasi (Selection Sort).");
        tampilkanSemuaLagu();
    }


    // TOTAL DURASI REKURSIF
    public static double totalDurasi(Lagu[] list, int n) {
        // Base case jika tidak ada lagu
        if (n == 0) {
            return 0;
        }
        // Recursive case jumlahkan durasi lagu ke-n dengan total n-1 lagu sebelumnya
        return totalDurasi(list, n - 1) + list[n - 1].getDurasi();
    }
  
    // TAMPILKAN MUNDUR REKURSIF
    public static void tampilkanMundur(Lagu[] list, int index) {
        // Base case: jika index sudah kurang dari 0, berhenti
        if (index < 0) {
            return;
        }
        // Tampilkan lagu di index saat ini
        System.out.println(list[index].getJudul() + " - " + list[index].getArtis() + " (" + String.format("%.2f", list[index].getDurasi()) + ")");
        // Recursive case panggil untuk index sebelumnya
        tampilkanMundur(list, index - 1);
    }
    
   
     // CARI DURASI TERPANJANG REKURSIF
    public static double cariDurasiTerpanjang(Lagu[] list, int index) {
        // Base case jika hanya satu lagu 
        if (index == 0) {
            return list[0].getDurasi();
        }
        // Recursive case cari maksimum antara durasi saat ini dan durasi terpanjang dari index sebelumnya
        double maxSebelumnya = cariDurasiTerpanjang(list, index - 1);
        double durasiSekarang = list[index].getDurasi();
        
        return Math.max(maxSebelumnya, durasiSekarang);
    }
    
    // Menampilkan lagu terpanjang
    public static String cariJudulTerpanjang(Lagu[] list, int index, int maxIndex) {
        if (index == 0) {
            return list[maxIndex].getJudul();
        }
        if (list[index].getDurasi() > list[maxIndex].getDurasi()) {
            maxIndex = index;
        }

        // Recursive case panggil untuk index sebelumnya
        return cariJudulTerpanjang(list, index - 1, maxIndex);
    }
    
    // Mencari artis dari lagu dengan durasi terpanjang
    public static String cariArtisTerpanjang(Lagu[] list, int index, int maxIndex) {
        if (index == 0) {
            return list[maxIndex].getArtis();
        }
        if (list[index].getDurasi() > list[maxIndex].getDurasi()) {
            maxIndex = index;
        }
        return cariArtisTerpanjang(list, index - 1, maxIndex);
    }
    
    // Mendapatkan jumlah lagu yang sebenarnya 
    public int getJumlahLagu() {
        int count = 0;
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Mendapatkan array playlist
     */
    public Lagu[] getPlaylist() {
        return playlist;
    }
}