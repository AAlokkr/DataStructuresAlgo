package dataStructures;

public class MaxHeap {

    private static final int FRONT = 1;
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize + 1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(9);
        maxHeap.insert(8);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.extractMax());
        maxHeap.printHeap();

    }

    public int parent(int pos) {
        return (pos / 2);
    }

    public int leftChild(int pos) {
        return (2 * pos);
    }

    public int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public void swap(int fPos, int sPos) {
        heap[fPos] = heap[fPos] + heap[sPos];
        heap[sPos] = heap[fPos] - heap[sPos];
        heap[fPos] = heap[fPos] - heap[sPos];
    }

    public void downHeapify(int pos) {
        if (isEmpty()) {
            return;
        }
        if (!isLeaf(pos)) {
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    downHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    downHeapify(rightChild(pos));
                }
            }
        }
    }

    public void upHeapify(int pos) {
        int temp = heap[pos];
        while (pos >= 1 && temp > heap[parent(pos)]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }

    }

    public void insert(int data) {
        if (this.size >= this.maxSize) {
            return;
        }
        heap[++size] = data;
        upHeapify(size);
    }

    public Integer delete(int pos) {
        if (isEmpty()) {
            return null;
        }
        int popped = heap[pos];
        heap[pos] = heap[size--];
        downHeapify(pos);
        return popped;
    }

    public void printHeap() {
        if (isEmpty()) {
            System.out.println("Max-Heap is empty");
        }
        System.out.print("Max-Heap: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public Integer getMax() {
        if (isEmpty()) {
            return null;
        }
        return heap[FRONT];
    }

    public Integer extractMax() {
        return delete(FRONT);
    }
}
