package personal_assignment_2_data_structure.sistem_kasir_toko;

import java.util.Scanner;

public class CashierSystem {
    public CustomerQueue customerQueue = new CustomerQueue();
    public TransactionStack transactionStack = new TransactionStack();
    public Scanner scanner = new Scanner(System.in);


    // Menampilkan menu utama
    public void displayMenu() {
        System.out.println("\n===== SISTEM KASIR TOKO =====");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Layani Pelanggan");
        System.out.println("3. Tampilkan Antrian");
        System.out.println("4. Lihat Riwayat Transaksi");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    // Menjalankan fitur tambah antrian (enqueue)
    private void addQueue() {
        System.out.print("\nMasukkan Nomor Antrian: ");
        String nomorAntrian = scanner.nextLine().trim();

        if (nomorAntrian.isEmpty()) {
            System.out.println("Nomor antrian tidak boleh kosong!");
            return;
        }

        System.out.print("Masukkan Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine().trim();

        if (namaPelanggan.isEmpty()) {
            System.out.println("Nama pelanggan tidak boleh kosong!");
            return;
        }

        System.out.print("Masukkan Total Belanja: ");
        String input = scanner.nextLine().trim();

        try {
            double totalBelanja = Double.parseDouble(input);

            if (totalBelanja <= 0) {
                System.out.println("Total belanja harus lebih dari 0!");
                return;
            }

            if (customerQueue.enqueue(nomorAntrian, namaPelanggan, totalBelanja)) {
                System.out.println("Data pelanggan ditambahkan ke antrian!");
            } else {
                System.out.println("Gagal menambahkan data ke antrian!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Total belanja harus berupa angka!");
        }
    }

    // Menjalankan fitur layani pelanggan (dequeue)
    private void serveCustomer() {
        Customer customer = customerQueue.dequeue();

        if (customer == null) {
            System.out.println("\nTidak ada pelanggan dalam antrian untuk dilayani.");
            return;
        }

        // Simpan transaksi ke stack
        Transaction transaction = new Transaction(
            customer.getNomorAntrian(),
            customer.getNamaPelanggan(),
            customer.getTotalBelanja()
        );

        transactionStack.push(transaction);

        System.out.println("\nMelayani pelanggan " + customer.getNomorAntrian() + " (" + customer.getNamaPelanggan() + ")");
        System.out.println("Total belanja: Rp" + String.format("%,.0f", customer.getTotalBelanja()));
        System.out.println("Transaksi disimpan ke riwayat.");
    }

    // Menjalankan fitur tampilkan antrian
    private void displayQueue() {
        System.out.println();
        System.out.println(customerQueue.displayQueue());
    }

    // Menjalankan fitur tampilkan riwayat transaksi
    private void displayHistory() {
        System.out.println();
        System.out.println(transactionStack.displayStack());
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
                        addQueue();
                        break;
                    case 2:
                        serveCustomer();
                        break;
                    case 3:
                        displayQueue();
                        break;
                    case 4:
                        displayHistory();
                        break;
                    case 5:
                        System.out.println("\nTerima kasih telah menggunakan Sistem Kasir Toko!");
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

