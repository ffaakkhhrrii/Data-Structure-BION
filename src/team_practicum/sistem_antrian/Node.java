package team_practicum.sistem_antrian;

class Node {
    String namaPelanggan;
    String nomorAntrian;
    Node next;

    public Node(String namaPelanggan, String nomorAntrian) {
        this.namaPelanggan = namaPelanggan;
        this.nomorAntrian = nomorAntrian;
        this.next = null;
    }
}