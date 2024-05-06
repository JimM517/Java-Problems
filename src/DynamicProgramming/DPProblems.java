package DynamicProgramming;

public class DPProblems {


    // 1025. Divisor Game
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }





    // 1668. maximum repeating substring
    public int maxRepeating(String sequence, String word) {

       int count = 0;

       String add = word;

       while (sequence.contains(word)) {
           count++;
           word += add;
       }
        return count;
    }




    // 62. Unique Paths
    public int uniquePaths(int m, int n) {

        int[][] gridDp = new int[m][n];

        gridDp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i != m - 1) {
                    gridDp[i][j] = gridDp[i + 1][j];
                }

                if (j != n - 1) {
                    gridDp[i][j] += gridDp[i][j + 1];
                }


            }
        }

        return gridDp[0][0];

    }






    // 63. Unique Paths II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;

        }


        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }


        if (dp.length == 1 || dp[0].length == 1) {
            return dp[dp.length - 1][dp[0].length - 1];
        }


        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }





}
