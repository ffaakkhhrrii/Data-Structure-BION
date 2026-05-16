package project_practicum_data_structure.hashtable;

// Class mahasiswa
class Mahasiswa {
    private String nim;
    private String nama;
    private double ipk;

    //Constructor
    public Mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    //Getter
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public double getIpk() {
        return ipk;
    }

    //Menampilkan data mahasiswa
    public void tampilkanInfo() {
        System.out.println("NIM :" + nim);
        System.out.println("Nama :" + nama);
        System.out.println("IPK :" + ipk);
    }
}
