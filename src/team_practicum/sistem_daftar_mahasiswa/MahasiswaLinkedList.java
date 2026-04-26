package team_practicum.sistem_daftar_mahasiswa;

public class MahasiswaLinkedList {
    private Node head;
    private int jumlah;
    
    public MahasiswaLinkedList() {
        head = null;
        jumlah = 0;
    }
    

    // Tambah mahasiswa baru ke dalam linked list
    public void tambahMahasiswa(String nim, String nama, double nilai) {
        long startTime = System.nanoTime();
        
        // Validasi input
        if (nim == null || nim.trim().isEmpty() || 
            nama == null || nama.trim().isEmpty()) {
            System.out.println("\nError: NIM dan Nama tidak boleh kosong!");
            return;
        }
        
        if (nilai < 0 || nilai > 100) {
            System.out.println("\nError: Nilai harus antara 0-100!");
            return;
        }
        
        // Cek apakah NIM sudah terdaftar
        if (cariByNim(nim) != null) {
            System.out.println("\nError: NIM " + nim + " sudah terdaftar!");
            return;
        }
        
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, nilai);
        Node nodeBaru = new Node(mahasiswa);
        
        if (head == null) {
            head = nodeBaru;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(nodeBaru);
        }
        
        jumlah++;
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        
        System.out.println("\nMahasiswa " + nama + " berhasil ditambahkan!");
        System.out.println("  Waktu: " + (executionTime / 1_000_000.0) + " ms");
    }
    
    // Hapus mahasiswa berdasarkan NIM
    public void hapusMahasiswa(String nim) {
        long startTime = System.nanoTime();
        
        if (head == null) {
            System.out.println("\nError: Daftar mahasiswa kosong!");
            return;
        }
        
        if (head.getData().getNim().equals(nim)) {
            String nama = head.getData().getNama();
            head = head.getNext();
            jumlah--;
            
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            
            System.out.println("\nMahasiswa " + nama + " berhasil dihapus!");
            System.out.println("  Waktu: " + (executionTime / 1_000_000.0) + " ms");
            return;
        }
        
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().getNim().equals(nim)) {
                String nama = current.getNext().getData().getNama();
                current.setNext(current.getNext().getNext());
                jumlah--;
                
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                
                System.out.println("\nMahasiswa " + nama + " berhasil dihapus!");
                System.out.println("  Waktu: " + (executionTime / 1_000_000.0) + " ms");
                return;
            }
            current = current.getNext();
        }
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        
        System.out.println("\nError: Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
        System.out.println("  Waktu: " + (executionTime / 1_000_000.0) + " ms");
    }
    
    // Update nilai mahasiswa berdasarkan NIM
    public void updateNilai(String nim, double nilaiNilai) {
        long startTime = System.nanoTime();
        
        if (nilaiNilai < 0 || nilaiNilai > 100) {
            System.out.println("\nError: Nilai harus antara 0-100!");
            return;
        }
        
        Node current = head;
        while (current != null) {
            if (current.getData().getNim().equals(nim)) {
                double nilaiLama = current.getData().getNilai();
                current.getData().setNilai(nilaiNilai);
                
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                
                System.out.println("\nNilai mahasiswa " + current.getData().getNama() +
                                 " diperbarui dari " + nilaiLama + " menjadi " + nilaiNilai);
                System.out.println("  Waktu: " + (executionTime / 1_000_000.0) + " ms");
                return;
            }
            current = current.getNext();
        }
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        
        System.out.println("\nError: Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
        System.out.println("  Waktu: " + (executionTime / 1_000_000.0) + " ms");
    }
    
    // Tampilkan daftar mahasiswa
    public void tampilkanDaftar() {
        if (head == null) {
            System.out.println("\nDaftar mahasiswa kosong!");
            return;
        }

        System.out.println("=== Daftar Mahasiswa Terdaftar ===");
        
        Node current = head;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". " + current.getData().toString());
            current = current.getNext();
            no++;
        }

        System.out.println("Total : " + jumlah + " mahasiswa" );
    }
    
    // Cari mahasiswa berdasarkan NIM
    public Mahasiswa cariByNim(String nim) {
        Node current = head;
        while (current != null) {
            if (current.getData().getNim().equals(nim)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
}

