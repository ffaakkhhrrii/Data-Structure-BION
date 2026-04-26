package personal_assignment_2_data_structure.sistem_data_buku;

import java.util.Scanner;

public class LibraryManagementSystem {

    public BookLinkedList bookList = new BookLinkedList();
    public Scanner scanner = new Scanner(System.in);

    // Menampilkan menu utama
    public void displayMenu() {
        System.out.println("\n===== SISTEM DATA BUKU =====");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Lihat Semua Buku");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    // Menjalankan fitur tambah buku
    private void addBook() {
        System.out.print("\nMasukkan Kode Buku: ");
        String kodeBuku = scanner.nextLine().trim();

        // Validasi kode buku
        if (kodeBuku.isEmpty()) {
            System.out.println("Kode buku tidak boleh kosong!");
            return;
        }

        if (kodeBuku.length() > 5) {
            System.out.println("Kode buku maksimal 5 karakter!");
            return;
        }

        System.out.print("Masukkan Judul: ");
        String judul = scanner.nextLine().trim();

        if (judul.isEmpty()) {
            System.out.println("Judul tidak boleh kosong!");
            return;
        }

        System.out.print("Masukkan Penulis: ");
        String penulis = scanner.nextLine().trim();

        if (penulis.isEmpty()) {
            System.out.println("Penulis tidak boleh kosong!");
            return;
        }

        if (bookList.addBook(kodeBuku, judul, penulis)) {
            System.out.println("Data berhasil ditambahkan!");
        } else {
            System.out.println("Gagal menambahkan data!");
        }
    }


    // Menjalankan fitur hapus buku terakhir
    private void deleteBook() {
        if (bookList.deleteLastBook()) {
            System.out.println("\nData buku terakhir berhasil dihapus!");
        } else {
            System.out.println("\nTidak ada data untuk dihapus.");
        }
    }


    // Menjalankan fitur cari buku berdasarkan kode buku
    private void searchBook() {
        System.out.print("\nMasukkan Kode Buku: ");
        String kodeBuku = scanner.nextLine().trim();

        if (kodeBuku.isEmpty()) {
            System.out.println("Kode buku tidak boleh kosong!");
            return;
        }

        Book book = bookList.searchBook(kodeBuku);
        if (book != null) {
            System.out.println("\nBuku Ditemukan:");
            System.out.println(book.toString());
        } else {
            System.out.println("\nBuku tidak ditemukan.");
        }
    }


    // Menjalankan fitur tampilkan semua buku
    private void displayAllBooks() {
        System.out.println();
        System.out.println(bookList.displayAllBooks());
    }

    void main(String[] args) {
        int choice;
        boolean running = true;

        while (running) {
            displayMenu();
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        deleteBook();
                        break;
                    case 3:
                        searchBook();
                        break;
                    case 4:
                        displayAllBooks();
                        break;
                    case 5:
                        System.out.println("\nTerima kasih telah menggunakan Sistem Data Buku!");
                        running = false;
                        break;
                    default:
                        System.out.println("Menu tidak valid! Silakan pilih menu 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Silakan masukkan angka 1-5.");
            }
        }

        scanner.close();
    }
}




