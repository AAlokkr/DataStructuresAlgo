package dataStructures;

public class SinglyLinkedList {
    Node head;

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.printList();
        list.deleteByKey(3);
        list.printList();
        list.deleteByPosition(3);
        list.printList();
        list.insertAtPosition(3, 2);
        list.printList();
        System.out.println(list.size());
        System.out.println(list.searchList(6));
        list.reverseList();
        list.printList();

    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        Node currNode = this.head;
        Node prev = null;

        if (position == 0) {
            this.head = newNode;
            newNode.next = currNode;
            System.out.println(data + " inserted at position: " + position);
        }

        int counter = 0;

        while (currNode != null) {
            if (position == counter) {
                assert prev != null;
                prev.next = newNode;
                newNode.next = currNode;
                System.out.println(data + " inserted at position: " + position);
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if (currNode == null && counter == position) {
            assert prev != null;
            prev.next = newNode;
            System.out.println(data + " inserted at position: " + position);
        } else if (currNode == null) {
            System.out.println("List is empty or position not found");
        }
    }

    public void deleteNode(Node currNode, Node prev) {
        if (this.isEmpty()) {
            return;
        }
        if (this.head == currNode) {
            this.head = currNode.next;
        }
        if (currNode.next != null && currNode.next != this.head) {
            prev.next = currNode.next;
        }
        if (currNode.next == null) {
            prev.next = null;
        }
    }

    public void deleteByKey(int key) {
        Node currNode = this.head;
        Node prev = null;

        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        while (currNode != null) {
            if (currNode.data == key) {
                deleteNode(currNode, prev);
                System.out.println(key + " deleted");
                return;
            }
            prev = currNode;
            currNode = currNode.next;
        }

        System.out.println(key + " not found.");
    }

    public void deleteByPosition(int position) {
        Node currNode = this.head;
        Node prev = null;

        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        int counter = 0;

        while (currNode != null) {
            if (counter == position) {
                deleteNode(currNode, prev);
                System.out.println(currNode.data + " deleted at position: " + position);
                return;
            }
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }
        System.out.println(position + " position element not found.");
    }

    public boolean searchList(int data) {
        if (this.isEmpty()) {
            return false;
        }

        Node currNode = head.next;
        while (currNode != null) {
            if (currNode.data == data) {
                return true;
            } else {
                currNode = currNode.next;
            }
        }
        return false;
    }

    public void reverseList() {
        Node currNode, prev, next;
        currNode = this.head;
        prev = null;

        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        this.head = prev;
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

    public boolean isEmpty() {
        return this.head == null;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
