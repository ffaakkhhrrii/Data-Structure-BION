package personal_assignment_2_data_structure.sistem_data_buku;

public class Node {
    private Book data;
    private Node next;

    public Node(Book data) {
        this.data = data;
        this.next = null;
    }

    public Book getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

