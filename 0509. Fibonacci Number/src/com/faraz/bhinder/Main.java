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
