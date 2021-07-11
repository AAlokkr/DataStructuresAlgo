package algorithm.searching;

public class BinarySearch {

    /*
    Time Complexity O(log n)
    Space complexity O(log n)
     */
    public static int binarySearchRecursive(int arr[], int target, int start, int end) {
        if (start <= end && arr.length > 0) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchRecursive(arr, target, mid + 1, end);
            } else {
                return binarySearchRecursive(arr, target, start, mid - 1);
            }
        }
        return -1;
    }

    /*
    Time Complexity O(1)
    Space complexity O(log n)
     */
    public static int binarySearch(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(list, 0));
        System.out.println(binarySearchRecursive(list, 5, 0, list.length));
    }
}
