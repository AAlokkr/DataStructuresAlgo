package algorithm.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class testing {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        List<Integer> obj_array = Arrays.stream(arr).sorted().distinct().boxed().collect(Collectors.toList());

        for (int i = obj_array.size() - 1; i > obj_array.size() - 1 - k; i--) {
            System.out.print(obj_array.get(i) + " ");
        }

    }
}
