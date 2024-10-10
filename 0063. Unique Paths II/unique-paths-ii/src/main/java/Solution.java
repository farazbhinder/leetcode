public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] arr2d = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                arr2d[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                arr2d[0][i] = 1;
            } else {
                break;
            }
        }
        int paths =  uniquePathsHelper1(obstacleGrid, arr2d, m-1, n-1);
        return paths;
    }

    private int uniquePathsHelper1(int[][] obstacleGrid, int[][] arr2d, int m, int n) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return arr2d[m][n];
        }
        if (obstacleGrid[m][n] == 1) {
            arr2d[m][n] = 0;
            return 0;
        }
        else {
            int firstSum = arr2d[m][n-1];
            if (firstSum == 0 && obstacleGrid[m][n-1] != 1) {
                firstSum = uniquePathsHelper1(obstacleGrid, arr2d, m, n-1);
            }
            int secondSum = arr2d[m-1][n];
            if (secondSum == 0 && obstacleGrid[m-1][n] != 1) {
                secondSum = uniquePathsHelper1(obstacleGrid, arr2d, m-1, n);
            }
            arr2d[m][n] = firstSum + secondSum;
            return arr2d[m][n];
        }
    }
}