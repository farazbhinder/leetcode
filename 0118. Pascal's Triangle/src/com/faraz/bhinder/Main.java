package com.faraz.bhinder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generate(50);
        s.generate(5);
    }
}

class Solution {
    Map<Integer, List<Integer>> cache = new HashMap<>();

    public List<List<Integer>> generate(int numRows) {
        // not very proud of it; works though :/
        List<List<Integer>> res = new ArrayList<>();

        cache.put(1, Arrays.asList(1));
        res.add(cache.get(1));
        if (numRows == 1) {
            return res;
        }

        cache.put(2, Arrays.asList(1, 1));
        res.add(cache.get(2));
        if (numRows == 2) {
            return res;
        }


        for (int i = 3; i <=numRows ; i++) {
            cache.put(i, new ArrayList<>());
            for (int j = 0; j < cache.get(i-1).size(); j++) {
                if (j==0 || j+1 == cache.get(i-1).size()) {
                    cache.get(i).add(cache.get(i-1).get(j));
                }
                if (j+1 < cache.get(i-1).size()) {
                    cache.get(i).add(cache.get(i-1).get(j) + cache.get(i-1).get(j+1));
                }
            }
            res.add(cache.get(i));
        }
        return res;
    }
}