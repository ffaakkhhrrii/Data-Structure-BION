package project_practicum_data_structure.tree;

// Class node dalam tree
public class Node {
    int nim;
    String nama;
    double ipk;
    Node left, right;

    public Node(int nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.left = null;
        this.right = null;
    }
}