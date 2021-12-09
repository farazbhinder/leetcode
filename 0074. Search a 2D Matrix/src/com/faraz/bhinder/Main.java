package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        int[][] arr = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        int[][] arr2 = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        int[][] arr3 = {{1}};
        int[][] arr4 = {{1,2}, {3,4}};
        int[][] arr5 = {{1,2, 5, 8, 10}};
        Solution s = new Solution();

        s.searchMatrix(arr, 3);

        s.searchMatrix(arr2, 13);
        s.searchMatrix(arr2, 16);

        s.searchMatrix(arr3, 0);
        s.searchMatrix(arr3, 1);

        s.searchMatrix(arr4, 5);
        s.searchMatrix(arr4, 1);

        s.searchMatrix(arr5, 1);
        s.searchMatrix(arr5, 7);
        s.searchMatrix(arr5, 10);

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols

        int starting = 0;
        int ending = m-1;
        int mid;
        while (starting < ending) {
            mid = (int) (Math.ceil((starting + (double) ending) / 2));
            if (matrix[mid][0] > target) {
                ending = mid - 1;
            } else if (matrix[mid][0] < target) {
                starting = mid;
            } else if (matrix[mid][0] == target){
                return true;
            }
        }
        if (ending != starting){
            return false;
        }

        int theRow = ending;
        starting = 0;
        ending = n-1;
        while (starting <= ending) {
            mid = (starting + ending) / 2;
            if (matrix[theRow][mid] > target) {
                ending = mid - 1;
            } else if (matrix[theRow][mid] < target) {
                starting = mid + 1;
            } else if (matrix[theRow][mid] == target){
                return true;
            }
        }
        return false;
    }
}