package personal_assignment_2_data_structure.sistem_kasir_toko;

public class QueueNode {
    private Customer data;
    private QueueNode next;

    public QueueNode(Customer data) {
        this.data = data;
        this.next = null;
    }

    public Customer getData() {
        return data;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}

