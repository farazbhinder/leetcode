package com.faraz.bhinder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] trustArr = new int[][]{{1,2}};
        System.out.println(solution.findJudge(2, trustArr));

        int[][] trustArr1 = new int[][]{{1,2}, {2,3}};
        System.out.println(solution.findJudge(3, trustArr1));

        int[][] trustArr2 = new int[][]{{}};
        System.out.println(solution.findJudge(1, trustArr2));

        int[][] trustArr3 = new int[][]{};
        System.out.println(solution.findJudge(1, trustArr3));

        int[][] trustArr4 = new int[][]{};
        System.out.println(solution.findJudge(2, trustArr3));
    }
}

// got hint from this video https://www.youtube.com/watch?v=ZUP_tIs4VaE
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustedByCount = new int[n+1];
        int[] trustingCount = new int[n+1];

        for (int i = 0; i < trust.length && trust[0].length > 0; i++) {
            trustedByCount[trust[i][1]] += 1;
            trustingCount[trust[i][0]] += 1;
        }
        for (int i = 1; i <= n; i++) {
            if (trustedByCount[i] == n -1 && trustingCount[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}