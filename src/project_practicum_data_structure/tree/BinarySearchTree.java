package project_practicum_data_structure.tree;

/**
 * Class Binary Search Tree (BST)
 */
public class BinarySearchTree {
    private Node root;

    /**
     * Constructor: Inisialisasi Binary Search Tree dengan root = null
     */
    public BinarySearchTree() {
        this.root = null;
    }


    /**
     * Metode Penambahan Data (Insert)
     * Time Complexity: O(log n) average case, O(n) worst case
     */
    public void insert(int nim, String nama, double ipk) {
        root = insertRec(root, nim, nama, ipk);
    }

    /**
     * Helper Rekursif untuk Insert
     * Membandingkan NIM yang akan diinput dengan node saat ini:
     * - Jika NIM lebih kecil, insert ke subtree kiri
     * - Jika NIM lebih besar, insert ke subtree kanan
     * - Jika NIM sama, tidak ada duplikasi
     * 
     * @return Node yang telah diupdate atau node baru jika current null
     */
    private Node insertRec(Node current, int nim, String nama, double ipk) {
        if (current == null) {
            return new Node(nim, nama, ipk);
        }

        if (nim < current.nim) {
            current.left = insertRec(current.left, nim, nama, ipk);
        } else if (nim > current.nim) {
            current.right = insertRec(current.right, nim, nama, ipk);
        }
        // Jika nim == current.nim, tidak ada operasi (tidak ada duplikasi)

        return current;
    }


    /**
     * Tree Traversal
     * Tiga metode traversal dengan urutan berbeda untuk mengunjungi setiap node
     *
     * In Order
     * Time Complexity: O(n)
     */
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    /**
     * Helper Rekursif untuk In-Order Traversal
     */
    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.print("[" + current.nim + " - " + current.nama + "] ");
            inOrderRec(current.right);
        }
    }

    /**
     * Pre-Order Traversal (Root → Left → Right)
     * Time Complexity: O(n)
     */
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    /**
     * Helper Rekursif untuk Pre-Order Traversal
     */
    private void preOrderRec(Node current) {
        if (current != null) {
            System.out.print("[" + current.nim + " - " + current.nama + "] ");
            preOrderRec(current.left);
            preOrderRec(current.right);
        }
    }

    /**
     * Post-Order Traversal (Left → Right → Root)
     * Time Complexity: O(n)
     */
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    /**
     * Helper Rekursif untuk Post-Order Traversal
     */
    private void postOrderRec(Node current) {
        if (current != null) {
            postOrderRec(current.left);
            postOrderRec(current.right);
            System.out.print("[" + current.nim + " - " + current.nama + "] ");
        }
    }


    /**
     * Metode Pencarian Data (Search)
     * Time Complexity: O(log n) average case, O(n) worst case
     */
    public Node search(int nim) {
        return searchRec(root, nim);
    }

    /**
     * Helper Rekursif untuk Search
     * Algoritma:
     * 1. Jika current null, return null (tidak ditemukan)
     * 2. Jika nim == current.nim, return current (ditemukan)
     * 3. Jika nim < current.nim, cari di subtree kiri
     * 4. Jika nim > current.nim, cari di subtree kanan
     */
    private Node searchRec(Node current, int nim) {
        if (current == null) {
            return null;
        }

        if (nim == current.nim) {
            return current;
        } else if (nim < current.nim) {
            return searchRec(current.left, nim);
        } else {
            return searchRec(current.right, nim);
        }
    }


    /**
     * Metode Penghapusan Data (Delete)
     * Time Complexity: O(log n) average case, O(n) worst case
     */
    public void delete(int nim) {
        root = deleteRec(root, nim);
    }

    /**
     * Helper Rekursif untuk Delete
     * Menangani 4 kasus:
     * KASUS 1: Node adalah LEAF (tidak ada child)
     *          → Langsung hapus, return null
     * KASUS 2: Node hanya memiliki CHILD KANAN
     *          → Ganti node dengan child kanan
     * KASUS 3: Node hanya memiliki CHILD KIRI
     *          → Ganti node dengan child kiri
     * KASUS 4: Node memiliki DUA CHILD
     *          → Cari in-order successor (node terkecil di subtree kanan)
     *          → Salin data successor ke node yang dihapus
     *          → Hapus successor dari subtree kanan
     */
    private Node deleteRec(Node current, int nim) {
        if (current == null) {
            return null;
        }

        // Navigasi ke node yang akan dihapus
        if (nim < current.nim) {
            current.left = deleteRec(current.left, nim);
        } else if (nim > current.nim) {
            current.right = deleteRec(current.right, nim);
        } else {
            // Node ditemukan, proses deletion berdasarkan jumlah child

            // Node adalah leaf (tidak ada child)
            if (current.left == null && current.right == null) {
                return null;
            }

            // Node hanya memiliki child sebelah kanan
            if (current.left == null) {
                return current.right;
            }

            // Node hanya memiliki child sebelah kiri
            if (current.right == null) {
                return current.left;
            }

            // Node memiliki dua child
            // Cari in-order successor: node dengan nilai terkecil di subtree kanan
            Node minRight = findMin(current.right);
            
            // Salin data successor ke node saat ini
            current.nim = minRight.nim;
            current.nama = minRight.nama;
            current.ipk = minRight.ipk;
            
            // Hapus successor dari subtree kanan
            current.right = deleteRec(current.right, minRight.nim);
        }

        return current;
    }

    /**
     * Helper untuk menemukan node dengan nilai minimum (paling kiri)
     * Time Complexity: O(log n) average case, O(n) worst case
     */
    private Node findMin(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
