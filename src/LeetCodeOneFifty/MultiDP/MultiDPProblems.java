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



    public int minTotalHelper(List<List<Integer>> triangle, int i, int j, int[][] val) {

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






}
