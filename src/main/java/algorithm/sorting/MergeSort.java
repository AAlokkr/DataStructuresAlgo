package algorithm.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] input = {5, 6, 2, 9, 4, 3};
        MergeSort sort = new MergeSort();
        sort.mergeSort(input);
        sort.printArray(input);
    }

    public void mergeSort(int[] input) {
        this.sort(input, 0, input.length - 1);
    }

    public void merge(int[] array, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        System.arraycopy(array, left, leftArr, 0, len1);
        System.arraycopy(array, mid + 1, rightArr, 0, len2);

        int i, j;
        int k = left;
        i = j = 0;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                i++;
            } else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            array[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < len2) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void sort(int[] array, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;

            sort(array, left, mid);
            sort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
