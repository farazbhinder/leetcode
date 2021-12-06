package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println(findPeakElement(new int[]{1}));
        System.out.println(findPeakElement(new int[]{-2147483648,-2147483647}));
    }

    public static int findPeakElement(int[] nums) {
        int peak = 0;
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i-1>=0 && i+1<nums.length && nums[i] > nums[i-1] && nums[i] > nums[i+1] && nums[i] > nums[peak]) {
                // check both sides
                peak = i;
            } else if (i==0 && nums[i] > nums[i+1] && nums[i] > nums[peak]) {
                peak = i;
            } else if (i==nums.length-1 && nums[i] > nums[i-1] && nums[i] > nums[peak]) {
                peak = i;
            }
        }
        return peak;
    }
}
