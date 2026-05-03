package team_assignment_3;
/**
 * FAKHRI ZAIN (2902701823)
 * RAIHAN ZAKY NOORDIANTORO (2902693802)
 * CAREN WONG (2902693222)
 * KEVIN LIONEL ANDRIANTO (2902700386)
 */


class Lagu {

    // Atribut Lagu
    private String judul;
    private String artis;
    private double durasi;

    // Constructor
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        setDurasi(durasi); // Setter untuk validasi durasi
    }

    // Getter dan setter untuk atribut Lagu
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public double getDurasi() {
        return durasi;
    }

    // Setter untuk durasi dengan validasi
    public void setDurasi(double durasi) {
        if (durasi > 0) {
            this.durasi = durasi;
        } else {
            System.out.println("Durasi " + durasi + " tidak valid! Harus lebih dari 0.");
        }
    }


    // Method untuk menampilkan informasi lagu
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penyanyi: " + artis);
        System.out.println("Durasi: " + durasi + " menit");
    }
}