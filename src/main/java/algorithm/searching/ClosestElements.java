package algorithm.searching;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestElements {

    public static void main(String[] args) {
        int[] input = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int x = 32;
        int k = 5;
        printKClosest(input, x, k);
    }

    public static int findCrossOver(int[] array, int x, int left, int right) {
        if (array[left] >= x) {
            return left;
        }
        if (array[right] <= x) {
            return right;
        }

        int mid = (left + right) / 2;
        if (array[mid] <= x && array[mid + 1] > x) {
            return mid;
        }
        if (array[mid] > x) {
                return findCrossOver(array, x, left, mid - 1);
        }
        return findCrossOver(array, x, mid + 1, right);
    }

    public static void printKClosest(int[] array, int x, int k) {
        int len = array.length;
        int l = findCrossOver(array, x, 0, len - 1);
        int r = l + 1;
        int count = 0;

        if (array[l] == x) {
            l--;
        }

        while (l >= 0 && r < len && count < k) {
            if (x - array[l] < array[r] - x) {
                System.out.print(array[l--] + " ");
            } else {
                System.out.print(array[r++] + " ");
            }
            count++;
        }
    }

}
