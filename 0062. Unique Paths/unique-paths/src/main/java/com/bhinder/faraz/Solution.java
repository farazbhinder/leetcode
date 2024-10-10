package com.bhinder.faraz;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr2d = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            arr2d[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            arr2d[1][i] = 1;
        }
        arr2d[0][0] = 0;
        int paths =  uniquePathsHelper(arr2d, m, n);
        return paths;
    }

    private int uniquePathsHelper(int[][] arr2d, int m, int n) {
        if (m == 1) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            int firstSum = arr2d[m][n-1];
            if (firstSum == 0) {
                firstSum = uniquePathsHelper(arr2d, m, n-1);
            }
            int secondSum = arr2d[m-1][n];
            if (secondSum == 0) {
                secondSum = uniquePathsHelper(arr2d, m-1, n);
            }
            arr2d[m][n] = firstSum + secondSum;
            return arr2d[m][n];
        }
    }
}