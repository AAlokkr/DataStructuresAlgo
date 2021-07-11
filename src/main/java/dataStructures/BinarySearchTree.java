package dataStructures;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(int data) {
        this.root = new Node(data);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(9);
        bst.insert(6);
        bst.insert(4);
        bst.insert(2);
        bst.insert(3);
        bst.insert(1);
        bst.insert(8);
        bst.insert(7);
        bst.insert(5);
        bst.insertWithRec(10);
        bst.printInOrder();
        System.out.println(bst.search(1));
        bst.delete(5);
        bst.printInOrder();
        bst.printMinValue();
        bst.printMaxValue();
    }

    public boolean search(int data) {
        return searchRec(this.root, data);
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
        deleteRec(this.root, data);
    }

    public Node deleteRec(Node node, int data) {
        if (node == null) {
            return node;
        }
        if (node.data > data) {
            node.left = deleteRec(node.left, data);
        } else if (node.data < data) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    public void printMinValue() {
        System.out.println("The minimum value is: " + minValue(this.root));
    }

    public Integer minValue(Node node) {
        if (node == null) {
            return null;
        }
        int minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }

    public void printMaxValue() {
        System.out.println("The maximum value is: " + maxValue(this.root));
    }

    public Integer maxValue(Node node) {
        if (node == null) {
            return null;
        }
        int maxVal = node.data;
        while (node.right != null) {
            maxVal = node.right.data;
            node = node.right;
        }
        return maxVal;
    }

    public void insertWithRec(int data) {
        root = insertRec(this.root, data);
    }

    public Node insertRec(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (node.data > data) {
            node.left = insertRec(node.left, data);
        } else if (node.data < data) {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
            return;
        }
        Node currNode = this.root;
        while (currNode != null) {
            if (currNode.data > data) {
                if (currNode.left != null) {
                    currNode = currNode.left;
                } else {
                    currNode.left = node;
                    return;
                }
            } else if (currNode.data < data) {
                if (currNode.right != null) {
                    currNode = currNode.right;
                } else {
                    currNode.right = node;
                    return;
                }
            } else {
                System.out.println("Can't add, please check the value");
                return;
            }
        }
    }

    public void printInOrder() {
        System.out.print("In-Order: ");
        this.inOrder(this.root);
        System.out.println();
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

}
