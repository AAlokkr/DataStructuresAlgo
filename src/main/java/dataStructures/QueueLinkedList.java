package dataStructures;

public class QueueLinkedList {

    Node head, tail;
    int capacity, count;

    public QueueLinkedList(int capacity) {
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        this.count = 0;
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }

    public void enqueue(int data) {
        if (this.isFull()) {
            System.out.println("Queue is full");
            return;
        }
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        count++;
        System.out.println(data + " enqueued");
    }

    public Integer dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        int temp = this.head.data;
        this.head = this.head.next;
        count--;
        System.out.println(temp + " dequeued");
        return temp;
    }

    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
        }
        System.out.println("*Queue*");
        Node currNode = this.head;
        while (currNode != null) {
            System.out.println("| " + currNode.data + " |");
            currNode = currNode.next;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    public int size() {
        return this.count;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
