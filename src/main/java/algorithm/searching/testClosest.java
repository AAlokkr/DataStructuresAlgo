package algorithm.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testClosest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        testClosest tc = new testClosest();
        List<Integer> res = tc.findClosestElements(arr, 4, -1);
        for (int a : res) {
            System.out.print(a + " ");
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = findCrossOver(arr, x, 0, arr.length - 1);
        int r = l + 1;
        int count = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        while (count < k) {
            if (l >= 0 && r < arr.length) {
                if (x - arr[l] > arr[r] - x) {
                    res.add(arr[r++]);
                } else {
                    res.add(arr[l--]);
                }
                count++;
            }
            if (l < 0) {
                res.add(arr[r++]);
                count++;
            }
            if (r >= arr.length) {
                res.add(arr[l--]);

                count++;
            }
        }

        Collections.sort(res);
        return res;
    }

    public int findCrossOver(int[] arr, int x, int left, int right) {
        if (x <= arr[left]) {
            return left;
        }
        if (x >= arr[right]) {
            return right;
        }

        int mid = (left + right) / 2;
        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        }

        if (arr[mid] > x) {
            return findCrossOver(arr, x, left, mid - 1);
        }
        return findCrossOver(arr, x, mid + 1, right);
    }
}
