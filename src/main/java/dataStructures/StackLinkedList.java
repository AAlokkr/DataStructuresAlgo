package dataStructures;

public class StackLinkedList {
    int capacity, count;
    Node top;

    public StackLinkedList(int capacity) {
        this.top = null;
        this.capacity = capacity;
        this.count = 0;
    }

    public static void main(String[] args) {

        StackLinkedList stack = new StackLinkedList(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println(stack.pop());
        stack.printStack();
        System.out.println("Peek: " + stack.peek());
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    public void printStack() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node currNode = this.top;
        System.out.println("*Stack*");
        while (currNode != null) {
            System.out.println("| " + currNode.data + " |");
            currNode = currNode.next;
        }
        System.out.println(" ¯¯¯ ");
    }

    public int size() {
        return this.count;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return this.top.data;
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        int temp = this.top.data;
        this.top = this.top.next;
        this.count--;
        System.out.println(temp + " popped");
        return temp;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (this.isFull()) {
            System.out.println("Stack is full");
            return;
        }
        if (!this.isEmpty()) {
            newNode.next = this.top;
        }
        this.top = newNode;
        this.count++;
        System.out.println(data + " pushed");
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
