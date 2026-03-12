package team_assignment_1;

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

    // Getter untuk atribut Lagu
    public String getJudul() { return judul; }
    public String getPenyanyi() { return artis; }
    public double getDurasi() { return durasi; }

    // Setter untuk durasi dengan validasi
    public void setDurasi(double durasi) {
        if (durasi > 0) {
            this.durasi = durasi;
        } else {
            System.out.println("Durasi " + durasi + " tidak valid! Harus lebih dari 0.");
            System.out.println("Durasi gagal dirubah. Nilai durasi tetap: " + this.durasi); // Menampilkan pesan error dan mempertahankan nilai durasi sebelumnya
        }
    }


    // Method untuk menampilkan informasi lagu
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penyanyi: " + artis);
        System.out.println("Durasi: " + durasi + " menit");
    }
}
