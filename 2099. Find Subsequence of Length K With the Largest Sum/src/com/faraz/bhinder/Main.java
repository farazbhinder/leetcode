package com.faraz.bhinder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.maxSubsequence(new int[]{-1,-2,3,4}, 3);
//        s.maxSubsequence(new int[]{3,4,3,3}, 2);
        s.maxSubsequence(new int[]{-16,-13,8,16,35,-17,30,-8,34,-2,-29,-35,15,13,-30,-34,6,15,28,-23,34,28,-24,15,-17,10,31,32,-3,-36,19,31,-5,-21,-33,-18,-23,-37,-15,12,-28,-40,1,38,38,-38,33,-35,-28,-40,4,-15,-29,-33,-18,-9,-29,20,1,36,-8,23,-34,16,-7,13,39,38,7,-7,-10,30,9,26,27,-37,-18,-25,14,-36,23,28,-15,35,-9,18}, 8);
    }
}

class Solution {
    PriorityQueue maxHeap= new PriorityQueue<>(Comparator.reverseOrder());
    Map<Integer, Integer> integerMap = new HashMap<>();

    public int[] maxSubsequence(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            integerMap.put((Integer) maxHeap.peek(), integerMap.getOrDefault(maxHeap.peek(), 0) + 1);
            maxHeap.remove();
        }
        int[] result = new int[k];
        for (int i = 0, j = 0; i < nums.length && j < k; i++) {
            if (integerMap.getOrDefault(nums[i], 0) > 0) {
                integerMap.put(nums[i], integerMap.getOrDefault(nums[i], 0) - 1);
                result[j] = nums[i];
                j = j + 1;
            }
        }
        maxHeap.clear();
        integerMap.clear();
        return result;
    }
}