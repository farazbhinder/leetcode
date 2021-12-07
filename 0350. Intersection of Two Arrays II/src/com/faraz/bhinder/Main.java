package com.faraz.bhinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Solution solution = new Solution();
        int[] res = solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }

}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer>  myMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            myMap.put(nums1[i], myMap.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(myMap.containsKey(nums2[i]) && myMap.get(nums2[i]) > 0) {
                myMap.put(nums2[i], myMap.get(nums2[i]) - 1);
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}