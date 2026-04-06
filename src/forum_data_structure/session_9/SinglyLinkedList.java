package forum_data_structure.session_9;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    void insertHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Menyambungkan node baru ke head lama
        head = newNode;
    }

    // Insert Tail
    void insertTail(int data) {
        Node newNode = new Node(data); //

        if (head == null) {
            head = newNode; // Jika list kosong, node baru jadi head
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // Mencari node terakhir
        }

        temp.next = newNode; // Menambahkan node baru di akhir list
    }

    // Hapus node pertama
    void deleteFirst() {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }

        head = head.next; // Mengubah head ke node berikutnya, node pertama otomatis terhapus
    }

    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }

        if (position == 1) {
            deleteFirst();
            return;
        }

        Node temp = head;

        // cari node sebelum yang mau dihapus
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Posisi tidak valid!");
            return;
        }

        temp.next = temp.next.next;
    }

    void deleteLast() {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }

        if (head.next == null) { // Jika hanya ada satu node, hapus head
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) { // Loop untuk menemukan node kedua terakhir
            temp = temp.next; // Mencari node kedua terakhir
        }

        temp.next = null; // Menghapus node terakhir dengan mengubah next dari node kedua terakhir menjadi null
    }


    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            insertHead(data); // Jika posisi 1, cukup panggil insertHead
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) { // Loop untuk menemukan node sebelum posisi yang diinginkan
            temp = temp.next; // Mencari node sebelum posisi yang diinginkan
        }

        if (temp == null) {
            System.out.println("Posisi tidak valid!"); // Jika posisi lebih besar dari panjang list, tampilkan pesan error
            return;
        }

        newNode.next = temp.next; // Menyambungkan node baru ke node berikutnya
        temp.next = newNode; // Menyambungkan node sebelumnya ke node baru
    }

    // Menampilkan Linked List
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert Head
        list.insertHead(10);
        list.insertHead(5);

        // Insert Tail
        list.insertTail(20);
        list.insertTail(25);

        list.insertAtPosition(15, 3); // Insert 15 di posisi ke-3

        list.deleteFirst(); // Hapus node pertama (5)

        list.deleteAtPosition(2); // Hapus node di posisi ke-2 (15)

        list.deleteLast(); // Hapus node terakhir (25)

        System.out.println("Hasil Linked List:");
        list.display();
    }
}