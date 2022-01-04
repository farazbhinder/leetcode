package com.faraz.bhinder;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kConcatenationMaxSum(new int[]{1,2}, 1));
        System.out.println(solution.kConcatenationMaxSum(new int[]{1,2}, 3));
        System.out.println(solution.kConcatenationMaxSum(new int[]{1,-2,1}, 5));
        System.out.println(solution.kConcatenationMaxSum(new int[]{-1,-2}, 7));
        System.out.println(solution.kConcatenationMaxSum(new int[]{10000,10000,10000,10000,10000,10000,10000,10000,10000,10000}, 100000));
    }
}

class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int[] copy = arr;
        if (k >= 2) {
            copy = new int[arr.length * 2];
            for (int i = 0, j = 0; i < copy.length; i++) {
                copy[i] = arr[j];
                j = (j + 1) % arr.length;
            }
        }
        int twoOuterArraysSum = (int) maxSubArray(copy) % ((int)Math.pow(10, 9) + 7);
        int k2sum = moduloSum(Arrays.stream(arr).sum(), (k-2));
        return Math.max(0, k2sum > 0 ? twoOuterArraysSum + (int) k2sum : twoOuterArraysSum);
    }

    // kadane's algorithm: took from 0053. Maximum Subarray
    public long maxSubArray(int[] nums) {
        long[] localMaxArr = new long[nums.length];
        Arrays.fill(localMaxArr, Integer.MIN_VALUE);
        long globalMax = Integer.MIN_VALUE;
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
        return Math.max(0, globalMax);
    }
    
    public int moduloSum(int val, int times) {
        int sum = 0;
        for (int i = 0; i < times; i++) {
            sum = sum + val;
            sum = sum % ((int)Math.pow(10, 9) + 7);
        }
        return sum;
    }
}