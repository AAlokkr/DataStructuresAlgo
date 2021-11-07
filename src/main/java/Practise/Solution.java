package Practise;

class Solution {

    public static void main(String[] args) {
        int[] arr = {5, 4,-1, 7, 8};
        System.out.println(maxSubArray(arr));
        String s = "abcd ef gh";
        int len = s.length();
        int i = 0;

        String res;
        while(i != len - 1) {
            char a = s.charAt(i);
            if (a == ' ') {

            }
        }
    }



    public static int maxSubArray(int[] nums) {

        int maxi, prevMax;
        int len = nums.length;
        maxi = prevMax = nums[0];

        if (len == 1)
            return nums[0];

        for (int i = 1; i< len; i++) {
            maxi = Math.max(maxi + nums[i], nums[i]);

            if (prevMax < maxi) {
                prevMax = maxi;
            }
        }
        return prevMax;

    }
}