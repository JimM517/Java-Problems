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





    // 1545 find kth bit in nth binary string
    public char findKthBit(int n, int k) {

        StringBuilder sequence = new StringBuilder("0");

        for (int i = 1; i < n && k > sequence.length(); i++) {
            sequence.append("1");

            for (int j = sequence.length() - 2; j >= 0; j--) {
                char invertedBit = (sequence.charAt(j) == '1') ? '0' : '1';
                sequence.append(invertedBit);
            }
        }

        return sequence.charAt(k - 1);


    }



    // 1582. special positions in a binary matrix
    public int numSpecial(int[][] mat) {

        int answer = 0;

        int m = mat.length;
        int n = mat[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    continue;
                }

                boolean good = true;
                for (int r = 0; r < m; r++) {
                    if (r != row && mat[r][col] == 1) {
                        good = false;
                        break;
                    }
                }

                for (int c = 0; c < n; c++) {
                    if (c != col && mat[row][c] == 1) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    answer++;
                }
            }
        }


        return answer;

    }





    // 1758. minimum changes to make alternating binary string
    public int minOperations(String s) {

        int start0 = 0;
        int start1 = 0;


        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }

        return Math.min(start0, start1);


    }




    // 1888. minimum number of flips to make the binary string alternating
    public int minFlips(String s) {

        int n = s.length();
        int[][] pre = new int[n][2];

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            pre[i][0] = (i == 0 ? 0 : pre[i - 1][1]) + (ch == '1' ? 1 : 0);
            pre[i][1] = (i == 0 ? 0 : pre[i - 1][0]) + (ch == '0' ? 1 : 0);


        }


        int answer = Math.min(pre[n - 1][0], pre[n - 1][1]);

        if (n % 2 == 1) {
            int[][] suf = new int[n][2];
            for (int i = n - 1; i >= 0; i--) {
                char ch = s.charAt(i);

                suf[i][0] = (i == n - 1 ? 0 : suf[i + 1][1]) + (ch == '1' ? 1 : 0);
                suf[i][1] = (i == n - 1 ? 0 : suf[i + 1][0]) + (ch == '0' ? 1 : 0);
            }


            for (int i = 0; i < n - 1; i++) {
                answer = Math.min(answer, pre[i][0] + suf[i + 1][0]);
                answer = Math.min(answer, pre[i][1] + suf[i + 1][1]);
            }
        }


        return answer;


    }
















































































}
