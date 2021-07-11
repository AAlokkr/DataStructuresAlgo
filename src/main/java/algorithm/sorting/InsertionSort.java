package algorithm.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] input = {5, 6, 2, 9, 4, 3};
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(input);
        sort.printArray(input);
    }

    public void insertionSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
