package project_practicum_data_structure.hashtable;

import java.util.HashMap;

/**
 * Class Sistem Mahasiswa
 */
public class SistemMahasiswa {
    // Hash table menggunakan hash map
    private HashMap<String, Mahasiswa> dataMahasiswa;

    // Constructor
    public SistemMahasiswa() {
        dataMahasiswa = new HashMap<>();
    }

    /**
     * Metode Penambahan Mahasiswa
     * 
     * Menambahkan data mahasiswa baru ke dalam hash table dengan validasi:
     * - Cek duplikasi NIM
     * - Jika NIM sudah ada, reject dan tampilkan pesan
     * - Jika NIM baru, buat object Mahasiswa dan simpan ke HashMap
     *
     * Algoritma:
     * 1. Cek apakah NIM sudah ada di HashMap menggunakan containsKey()
     * 2. Jika ada, tampilkan pesan error dan return
     * 3. Jika tidak ada, buat object Mahasiswa baru
     * 4. Simpan ke HashMap dengan put(nim, mahasiswa)
     * 5. Tampilkan pesan sukses
     * 
     * Time Complexity: O(1) average case
     */
    public void tambahMahasiswa(String nim, String nama, double ipk) {
        // Validasi: Cek apakah NIM sudah terdaftar
        if (dataMahasiswa.containsKey(nim)) {
            System.out.println("NIM sudah terdaftar!");
            return;
        }
        
        // Buat object Mahasiswa baru
        Mahasiswa m = new Mahasiswa(nim, nama, ipk);

        // Simpan ke hash table dengan NIM sebagai key
        dataMahasiswa.put(nim, m);

        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    /**
     * Metode Pencarian Mahasiswa
     * 
     * Mencari data mahasiswa berdasarkan NIM menggunakan hash table lookup.
     * Operasi pencarian sangat cepat O(1) karena menggunakan hashing.
     *
     * Algoritma:
     * 1. Gunakan containsKey(nim) untuk cek kehadiran NIM
     * 2. Jika ada, ambil object Mahasiswa dengan get(nim)
     * 3. Tampilkan informasi mahasiswa lengkap
     * 4. Jika tidak ada, tampilkan pesan data tidak ditemukan
     * 
     * Time Complexity: O(1) average case untuk lookup
     */
    public void cariMahasiswa(String nim) {
        // Mengecek apakah NIM ada di hash table
        if (dataMahasiswa.containsKey(nim)) {
            // Mengambil object Mahasiswa dari hash table
            Mahasiswa m = dataMahasiswa.get(nim);

            System.out.println("\nData Mahasiswa Ditemukan");
            m.tampilkanInfo();

        } else {
            System.out.println("\nData mahasiswa tidak ditemukan");
        }
    }

    /**
     * Metode Penghapusan Mahasiswa
     * 
     * Menghapus data mahasiswa dari hash table berdasarkan NIM.
     * Operasi deletion sangat efisien dengan time complexity O(1).
     *
     * Algoritma:
     * 1. Cek kehadiran NIM dengan containsKey(nim)
     * 2. Jika ada, hapus entry dari HashMap dengan remove(nim)
     * 3. Tampilkan pesan sukses deletion
     * 4. Jika tidak ada, tampilkan pesan data tidak ditemukan
     * 
     * Time Complexity: O(1) average case
     */
    public void hapusMahasiswa(String nim) {
        // Mengecek apakah data mahasiswa ada di hash table
        if (dataMahasiswa.containsKey(nim)) {
            // Menghapus entry dari hash table
            dataMahasiswa.remove(nim);

            System.out.println("\nData mahasiswa berhasil dihapus!");

        } else {
            System.out.println("\nData mahasiswa tidak ditemukan!");
        }
    }
}


