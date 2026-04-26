package personal_assignment_2_data_structure.sistem_kasir_toko;

public class CustomerQueue {
    private QueueNode front;  // Pointer ke depan antrian (pertama)
    private QueueNode rear;   // Pointer ke belakang antrian (terakhir)
    private int size;

    public CustomerQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }


    // Menambahkan pelanggan ke belakang antrian (Enqueue)
    public boolean enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        if (nomorAntrian.isEmpty() || namaPelanggan.isEmpty() || totalBelanja <= 0) {
            return false;
        }

        Customer newCustomer = new Customer(nomorAntrian, namaPelanggan, totalBelanja);
        QueueNode newNode = new QueueNode(newCustomer);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
        return true;
    }

    // Mengambil pelanggan dari depan antrian (Dequeue)
    public Customer dequeue() {
        if (front == null) {
            return null;
        }

        // Validasi: minimal 5 pelanggan harus dalam antrian sebelum dequeue
        if (size < 5) {
            return null;
        }

        Customer customer = front.getData();
        front = front.getNext();

        if (front == null) {
            rear = null;
        }
        size--;
        return customer;
    }

    // Melihat pelanggan di depan antrian tanpa menghapusnya (Peek)
    public Customer peek() {
        if (front == null) {
            return null;
        }
        return front.getData();
    }

    // Menampilkan semua pelanggan dalam antrian
    public String displayQueue() {
        if (front == null) {
            return "Antrian kosong.";
        }

        // Disini saya menggunakan StringBuilder karena lebih efisien untuk menggabungkan string dalam loop
        StringBuilder result = new StringBuilder();
        result.append("Daftar Antrian Pelanggan:\n");

        QueueNode current = front;
        int urutan = 1;
        while (current != null) {
            result.append(urutan).append(". ").append(current.getData().toString()).append("\n");
            current = current.getNext();
            urutan++;
        }

        result.append("Total Antrian: ").append(size);
        return result.toString();
    }


    // Mengembalikan jumlah pelanggan dalam antrian
    public int getSize() {
        return size;
    }

    // Memeriksa apakah antrian kosong
    public boolean isEmpty() {
        return size == 0;
    }
}

