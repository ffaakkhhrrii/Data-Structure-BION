package team_practicum.sistem_antrian;


//CLASS QUEUE
class Queue {
    private Node front;  //elemen depan atau yang akan dilayani
    private Node rear;   //elemen terakhir atau tempat tambah baru
    private int jumlahPelanggan;
    private int counterAntrian;

    // Constructor
    public Queue() {
        front = null;
        rear = null;
        jumlahPelanggan = 0;
        counterAntrian = 1;
    }


    //TAMBAH PELANGGAN BARU
    public void enqueue(String nama) {
        String nomorAntrian = generateNomorAntrian();
        Node newNode = new Node(nama, nomorAntrian);

        if (isEmpty()) {
            //Ketika antrian kosong
            front = newNode;
            rear = newNode;
        } else {
            //Ketika antrian tidak kosong
            rear.next = newNode;
            rear = newNode;
        }

        jumlahPelanggan++;
        System.out.println("\n" + nama + " telah ditambahkan ke antrean!");
        System.out.println("   Nomor Antrian: " + nomorAntrian);
    }


    //LAYANI PELANGGAN
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("\nAntrean kosong! Tidak ada pelanggan yang bisa dilayani.");
            return;
        }

        Node dilayani = front;

        // Pindahkan front ke node berikutnya
        front = front.next;

        // Jika antrian menjadi kosong, rear juga harus null
        if (front == null) {
            rear = null;
        }

        jumlahPelanggan--;

        System.out.println("\nMelayani pelanggan: " + dilayani.namaPelanggan);
        System.out.println("   Nomor Antrian: " + dilayani.nomorAntrian);
        System.out.println("   Selamat datang! Silakan menuju ke loket.");
    }


    //TAMPILKAN SEMUA PELANGGAN DALAM ANTREAN
    public void display() {
        if (isEmpty()) {
            System.out.println("\nAntrean kosong. Belum ada pelanggan.");
            return;
        }

        System.out.println("\n=== DAFTAR ANTREAN PELANGGAN ===");
        System.out.println("   Total antrean: " + jumlahPelanggan + " pelanggan\n");

        Node current = front;
        int urutan = 1;

        System.out.println("   No  | Nomor Antrian | Nama Pelanggan");
        System.out.println("   ----|---------------|----------------");

        while (current != null) {
            System.out.printf("   %-3d | %-13s | %s\n",
                    urutan, current.nomorAntrian, current.namaPelanggan);
            current = current.next;
            urutan++;
        }

        System.out.println("\nSelanjutnya: " + front.namaPelanggan +
                " (Nomor: " + front.nomorAntrian + ")");
    }


    //CEK APAKAH ANTREAN KOSONG
    public boolean isEmpty() {
        return front == null;
    }


    //LIHAT PELANGGAN PALING DEPAN
    public void peek() {
        if (isEmpty()) {
            System.out.println("\nAntrean kosong!");
            return;
        }

        System.out.println("\nPelanggan yang akan dilayani berikutnya:");
        System.out.println("   Nama: " + front.namaPelanggan);
        System.out.println("   Nomor Antrian: " + front.nomorAntrian);
    }


    //JUMLAH PELANGGAN
    public int getJumlahPelanggan() {
        return jumlahPelanggan;
    }


    // UTILITY: GENERATE NOMOR ANTRIAN
    private String generateNomorAntrian() {
        String kode = "A" + String.format("%03d", counterAntrian);
        counterAntrian++;
        return kode;
    }
}