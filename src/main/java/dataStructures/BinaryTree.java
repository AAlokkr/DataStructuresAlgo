package dataStructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;

    public BinaryTree(int data) {
        this.root = new Node(data);
    }

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree(10);
        bTree.root.left = new Node(11);
        bTree.root.left.left = new Node(7);
        bTree.root.left.right = new Node(8);
        bTree.root.right = new Node(9);
        bTree.root.right.left = new Node(15);
//        bTree.root.right.right = new Node(8);
//        bTree.root.left = new Node(2);
//        bTree.root.right = new Node(3);
//        bTree.root.left.left = new Node(4);
//        bTree.root.left.right = new Node(5);
//        bTree.root.right.left = new Node(6);
//        bTree.root.right.right = new Node(7);
        bTree.printInOrder();
//        bTree.printPreOrder();
//        bTree.printPostOrder();
        bTree.insert(12);
        bTree.printInOrder();
        bTree.delete(7);
        bTree.printInOrderWithStack();
        bTree.printInOrder();
        bTree.printBFS();
        bTree.printPreOrder();
        bTree.printPreOrderWithStack();
        bTree.printPostOrder();
        bTree.printPostOrderWithStack();
        System.out.println(bTree.maxDepth(bTree.root));
    }

    public void delete(int data) {
        if (this.root == null) {
            return;
        }
        if (this.root.left == null && this.root.right == null) {
            if (this.root.data == data) {
                this.root = null;
                return;
            }
        }
        Node temp, keyNode;
        HashMap<Node, Node> parentNode = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        temp = keyNode = null;

        while (!queue.isEmpty()) {
            temp = queue.peek();
            if (temp.data == data) {
                keyNode = temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
                parentNode.put(temp.left, temp);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                parentNode.put(temp.right, temp);
            }
            queue.remove();
        }
        if (keyNode != null) {
            int key = temp.data;
            Node parent = parentNode.get(temp);
            if (parent.left == temp) {
                parent.left = null;
            } else if (parent.right == temp) {
                parent.right = null;
            }
            keyNode.data = key;

        }
    }

    public void insert(int data) {
        insertAtNode(this.root, data);
    }

    public void insertAtNode(Node node, int data) {
        if (node == null) {
            this.root = new Node(data);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.peek();
            if (node.left == null) {
                node.left = new Node(data);
                break;
            } else {
                queue.add(node.left);
            }
            if (node.right == null) {
                node.right = new Node(data);
                break;
            } else {
                queue.add(node.right);
            }
            queue.remove();
        }
    }

    public void printBFS() {
        if (this.root == null) {
            return;
        }

        if (this.root.left == null && this.root.right == null) {
            System.out.print("BFS: " + this.root.data);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        Node node;
        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            node = queue.peek();
            if (node != null) {
                System.out.print(node.data + " ");
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            queue.remove();
        }
        System.out.println();
    }

    public void printInOrder() {
        System.out.print("In-Order: ");
        this.inOrder(this.root);
        System.out.println();
    }

    public void printPreOrder() {
        System.out.print("Pre-Order: ");
        this.preOrder(this.root);
        System.out.println();
    }

    public void printPostOrder() {
        System.out.print("Post-Order: ");
        this.postOrder(this.root);
        System.out.println();
    }

    public void printInOrderWithStack() {
        if (this.root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node currNode = this.root;
        System.out.print("In-Order: ");
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            System.out.print(currNode.data + " ");
            currNode = currNode.right;
        }
        System.out.println();
    }

    public void printPreOrderWithStack() {
        if (this.root == null) {
            return;
        }
        System.out.print("Pre-Order: ");
        Stack<Node> stack = new Stack<>();
        Node currNode = this.root;
        stack.push(currNode);
        while (!stack.isEmpty()) {
            currNode = stack.peek();
            System.out.print(currNode.data + " ");
            stack.pop();

            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        System.out.println();
    }

    public void printPostOrderWithStack() {
        if (this.root == null) {
            return;
        }
        System.out.print("Post-Order: ");
        Stack<Node> stack = new Stack<>();
        Node currNode = this.root;
        while (true) {
            while (currNode != null) {
                stack.push(currNode);
                stack.push(currNode);
                currNode = currNode.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            currNode = stack.pop();

            if (!stack.isEmpty() && stack.peek() == currNode) {
                currNode = currNode.right;
            } else {
                System.out.print(currNode.data + " ");
                currNode = null;
            }
        }
        System.out.println();
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int lDepth, rDepth;
        lDepth = maxDepth(node.left);
        rDepth = maxDepth(node.right);

        if (lDepth > rDepth) {
            return lDepth + 1;
        } else {
            return rDepth + 1;
        }
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
