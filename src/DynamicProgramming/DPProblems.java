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




}
