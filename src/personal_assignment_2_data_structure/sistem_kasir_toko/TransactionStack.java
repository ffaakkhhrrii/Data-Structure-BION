package personal_assignment_2_data_structure.sistem_kasir_toko;

public class TransactionStack {
    private StackNode top;  // Pointer ke puncak stack
    private int size;

    public TransactionStack() {
        this.top = null;
        this.size = 0;
    }

    /// Menambahkan transaksi ke puncak stack (Push)
    public boolean push(Transaction transaction) {
        if (transaction == null) {
            return false;
        }

        StackNode newNode = new StackNode(transaction);
        newNode.setNext(top);
        top = newNode;
        size++;
        return true;
    }

    /// Mengambil transaksi dari puncak stack (Pop)
    public Transaction pop() {
        if (top == null) {
            return null;
        }

        Transaction transaction = top.getData();
        top = top.getNext();
        size--;
        return transaction;
    }

    /// Melihat transaksi di puncak stack tanpa menghapusnya (Peek)
    public Transaction peek() {
        if (top == null) {
            return null;
        }
        return top.getData();
    }

    // Menampilkan semua transaksi dalam stack
    public String displayStack() {
        if (top == null) {
            return "Riwayat transaksi kosong.";
        }

        StringBuilder result = new StringBuilder();
        result.append("Riwayat Transaksi (Terbaru ke Lama):\n");

        StackNode current = top;
        int urutan = 1;
        while (current != null) {
            result.append(urutan).append(". ").append(current.getData().toString()).append("\n");
            current = current.getNext();
            urutan++;
        }

        result.append("Total Transaksi: ").append(size);
        return result.toString();
    }

    // Mendapatkan jumlah transaksi dalam stack
    public int getSize() {
        return size;
    }

    // Memeriksa apakah stack kosong
    public boolean isEmpty() {
        return size == 0;
    }
}

