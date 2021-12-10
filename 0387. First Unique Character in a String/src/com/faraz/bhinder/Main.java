package com.faraz.bhinder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("leetcode"));
        System.out.println(s.firstUniqChar("loveleetcode"));
        System.out.println(s.firstUniqChar("aabb"));
    }
}

class Solution {
    Map<Character, Integer> map = new HashMap<>();

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.getOrDefault(s.charAt(i), 0) == 1) {
                map.clear();
                return i;
            }
        }
        map.clear();
        return -1;
    }
}