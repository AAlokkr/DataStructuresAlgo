package algorithm.sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] input = {5, 6, 2, 9, 4, 3};
        HeapSort sort = new HeapSort();
        sort.heapSort(input);
        sort.printArray(input);
    }

    public void heapSort(int[] array) {
        int size = array.length;

        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        for (int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] =  temp;
            heapify(array, i, 0);
        }
    }

    public void heapify(int[] array, int size, int pos) {
        int largest = pos;
        int left = (2 * pos) + 1;
        int right = (2 * pos) + 2;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != pos) {
            int temp = array[pos];
            array[pos] = array[largest];
            array[largest] = temp;

            heapify(array, size, largest);
        }
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
