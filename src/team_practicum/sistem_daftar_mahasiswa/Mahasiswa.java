package team_practicum.sistem_daftar_mahasiswa;

public class Mahasiswa {
    private String nim;
    private String nama;
    private double nilai;
    
    public Mahasiswa(String nim, String nama, double nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }
    
    // Getters
    public String getNim() {
        return nim;
    }
    
    public String getNama() {
        return nama;
    }
    
    public double getNilai() {
        return nilai;
    }
    
    // Setters
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    
    @Override
    public String toString() {
        return String.format("NIM: %-10s | Nama: %-20s | Nilai: %.2f", nim, nama, nilai);
    }
}

