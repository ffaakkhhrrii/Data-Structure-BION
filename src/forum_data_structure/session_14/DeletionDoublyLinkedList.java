package forum_data_structure.session_14;

public class DeletionDoublyLinkedList {
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

    // 1. Delete di awal
    void deleteAtBeginning() {
        if (head == null) return;

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
    }

    // 2. Delete setelah node tertentu
    void deleteAfter(Node prevNode) {
        if (prevNode == null || prevNode.next == null) return;

        Node del = prevNode.next;
        prevNode.next = del.next;

        if (del.next != null) {
            del.next.prev = prevNode;
        }
    }

    // 3. Delete sebelum node tertentu
    void deleteBefore(Node nextNode) {
        if (nextNode == null || nextNode.prev == null) return;

        Node del = nextNode.prev;

        if (del.prev != null) {
            del.prev.next = nextNode;
            nextNode.prev = del.prev;
        } else {
            head = nextNode;
            nextNode.prev = null;
        }
    }

    // 4. Delete di posisi tertentu
    void deleteAtPosition(int position) {
        if (head == null) return;

        Node temp = head;

        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp.prev == null) {
            deleteAtBeginning();
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        temp.prev.next = temp.next;
    }

    // 5. Delete di akhir
    void deleteAtEnd() {
        if (head == null) return;

        Node temp = head;

        if (temp.next == null) {
            head = null;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }


    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void displayBackward() {
        Node temp = head;

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
        DeletionDoublyLinkedList dll = new DeletionDoublyLinkedList();

        // INSERT LEBIH BANYAK DATA
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.insertAtEnd(60);

        System.out.println("List awal:");
        dll.displayForward();

        // 1. DELETE AWAL
        dll.deleteAtBeginning();
        System.out.println("Setelah deleteAtBeginning:");
        dll.displayForward();

        // 2. DELETE SETELAH NODE (node ke-2)
        Node second = dll.head.next;
        dll.deleteAfter(second);
        System.out.println("Setelah deleteAfterGivenNode (second):");
        dll.displayForward();

        // 3. DELETE SEBELUM NODE (node ke-3)
        Node third = dll.head.next.next;
        dll.deleteBefore(third);
        System.out.println("Setelah deleteBeforeGivenNode (third):");
        dll.displayForward();

        // 4. DELETE POSISI (index 2)
        dll.deleteAtPosition(2);
        System.out.println("Setelah deleteAtPosition (2):");
        dll.displayForward();

        // 5. DELETE AKHIR
        dll.deleteAtEnd();
        System.out.println("Setelah deleteAtEnd:");
        dll.displayForward();
    }
}