package personal_assignment_2_data_structure.sistem_data_buku;

public class BookLinkedList {
    private Node head;
    private int size;

    public BookLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Menambahkan buku baru ke dalam daftar akhir (Push)
    public boolean addBook(String kodeBuku, String judul, String penulis) {
        // Validasi kode buku maksimal 5 karakter
        if (kodeBuku.length() > 5) {
            return false;
        }

        Book newBook = new Book(kodeBuku, judul, penulis);
        Node newNode = new Node(newBook);

        // Menambahkan buku baru ke akhir daftar
        if (head == null) {
            head = newNode;
        } else {
            // Mencari node terakhir dan menambahkan buku baru di sana
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
        return true;
    }

    // Menghapus buku terakhir dari daftar (Pop)
    public boolean deleteLastBook() {
        if (head == null) {
            return false;
        }

        // Jika hanya ada satu buku dalam daftar
        if (head.getNext() == null) {
            head = null;
        } else {
            // Menghapus buku terakhir dengan mencari node sebelum node terakhir
            Node current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
        size--;
        return true;
    }


    // Mencari buku berdasarkan kode buku
    public Book searchBook(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.getData().getKodeBuku().equalsIgnoreCase(kodeBuku)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }


    // Menampilkan semua buku yang ada dalam daftar
    public String displayAllBooks() {
        if (head == null) {
            return "Daftar buku kosong.";
        }

        // Disini saya menggunakan StringBuilder karena lebih efisien untuk menggabungkan string dalam loop
        StringBuilder result = new StringBuilder();
        result.append("Daftar Buku:\n");

        Node current = head;
        while (current != null) {
            result.append(current.getData().toString()).append("\n");
            current = current.getNext();
        }

        result.append("Total Buku: ").append(size);
        return result.toString();
    }

    // Mendapatkan jumlah buku dalam daftar
    public int getSize() {
        return size;
    }

    // Mengecek apakah daftar buku kosong
    public boolean isEmpty() {
        return size == 0;
    }
}


