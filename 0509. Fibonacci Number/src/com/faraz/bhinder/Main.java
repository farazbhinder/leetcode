package com.faraz.bhinder;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Solution solution = new Solution();
        for (int i = 0; i < 15; i++) {
            System.out.println(solution.fib(i));
        }

        Solution2 solution2 = new Solution2();
        for (int i = 0; i < 15; i++) {
            System.out.println(solution2.fib(i));
        }
    }
}

class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int res = fib(n-1) + fib(n-2);
        map.put(n, res);
        return res;
    }
}

class Solution2 {
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        map.put(0, 0);
        map.put(1, 1);
        if (map.containsKey(n)) {
            return map.get(n);
        }
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i-1) + map.get(i-2));
        }
        return map.get(n);
    }
}