package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{2,3,-2,4};
//        int result = solution.maxProduct(nums);
//        System.out.println(result);

        int[] nums2 = new int[]{-2,0,-1};
        int result2 = solution.maxProduct(nums2);
        System.out.println(result2);
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                localMax = 1;
                localMin = 1;
            }
            int mx = localMax * nums[i];
            int mn = localMin * nums[i];
            localMax = Math.max(nums[i], Math.max(mn, mx));
            localMin = Math.min(nums[i], Math.min(mn, mx));
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }
}