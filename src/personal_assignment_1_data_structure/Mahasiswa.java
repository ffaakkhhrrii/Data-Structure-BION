package personal_assignment_1_data_structure;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    public Mahasiswa(String nama, String nim, String jurusan, double ipk) { // Konstruktor untuk menginisialisasi data mahasiswa
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getNim() { // Disini saya membuat getter nim agar bisa mendapatkan data mahasiswa yang ingin diperbarui IPK-nya, sesuai nim yang diinput
        return nim;
    }

    public void tampilkanInfo() { // Method untuk menampilkan informasi mahasiswa
        System.out.println("Nama: " + this.nama);
        System.out.println("Nim: " + this.nim);
        System.out.println("Jurusan: " + this.jurusan);
        System.out.println("IPK: " + this.ipk);
        System.out.println("Status: " + cekKelulusan());
        System.out.println("Predikat: " + hitungPredikat());
    }

    public String cekKelulusan() {
        if(this.ipk >= 3) { // Cek apakah IPK mahasiswa memenuhi syarat kelulusan
            return "Lulus";
        } else { // Jika IPK kurang dari 3, mahasiswa dinyatakan tidak lulus
            return "Belum Lulus";
        }
    }

    public void updateIpk(double newIpk) {
        this.ipk = newIpk; // Method untuk memperbarui IPK mahasiswa
    }

    public String hitungPredikat(){ // Method untuk menghitung predikat berdasarkan IPK mahasiswa
        if(this.ipk >= 3.75) {
            return "Dengan Pujian";
        } else if(this.ipk < 3.75 && this.ipk >= 3.50) {
            return "Sangat Memuaskan";
        } else if(this.ipk < 3.50 && this.ipk >= 3.00) {
            return "Memuaskan";
        } else {
            return "Perlu Perbaikan";
        }
    }
}
