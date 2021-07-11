package dataStructures;

public class AVLTree {
    Node root;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.printPreOrder();
        tree.delete(30);
        tree.delete(10);
        tree.delete(20);
        tree.printPreOrder();
        System.out.println(tree.search(60));
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    public boolean searchRec(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        if (node.data > data) {
            return searchRec(node.left, data);
        }
        return searchRec(node.right, data);
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    public Node deleteRec(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data > data) {
            node.left = deleteRec(node.left, data);
        } else if (node.data < data) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null || node.right == null) {
                Node temp;
                if (node.left == null) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }
                node = temp;
            } else {
                node.data = minVal(node.right);
                node.right = deleteRec(node.right, node.data);
            }
        }
        if (node == null) {
            return null;
        }

        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public int minVal(Node node) {
        int minValue = node.data;
        while (node != null) {
            minValue = node.data;
            node = node.left;
        }
        return minValue;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public Node rightRotate(Node z) {
        Node y = z.left;
        Node T3 = y.right;

        y.right = z;
        z.left = T3;

        z.height = max(getHeight(z.left), getHeight(z.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public Node leftRotate(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        z.height = max(getHeight(z.left), getHeight(z.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data > data) {
            node.left = insertRec(node.left, data);
        } else if (node.data < data) {
            node.right = insertRec(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void printPreOrder() {
        System.out.print("Pre-Order: ");
        this.preOrder(this.root);
        System.out.println();
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }
}
