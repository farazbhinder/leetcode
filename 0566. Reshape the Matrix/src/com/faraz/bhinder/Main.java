package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] arr = {{1,2}, {3,4}};
        solution.printMatrix(arr, 2, 2, "Input matrix");

        int rows = 1;
        int cols = 4;
        int[][] res = solution.matrixReshape(arr, rows, cols);
        solution.printMatrix(res, rows, cols, "Output matrix");
    }
}

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // mat.length is no of rows; and mat[0].length is no. of columns
        if (r*c != mat.length*mat[0].length){
            return mat;
        }
        // first convert into 1d array
        int[] temp = new int[r*c];
        for (int i = 0, k=0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++, k++) {
                temp[k] = mat[i][j];
            }
        }
        // now convert into 2d array
        int[][] arr = new int[r][c];
        for (int i = 0, k = 0; i < r; i++) {
            for (int j = 0; j < c; j++, k++) {
                arr[i][j] = temp[k];
            }
        }
        return arr;
    }

    public void printMatrix(int[][] mat, int rows, int cols, String heading) {
        System.out.println(heading);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
