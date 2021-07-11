package algorithm.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MinSet {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print(minSet(arr));
    }

    public static int minSet(int[] arr) {
        int len = arr.length;
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(freqMap.values());
        list.sort(Collections.reverseOrder());

        for (int data : list) {
            if (sum >= len / 2) {
                break;
            }
            sum = sum + data;
            res++;
        }
        return res;
    }
}
