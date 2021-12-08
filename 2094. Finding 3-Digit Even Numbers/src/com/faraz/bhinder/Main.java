package com.faraz.bhinder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.findEvenNumbers(new int[]{2, 1, 3, 0});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
        System.out.println();

        int[] res2 = s.findEvenNumbers(new int[]{2,2,8,8,2});
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + ", ");
        }
    }
}

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> digitCounts = new HashMap<>();
        for (int i = 0; i < digits.length; i++) {
            digitCounts.put(digits[i], digitCounts.getOrDefault(digits[i], 0) + 1);
        }
        boolean temp;
        Map<Integer, Integer> tempMap;
        for (int i = 100; i < 999; i++) {
            if (i % 2 == 0) {
                temp = true;
                tempMap = getCountOfDigits(i);
                for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                    if (!digitCounts.containsKey(entry.getKey()) || entry.getValue() > digitCounts.get(entry.getKey())) {
                        temp = false;
                        break;
                    }
                }
                if (temp == true) {
                    res.add(i);
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private Map<Integer, Integer> getCountOfDigits(int num) {
        int firstDigit = num / 100;
        int secondDigit = (num / 10) % 10;
        int thirdDigit = num % 10;
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(firstDigit, 1);
        counts.put(secondDigit, counts.getOrDefault(secondDigit, 0) + 1);
        counts.put(thirdDigit, counts.getOrDefault(thirdDigit, 0) + 1);
        return counts;
    }
}