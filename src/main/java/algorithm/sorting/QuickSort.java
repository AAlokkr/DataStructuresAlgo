package algorithm.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] input = {5, 6, 2, 9, 4, 3};
        QuickSort sort = new QuickSort();
        sort.quickSort(input, 0, input.length - 1);
        sort.printArray(input);
    }

    public int partition(int[] array, int left, int right) {
        int pivot = array[right];

        int i = left;

        for (int j = left; j <= right - 1; j++) {
            if (array[j] < pivot) {
                if (array[i] != array[j]) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
                i++;
            }
        }
        if (array[i] != array[right]) {
            array[i] = array[i] + array[right];
            array[right] = array[i] - array[right];
            array[i] = array[i] - array[right];
        }
        return i;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pi = partition(array, left, right);

            quickSort(array, left, pi - 1);
            quickSort(array, pi + 1, right);
        }
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
