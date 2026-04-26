package personal_assignment_2_data_structure.sistem_kasir_toko;

public class StackNode {
    private Transaction data;
    private StackNode next;

    public StackNode(Transaction data) {
        this.data = data;
        this.next = null;
    }

    public Transaction getData() {
        return data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}

