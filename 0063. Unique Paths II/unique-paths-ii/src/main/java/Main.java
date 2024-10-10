public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacles = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] obstacles1 = {
                {0, 0},
                {0, 1}
        };
        int[][] obstacles2 = {
                {1, 0}
        };
        int[][] obstacles3 = {
                {0, 0},
                {1, 1},
                {0, 0}
        };
//        System.out.println(solution.uniquePathsWithObstacles(obstacles));
//        System.out.println(solution.uniquePathsWithObstacles(obstacles1));
//        System.out.println(solution.uniquePathsWithObstacles(obstacles2));
        System.out.println(solution.uniquePathsWithObstacles(obstacles3));
    }
}
