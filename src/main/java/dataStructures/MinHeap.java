package dataStructures;

public class MinHeap {

    private static final int FRONT = 1;
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(9);
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
        System.out.println(minHeap.extractMin());
        minHeap.printHeap();
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

    public boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    public boolean isEmpty() {
        return this.size == 0;
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
            if ((heap[pos] > heap[leftChild(pos)]) || (heap[pos] > heap[rightChild(pos)])) {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
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
        while (pos >= 1 && temp < heap[parent(pos)]) {
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

    public void printHeap() {
        if (isEmpty()) {
            System.out.println("Min-Heap is empty");
        }
        System.out.print("Min-Heap: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
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

    public Integer getMin() {
        if (isEmpty()) {
            return null;
        }
        return heap[FRONT];
    }

    public Integer extractMin() {
        return delete(FRONT);
    }
}
