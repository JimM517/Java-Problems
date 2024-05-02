package LeetCodeOneFifty.MultiDP;

import java.util.Arrays;
import java.util.List;

public class MultiDPProblems {

    // 120. Triangle
    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] val = new int[triangle.size()][triangle.size()];

        for (int[] temp : val) {
            Arrays.fill(temp, -10001);
        }

        return minTotalHelper(triangle, 0, 0, val);

    }



    public int minTotalHelper(List<List<Integer>> triangle, int i, int j, int[][] val ) {

            if (i == triangle.size()) {
                return 0;
            }

            if (val[i][j] != -10001) {
                return val[i][j];
            }


            int a = triangle.get(i).get(j) + minTotalHelper(triangle, i + 1, j, val);
            int b = triangle.get(i).get(j) + minTotalHelper(triangle, i + 1, j + 1, val);


            return val[i][j] = Math.min(a, b);
    }







    // 64. Minimum Path Sum
    public int minPathSum(int[][] grid) {

        int m = grid.length;

        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }



        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int one = Integer.MAX_VALUE;
                int two = Integer.MAX_VALUE;

                if (i == j && i == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if (i > 0) {
                    one = dp[i - 1][j] + grid[i][j];
                }
                if (j > 0) {
                    two = dp[i][j - 1] + grid[i][j];
                }
                dp[i][j] = Math.min(one, two);
            }
        }


        return dp[m - 1][n - 1];

    }



}
