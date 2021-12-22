package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Solution s = new Solution();
        System.out.println(s.maximalSquare(matrix));
    }
}

class Solution {
    // understood the logic/intuition from this video: https://www.youtube.com/watch?v=RElcqtFYTm0&t=427s
    public int maximalSquare(char[][] matrix) {
        int[][] table = new int[matrix.length+1][matrix[0].length+1];
        int max = table[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    table[i+1][j+1] = Math.min(Math.min(table[i][j], table[i][j+1]), table[i+1][j]) + 1;
                    if (table[i+1][j+1] > max) {
                        max = table[i+1][j+1];
                    }
                }
            }
        }
        return max*max;
    }
}