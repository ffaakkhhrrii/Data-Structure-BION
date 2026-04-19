package forum_data_structure.session_14;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    // Insert di depan
    void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
    }

    // Insert di akhir
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert setelah node tertentu
    void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Node sebelumnya tidak boleh null");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Insert sebelum node tertentu
    void insertBefore(Node nextNode, int data) {
        if (nextNode == null) {
            System.out.println("Node tujuan tidak boleh null");
            return;
        }

        Node newNode = new Node(data);

        newNode.prev = nextNode.prev;
        newNode.next = nextNode;

        if (nextNode.prev != null) {
            nextNode.prev.next = newNode;
        } else {
            head = newNode;
        }

        nextNode.prev = newNode;
    }

    // Insert di posisi tertentu (index mulai dari 0)
    void insertAtPosition(int position, int data) {
        if (position == 0) {
            insertAtFront(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Posisi tidak valid");
            return;
        }

        insertAfter(temp, data);
    }

    // Menampilkan list dari depan ke belakang
    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Menampilkan list dari belakang ke depan
    void displayBackward() {
        Node temp = head;

        // ke node terakhir
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtFront(10);
        dll.insertAtFront(5);
        dll.insertAtEnd(20);
        dll.insertAtEnd(25);

        System.out.println("List setelah insert depan & belakang:");
        dll.displayForward();

        // Insert setelah node kedua
        Node second = dll.head.next;
        dll.insertAfter(second, 15);

        System.out.println("Setelah insert setelah node:");
        dll.displayForward();

        // Insert sebelum node tertentu
        dll.insertBefore(second, 12);

        System.out.println("Setelah insert sebelum node:");
        dll.displayForward();

        // Insert di posisi tertentu
        dll.insertAtPosition(2, 99);

        System.out.println("Setelah insert di posisi tertentu:");
        dll.displayForward();

        System.out.println("Tampilan reverse:");
        dll.displayBackward();
    }
}
