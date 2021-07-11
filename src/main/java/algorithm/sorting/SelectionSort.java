package algorithm.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] input = {5, 6, 2, 9, 4, 3};
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(input);
        sort.printArray(input);
    }

    public void selectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            array[i] = array[i] + array[minIndex];
            array[minIndex] = array[i] - array[minIndex];
            array[i] = array[i] - array[minIndex];
        }
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
