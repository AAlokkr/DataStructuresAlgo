package dataStructures;

public class DoublyLinkedList {

    Node head, tail;

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(5);
        list.insert(4);
        list.insert(8);
        list.insert(9);
        list.insert(1);
        list.printList();
        System.out.println(list.size());
        list.deleteByKey(1);
        list.printList();
        list.insertAtPosition(4, 1);
        list.printList();
        list.deleteAtPosition(4);
        list.printList();
        System.out.println(list.size());
        System.out.println(list.searchList(1));

    }

    public boolean isEmpty() {
        return (this.head == null) && (this.tail == null);
    }

    public void deleteNode(Node currNode) {
        if (this.isEmpty()) {
            return;
        }
        if (this.head == currNode) {
            this.head = currNode.next;
        }
        if (currNode.next != null) {
            currNode.next.prev = currNode.prev;
        }
        if (currNode.prev != null) {
            currNode.prev.next = currNode.next;
        }
    }

    public void deleteAtPosition(int position) {
        Node currNode = this.head;

        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        int counter = 0;

        while (currNode != null) {
            if (counter == position) {
                deleteNode(currNode);
                System.out.println(currNode.data + " deleted at position: " + position);
                return;
            } else {
                currNode = currNode.next;
                counter++;
            }
        }
        System.out.println(position + " position element not found.");
    }

    public void deleteByKey(int key) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = this.head;

        while (currNode != null) {
            if (currNode.data == key) {
                deleteNode(currNode);
                System.out.println(key + " deleted");
                return;
            } else {
                currNode = currNode.next;
            }
        }
        System.out.println(key + " not found.");
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.head = this.tail = newNode;
            this.head.prev = this.tail.next = null;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            this.tail.next = null;
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        Node currNode = this.head;

        if (this.isEmpty() && position == 0) {
            this.head = this.tail = newNode;
            this.head.prev = this.tail.next = null;
            System.out.println(data + " inserted at position: " + position);
        }

        int counter = 0;

        while (currNode != null) {
            if (position == counter) {
                newNode.next = currNode;
                newNode.prev = currNode.prev;
                currNode.prev = currNode.prev.next = newNode;
                System.out.println(data + " inserted at position: " + position);
                break;
            } else {
                currNode = currNode.next;
                counter++;
            }
        }
        if (currNode == null && counter == position) {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            this.tail.next = null;
            System.out.println(data + " inserted at position: " + position);
        } else if (currNode == null) {
            System.out.println("List is empty or position not found");
        }
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = this.head;
        System.out.print("Linked List: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public boolean searchList(int data) {
        if (this.isEmpty()) {
            return false;
        }

        Node currNode = this.head;
        while (currNode != null) {
            if (currNode.data == data) {
                return true;
            } else {
                currNode = currNode.next;
            }
        }

        return false;
    }

    public int size() {
        int counter = 1;

        if (this.isEmpty()) {
            return 0;
        }

        Node currNode = this.head.next;

        while (currNode != null) {
            counter++;
            currNode = currNode.next;
        }

        return counter;
    }

    public static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
        }
    }
}
