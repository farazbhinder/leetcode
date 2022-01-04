package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));;
    }

    // kadane's algorithm
    public static int maxSubArray(int[] nums) {
        int[] localMaxArr = new int[nums.length];
        Arrays.fill(localMaxArr, Integer.MIN_VALUE);
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                localMaxArr[i] = Math.max(nums[i], localMaxArr[i-1] + nums[i]);
            } else if (i == 0) {
                localMaxArr[i] = nums[i];
            }
            if (localMaxArr[i] > globalMax) {
                globalMax = localMaxArr[i];
            }
        }
        return globalMax;
    }
}
