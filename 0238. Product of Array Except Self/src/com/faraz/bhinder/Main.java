package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.productExceptSelf(new int[]{1,2,3,4});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        int[] postfixArr = new int[nums.length];
        int[] result = new int[nums.length];

        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixArr[i] = temp;
            temp = temp * nums[i];
        }
        temp = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            postfixArr[i] = temp;
            temp = temp * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixArr[i] * postfixArr[i];
        }
        return result;
    }
}