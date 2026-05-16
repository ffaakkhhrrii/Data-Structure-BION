package forum_data_structure.session_22;

class BinaryTree {
    Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        // Gunakan Queue untuk BFS
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            // Isi anak kiri dulu
            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else {
                queue.add(temp.left);
            }

            // Jika anak kiri penuh, isi anak kanan
            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder: Left → Root → Right
    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder: Left → Right → Root
    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // ---------- SEARCH ----------
    public boolean search(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;

        // Cari di subtree kiri dan kanan
        boolean leftResult = search(node.left, key);
        if (leftResult) return true;

        return search(node.right, key);
    }

    // ---------- HEIGHT ----------
    public int height(Node node) {
        if (node == null) return -1;
        int leftHeight  = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // ---------- COUNT NODES ----------
    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // ---------- COUNT LEAF NODES ----------
    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Masukkan data ke Binary Tree
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println("=== BINARY TREE ===\n");

        // Traversal
        System.out.print("Preorder  (Root→L→R): ");
        tree.preorder(tree.root);

        System.out.print("\nInorder   (L→Root→R): ");
        tree.inorder(tree.root);

        System.out.print("\nPostorder (L→R→Root): ");
        tree.postorder(tree.root);

        System.out.println("\n");

        System.out.println("Tinggi pohon    : " + tree.height(tree.root));     // 2
        System.out.println("Jumlah node     : " + tree.countNodes(tree.root)); // 7
        System.out.println("Jumlah leaf     : " + tree.countLeaves(tree.root)); // 4

        System.out.println("Cari nilai 5    : " + tree.search(tree.root, 5));  // true
        System.out.println("Cari nilai 99   : " + tree.search(tree.root, 99)); // false
    }

}