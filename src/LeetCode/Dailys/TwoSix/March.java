package LeetCode.Dailys.TwoSix;

import java.util.Arrays;

public class March {




    // 1689. partitioning into minimum number of deci-binary numbers
    public int minPartitions(String n) {

        int minPartitions = Integer.MIN_VALUE;

        for (char c : n.toCharArray()) {

            int current = Character.getNumericValue(c);

            minPartitions = Math.max(minPartitions, current);

        }

        return minPartitions;


    }




// 1536. minimum swaps to arrange binary grid
    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int[] pos = new int[n];

        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    pos[i] = j;
                    break;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int k = -1;
            for (int j = i; j < n; j++) {
                if (pos[j] <= i) {
                    answer += j - i;
                    k = j;
                    break;
                }
            }
            if (k >= 0) {
                for (int j = k; j > i; j--) {
                    int temp = pos[j];
                    pos[j] = pos[j - 1];
                    pos[j - 1] = temp;
                }
            } else {
                return -1;
            }
        }

        return answer;

    }
































































































}
