class BinarySearchTree {

    // Node class
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // 1️ Insert node into BST → O(h)
    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);

        return node;
    }

    // 2️ Inorder traversal → O(n)
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // 2️ Preorder traversal → O(n)
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // 2️ Postorder traversal → O(n)
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // 3️ Search for a value → O(h)
    boolean search(Node node, int key) {
        if (node == null)
            return false;
        if (node.data == key)
            return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    // 4️ Find minimum value → O(h)
    int findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node.data;
    }

    // 4️ Find maximum value → O(h)
    int findMax(Node node) {
        while (node.right != null)
            node = node.right;
        return node.data;
    }

    // 5️ Delete a node → O(h)
    Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.data)
            node.left = delete(node.left, key);
        else if (key > node.data)
            node.right = delete(node.right, key);
        else {
            // Node found
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // Node with two children → get inorder successor
            node.data = findMin(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    // 6️ Count total nodes → O(n)
    int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // 6️ Count leaf nodes → O(n)
    int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // 6️    Height of BST → O(n)
    int height(Node node) {
        if (node == null) return -1; // height of empty tree = -1
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Main method
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        // Insert elements
        for (int v : values) {
            bst.root = bst.insert(bst.root, v);
        }

        // Traversals
        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        bst.preorder(bst.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        bst.postorder(bst.root);
        System.out.println();

        // Search element 60
        System.out.println("Search 60: " + bst.search(bst.root, 60));

        // Delete node 80
        bst.root = bst.delete(bst.root, 80);
        System.out.print("Inorder after deleting 80: ");
        bst.inorder(bst.root);
        System.out.println();

        // Find min and max
        System.out.println("Minimum value in BST: " + bst.findMin(bst.root));
        System.out.println("Maximum value in BST: " + bst.findMax(bst.root));

        // Count nodes and leaves
        System.out.println("Total nodes: " + bst.countNodes(bst.root));
        System.out.println("Leaf nodes: " + bst.countLeaves(bst.root));

        // Tree height
        System.out.println("Height of BST: " + bst.height(bst.root));
    }
}
