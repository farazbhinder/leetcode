package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        int k = solution.removeDuplicates(nums);
        System.out.println("k is: " + k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }

    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j = j + 1;
            } else if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i = i + 1;
                j = j + 1;
            }
        }
        return i+1;
    }
}
