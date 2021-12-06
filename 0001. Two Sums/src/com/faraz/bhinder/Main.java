package com.faraz.bhinder;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] res1 = twoSum(new int[]{2,7,11,15}, 9);
        int[] res2 = twoSum(new int[]{3,2,4}, 6);
        if (res1 != null) {
            System.out.println(res1[0] + ", " + res1[1]);
        }
        if (res2 != null) {
            System.out.println(res2[0] + ", " + res2[1]);
        }
    }

    // O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    // O(n)
    public static int[] twoSumV2(int[] nums, int target) {
        // read about how to do it in O(n) online :/
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }
}
