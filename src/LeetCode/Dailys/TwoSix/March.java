package LeetCode.Dailys.TwoSix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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





    // 1980. find unique binary string
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character current = nums[i].charAt(i);
            sb.append(current == '0' ? '1' : '0');
        }
        return sb.toString();
    }






// 3129. find all possible stable binary arrays I
    public int numberOfStableArrays(int zero, int one, int limit) {

        final long MOD = 1000000007;
        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int i = 0; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 0; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                if (i > limit) {
                    dp[i][j][0] =
                            dp[i - 1][j][0] +
                                    dp[i - 1][j][1] -
                                    dp[i - limit - 1][j][1];
                } else {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                }
                dp[i][j][0] = ((dp[i][j][0] % MOD) + MOD) % MOD;
                if (j > limit) {
                    dp[i][j][1] =
                            dp[i][j - 1][1] +
                                    dp[i][j - 1][0] -
                                    dp[i][j - limit - 1][0];
                } else {
                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
                }
                dp[i][j][1] = ((dp[i][j][1] % MOD) + MOD) % MOD;
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);



    }





    // 3130. find all possible stable binary arrays II
    public int numberOfStableArraysTwo(int zero, int one, int limit) {
        final int MOD = 1000000007;
        int[][][] dp = new int[zero + 1][one + 1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int lastBit = 0; lastBit <= 1; lastBit++) {
                    if (i == 0) {
                        if (lastBit == 0 || j > limit) {
                            dp[i][j][lastBit] = 0;
                        } else {
                            dp[i][j][lastBit] = 1;
                        }
                    } else if (j == 0) {
                        if (lastBit == 1 || i > limit) {
                            dp[i][j][lastBit] = 0;
                        } else {
                            dp[i][j][lastBit] = 1;
                        }
                    } else if (lastBit == 0) {
                        dp[i][j][lastBit] = dp[i - 1][j][0] + dp[i - 1][j][1];
                        if (i > limit) {
                            dp[i][j][lastBit] -= dp[i - limit - 1][j][1];
                        }
                    } else {
                        dp[i][j][lastBit] = dp[i][j - 1][0] + dp[i][j - 1][1];
                        if (j > limit) {
                            dp[i][j][lastBit] -= dp[i][j - limit - 1][0];
                        }
                    }
                    dp[i][j][lastBit] %= MOD;
                    if (dp[i][j][lastBit] < 0) {
                        dp[i][j][lastBit] += MOD;
                    }
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }






    // 1009. complement of base 10 integer
    public int bitwiseComplement(int n) {

        String str = Integer.toBinaryString(n);

        String res = "";

        for (char c : str.toCharArray()) {
            if (c == '1') {
                res += "0";
            }
            else {
                res += "1";
            }
        }

        return Integer.parseInt(res, 2);


    }





    // 3600. maximize spanning tree stability with upgrades
    class DSU {

        int[] parent;

        DSU(int[] parent) {
            this.parent = parent.clone();
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void join(int x, int y) {
            int px = find(x);
            int py = find(y);
            parent[px] = py;
        }
    }


        private static final int MAX_STABILITY = 200000;

        public int maxStability(int n, int[][] edges, int k) {
            int ans = -1;
            if (edges.length < n - 1) {
                return -1;
            }
            List<int[]> mustEdges = new ArrayList<>();
            List<int[]> optionalEdges = new ArrayList<>();

            for (int[] edge : edges) {
                if (edge[3] == 1) {
                    mustEdges.add(edge);
                } else {
                    optionalEdges.add(edge);
                }
            }

            if (mustEdges.size() > n - 1) {
                return -1;
            }

            optionalEdges.sort((a, b) -> b[2] - a[2]);
            int selectedInit = 0;
            int mustMinStability = MAX_STABILITY;

            int[] initParent = new int[n];
            for (int i = 0; i < n; i++) {
                initParent[i] = i;
            }
            DSU dsuInit = new DSU(initParent);

            for (int[] e : mustEdges) {
                int u = e[0];
                int v = e[1];
                int s = e[2];
                if (dsuInit.find(u) == dsuInit.find(v) || selectedInit == n - 1) {
                    return -1;
                }
                dsuInit.join(u, v);
                selectedInit++;
                mustMinStability = Math.min(mustMinStability, s);
            }

            int l = 0;
            int r = mustMinStability;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;

                DSU dsu = new DSU(dsuInit.parent);
                int selected = selectedInit;
                int doubledCount = 0;

                for (int[] e : optionalEdges) {
                    int u = e[0];
                    int v = e[1];
                    int s = e[2];
                    if (dsu.find(u) == dsu.find(v)) {
                        continue;
                    }
                    if (s >= mid) {
                        dsu.join(u, v);
                        selected++;
                    } else if (doubledCount < k && s * 2 >= mid) {
                        doubledCount++;
                        dsu.join(u, v);
                        selected++;
                    } else {
                        break;
                    }
                    if (selected == n - 1) {
                        break;
                    }
                }

                if (selected != n - 1) {
                    r = mid - 1;
                } else {
                    ans = l = mid;
                }
            }

            return ans;
        }






        // 1415. the k-th lexicograpical string of all happy strings of length n
    List<String> happyStrings = new ArrayList<>();
    public String getHappyString(int n, int k) {
            String currentString = "";

            generateHappyString(n, currentString);

            if (happyStrings.size() < k) {
                return "";
            }
            Collections.sort(happyStrings);

            return happyStrings.get(k - 1);
    }

    public void generateHappyString(int n, String currentString) {
        if (currentString.length() == n) {
            happyStrings.add(currentString);
            return;
        }
        for (char curr = 'a'; curr <= 'c'; curr++) {
            if (currentString.length() > 0 && currentString.charAt(currentString.length() - 1) == curr) {
                continue;
            }
            generateHappyString(n, currentString + curr);
        }
    }







// 2839. check if strings can be made equal with operations
    public boolean canBeEqual(String s1, String s2) {

        char[] even1 = {s1.charAt(0), s1.charAt(2)}, even2 = {s2.charAt(0), s2.charAt(2)};
        char[] odd1 = {s1.charAt(1), s1.charAt(3)}, odd2 = {s2.charAt(1), s2.charAt(3)};

        Arrays.sort(even1); Arrays.sort(even2);
        Arrays.sort(odd1); Arrays.sort(odd2);

        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);




    }



    // 2840. check if strings can be made equal with operations II
    public boolean checkStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            int offset = (i & 1) << 7;
            count1[offset + s1.charAt(i)]++;
            count2[offset + s2.charAt(i)]++;
        }

        return Arrays.equals(count1, count2);



    }







































}
