package team_practicum.sistem_daftar_mahasiswa;

public class Node {
    private Mahasiswa data;
    private Node next;
    
    public Node(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }
    
    // Getters
    public Mahasiswa getData() {
        return data;
    }
    
    public Node getNext() {
        return next;
    }
    
    // Setter
    public void setNext(Node next) {
        this.next = next;
    }
}

