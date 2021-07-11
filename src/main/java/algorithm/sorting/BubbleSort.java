package algorithm.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {5, 6, 2, 9, 4, 3};
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(input);
        sort.printArray(input);
    }

    public void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
