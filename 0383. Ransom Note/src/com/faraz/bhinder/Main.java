package com.faraz.bhinder;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("aa", "aab"));
        System.out.println(solution.canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) - 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.get(ransomNote.charAt(i)) < 0) {
                map.clear();
                return false;
            }
        }
        map.clear();
        return true;
    }
}