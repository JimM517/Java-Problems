package LeetCode.Dailys.TwoFive;

import java.util.*;

public class August {


    // 118. Pascals triangle
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        result = generate(numRows - 1);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        currentRow.add(1);
        result.add(currentRow);

        return result;

    }




    // 2561. rearranging fruits
    public long minCost(int[] basket1, int[] basket2) {

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        int m = Integer.MAX_VALUE;

        for (int b1 : basket1) {
            freq.put(b1, freq.getOrDefault(b1, 0) + 1);
            m = Math.min(m, b1);
        }

        for (int b2 : basket2) {
            freq.put(b2, freq.getOrDefault(b2, 0) - 1);
            m = Math.min(m, b2);
        }

        List<Integer> merge = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                merge.add(entry.getKey());
            }
        }

        Collections.sort(merge);
        long res = 0;
        for (int i = 0; i < merge.size() / 2; i++) {
            res += Math.min(2 * m, merge.get(i));
        }
        return res;
    }






    // 2106. maximum fruits harvested after at most k steps
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;
        int right = 0;
        int n = fruits.length;
        int sum = 0;
        int answer = 0;

        while (right < n) {
            sum += fruits[right][1];

            while (left <= right && step(fruits, startPos, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            answer = Math.max(answer, sum);
            right++;
        }
        return answer;
    }


    public int step(int[][] fruits, int startPos, int left, int right) {

        return (
                Math.min(
                Math.abs(startPos - fruits[right][0]),
                Math.abs(startPos - fruits[left][0])
        ) +
                fruits[right][0] -
                fruits[left][0]
        );

    }



    // 904. fruits into baskets
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the basket
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruits, shrink from the left
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            // Update the max window length
            max = Math.max(max, right - left + 1);
        }

        return max;
    }



    // 3477. fruits into baskets II
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length];
        int unplaced = 0;

        for (int i = 0; i < fruits.length; i++) {
            boolean placed = false;
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++;
            }
        }
        return unplaced;
    }




    // 3479. fruits into baskets III

        private int[] segTree = new int[400007];
        private int[] baskets;

        private void build(int p, int l, int r) {
            if (l == r) {
                segTree[p] = baskets[l];
                return;
            }
            int mid = (l + r) >> 1;
            build(p << 1, l, mid);
            build((p << 1) | 1, mid + 1, r);
            segTree[p] = Math.max(segTree[p << 1], segTree[(p << 1) | 1]);
        }

        private int query(int p, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) {
                return Integer.MIN_VALUE;
            }
            if (ql <= l && r <= qr) {
                return segTree[p];
            }
            int mid = (l + r) >> 1;
            return Math.max(
                    query(p << 1, l, mid, ql, qr),
                    query((p << 1) | 1, mid + 1, r, ql, qr)
            );
        }

        private void update(int p, int l, int r, int pos, int val) {
            if (l == r) {
                segTree[p] = val;
                return;
            }
            int mid = (l + r) >> 1;
            if (pos <= mid) {
                update(p << 1, l, mid, pos, val);
            } else {
                update((p << 1) | 1, mid + 1, r, pos, val);
            }
            segTree[p] = Math.max(segTree[p << 1], segTree[(p << 1) | 1]);
        }

        public int numOfUnplacedFruitsThree(int[] fruits, int[] baskets) {
            this.baskets = baskets;
            int m = baskets.length;
            int count = 0;
            if (m == 0) {
                return fruits.length;
            }
            Arrays.fill(segTree, Integer.MIN_VALUE);
            build(1, 0, m - 1);
            for (int i = 0; i < fruits.length; i++) {
                int l = 0;
                int r = m - 1;
                int res = -1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (query(1, 0, m - 1, 0, mid) >= fruits[i]) {
                        res = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                if (res != -1 && baskets[res] >= fruits[i]) {
                    update(1, 0, m - 1, res, Integer.MIN_VALUE);
                } else {
                    count++;
                }
            }
            return count;
        }




    // 3363. find the maximum number of fruits collected
    public int maxCollectedFruits(int[][] fruits) {

            int n = fruits.length;
            int answer = 0;

            for (int i = 0; i < n; i++) {

                answer += fruits[i][i];

            }

            java.util.function.Supplier<Integer> dp = () -> {
                int[] prev = new int[n];
                int[] curr = new int[n];
                java.util.Arrays.fill(prev, Integer.MIN_VALUE);
                java.util.Arrays.fill(curr, Integer.MIN_VALUE);
                prev[n - 1] = fruits[0][n - 1];
                for (int i = 1; i < n - 1; i++) {
                    for (int j = Math.max(n - 1 - i, i + 1); j < n; j++) {
                        int best = prev[j];
                        if (j - 1 >= 0) best = Math.max(best, prev[j - 1]);
                        if (j + 1 < n) best = Math.max(best, prev[j + 1]);
                        curr[j] = best + fruits[i][j];
                    }
                    int[] temp = prev;
                    prev = curr;
                    curr = temp;
                }
                return prev[n - 1];
            };

            answer += dp.get();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = fruits[j][i];
                    fruits[j][i] = fruits[i][j];
                    fruits[i][j] = temp;
                }
            }

        answer += dp.get();
            return answer;



    }



    // 808. soup servings
    public double soupServings(int n) {
            int m = (int) Math.ceil(n / 25.0);
            Map<Integer, Map<Integer, Double>> dp = new HashMap<>();

            for (int k = 1; k <= m; k++) {
                if (calculateDP(k, k, dp) > 1 - 1e-5) {
                    return 1.0;
                }
            }
            return calculateDP(m, m, dp);
    }


    private double calculateDP(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
            if (i <= 0 && j <= 0) {
                return 0.5;
            }
            if (i <= 0) {
                return 1.0;
            }
            if (j <= 0) {
                return 0.0;
            }
            if (dp.containsKey(i) && dp.get(i).containsKey(j)) {
                return dp.get(i).get(j);
            }
            double result = (calculateDP(i - 4, j, dp) + calculateDP(i - 3, j - 1, dp) +
                    calculateDP(i - 2, j - 2, dp) + calculateDP(i - 1, j - 3, dp)) / 4.0;
            dp.computeIfAbsent(i, k -> new HashMap<>()).put(j, result);
            return result;
    }




    // 231. power of two
    public boolean isPowerOfTwo(int n) {

            if (n <= 0) {
                return false;
            }

        while (n > 1) {
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
        return true;

    }





    // 869. reordered power of 2
    public boolean reorderedPowerOf2(int n) {

        String s = String.valueOf(n);

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < 30; i++) {
            int x = 1 << i;
            String ss = String.valueOf(x);
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : ss.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            if (freq.equals(map)) {
                return true;
            }
        }


        return false;

    }





    // 2438. range product queries of powers
    private static final int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {

            List<Integer> bins = new ArrayList<>();
            int rep = 1;

            while (n > 0) {
                if (n % 2 == 1) {
                    bins.add(rep);
                }
                n /= 2;
                rep *= 2;
            }

            int m = bins.size();
            int[][] results = new int[m][m];
            for (int i = 0; i < m; i++) {
                long cur = 1;
                for (int j = i; j < m; j++) {
                    cur = (cur * bins.get(j)) % MOD;
                    results[i][j] = (int) cur;
                }
            }

            int[] answer = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                answer[i] = results[queries[i][0]][queries[i][1]];
            }
            return answer;
    }




    // 2787. ways to express an integer as sum of powers
    public int numberOfWays(int n, int x) {

        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            long val = (long) Math.pow(i, x);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= val) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - (int) val]) % MOD;
                }
            }
        }

        return (int) dp[n][n];

    }



    // 326. power of three
    public boolean isPowerOfThree(int n) {

        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }




    // 2264. largest 3-same-digit number in string
    public String largestGoodInteger(String num) {

        char maxDigit = '\0';

        for (int idx = 0; idx <= num.length() - 3; idx++) {
            if (num.charAt(idx) == num.charAt(idx + 1) && num.charAt(idx) == num.charAt(idx + 2)) {
                maxDigit = (char) Math.max(maxDigit, num.charAt(idx));
            }
        }
        return maxDigit == '\0' ? "" : new String(new char[]{maxDigit, maxDigit, maxDigit});
    }





    // 342. power of four
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }







    // 1323. maximum 69 number
    public int maximum69Number(int num) {

        int[] nums = String.valueOf(num).chars().map(c -> c - '0').toArray();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 6) {
                nums[i] = 9;
                break;
            }



        }

        StringBuilder sb = new StringBuilder();
        for (int dig : nums) {
            sb.append(dig);
        }
        return Integer.parseInt(sb.toString());
    }



    // new 21 game
    public double new21Game(int n, int k, int maxPts) {

        double[] dp = new double[n + 1];
        dp[0] = 1;
        double s = k > 0 ? 1 : 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = s / maxPts;
            if (i < k) {
                s += dp[i];
            }
            if (i - maxPts >= 0 && i - maxPts < k) {
                s -= dp[i - maxPts];
            }
        }
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }

        return ans;

    }





    // 2348. number of zero-filled subarrays
    public long zeroFilledSubarray(int[] nums) {

        long result = 0;
        int zeroes = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroes++;
                result += zeroes;
            } else {
                zeroes = 0;
            }
        }


        return result;

    }



    // 1277. count square submatrices with all ones
    public int countSquares(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        int prev = 0;

        int[] dp = new int[col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                if (matrix[i - 1][j - 1] == 1) {
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j - 1], dp[j]));
                    prev = temp;
                    result += dp[j];
                } else {
                    dp[j] = 0;
                }

            }
        }


        return result;


    }







    // 1504. count submatrices with all ones
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int res = 0;

        int[][] row = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else {
                    row[i][j] = mat[i][j] == 0 ? 0 : row[i][j - 1] + 1;
                }
                int cur = row[i][j];
                for (int k = i; k >= 0; k--) {
                    cur = Math.min(cur, row[k][j]);
                    if (cur == 0) {
                        break;
                    }
                    res += cur;
                }
            }
        }
        return res;
    }




    // 3195. Find the minimum area to cover all ones 1
    public int minimumArea(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int min_i = n;
        int max_i = 0;
        int min_j = m;
        int max_j = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    min_i = Math.min(min_i, i);
                    max_i = Math.max(max_i, i);
                    min_j = Math.min(min_j, j);
                    max_j = Math.max(max_j, j);
                }
            }
        }
        return (max_i - min_i + 1) * (max_j - min_j + 1);
    }






    // 3197. find the minimum area to cover all ones II
        private int minimumSum2(int[][] grid, int u, int d, int l, int r) {
            int min_i = grid.length;
            int max_i = 0;
            int min_j = grid[0].length;
            int max_j = 0;
            for (int i = u; i <= d; i++) {
                for (int j = l; j <= r; j++) {
                    if (grid[i][j] == 1) {
                        min_i = Math.min(min_i, i);
                        min_j = Math.min(min_j, j);
                        max_i = Math.max(max_i, i);
                        max_j = Math.max(max_j, j);
                    }
                }
            }
            return min_i <= max_i
                    ? (max_i - min_i + 1) * (max_j - min_j + 1)
                    : Integer.MAX_VALUE / 3;
        }

        private int[][] rotate(int[][] vec) {
            int n = vec.length;
            int m = vec[0].length;
            int[][] ret = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ret[m - j - 1][i] = vec[i][j];
                }
            }
            return ret;
        }

        private int solve(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int res = n * m;
            for (int i = 0; i + 1 < n; i++) {
                for (int j = 0; j + 1 < m; j++) {
                    res = Math.min(
                            res,
                            minimumSum2(grid, 0, i, 0, m - 1) +
                                    minimumSum2(grid, i + 1, n - 1, 0, j) +
                                    minimumSum2(grid, i + 1, n - 1, j + 1, m - 1)
                    );
                    res = Math.min(
                            res,
                            minimumSum2(grid, 0, i, 0, j) +
                                    minimumSum2(grid, 0, i, j + 1, m - 1) +
                                    minimumSum2(grid, i + 1, n - 1, 0, m - 1)
                    );
                }
            }
            for (int i = 0; i + 2 < n; i++) {
                for (int j = i + 1; j + 1 < n; j++) {
                    res = Math.min(
                            res,
                            minimumSum2(grid, 0, i, 0, m - 1) +
                                    minimumSum2(grid, i + 1, j, 0, m - 1) +
                                    minimumSum2(grid, j + 1, n - 1, 0, m - 1)
                    );
                }
            }
            return res;
        }

        public int minimumSum(int[][] grid) {
            int[][] rgrid = rotate(grid);
            return Math.min(solve(grid), solve(rgrid));
        }







        // 1493. longest subarray of 1's after deleting one element
    /*** basically max consecutive ones III with a special case ***/
    public int longestSubarray(int[] nums) {

        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;
        int k = 1;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);

        }


        return maxLen - 1;

    }




    // 498. diagonal traverse
    public int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int N = mat.length;
        int M = mat[0].length;

        int[] result = new int[N*M];
        int k = 0;
        List<Integer> intermediate = new ArrayList<>();

        for (int d = 0; d < N + M - 1; d++) {
            intermediate.clear();


            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            while (r < N && c > -1) {
                intermediate.add(mat[r][c]);
                r++;
                c--;
            }

            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }




        }

        return result;
    }




    // 3000. maximum area of longest diagonal rectangle
    public int areaOfMaxDiagonal(int[][] dimensions) {

        int maxDiaSq = 0;
        int maxArea = 0;
        for (int[] dim : dimensions) {
            int l = dim[0];
            int w = dim[1];
            int diaSq = l * l + w * w;
            int area = l * w;
            if (diaSq > maxDiaSq) {
                maxDiaSq = diaSq;
                maxArea = area;
            } else if (diaSq == maxDiaSq) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }






    // 3459. length of longest v-shaped diagonal segment

        private static final int[][] DIRS = {
                { 1, 1 },
                { 1, -1 },
                { -1, -1 },
                { -1, 1 },
        };
        private int[][][][] memo;
        private int[][] grid;
        private int m, n;

        public int lenOfVDiagonal(int[][] grid) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            this.memo = new int[m][n][4][2];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        Arrays.fill(memo[i][j][k], -1);
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        for (int direction = 0; direction < 4; direction++) {
                            res = Math.max(res, dfs(i, j, direction, true, 2) + 1);
                        }
                    }
                }
            }
            return res;
        }

        private int dfs(int cx, int cy, int direction, boolean turn, int target) {
            int nx = cx + DIRS[direction][0];
            int ny = cy + DIRS[direction][1];
            /* If it goes beyond the boundary or the next node's value is not the target value, then return */
            if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != target) {
                return 0;
            }

            int turnInt = turn ? 1 : 0;
            if (memo[nx][ny][direction][turnInt] != -1) {
                return memo[nx][ny][direction][turnInt];
            }

            /* Continue walking in the original direction. */
            int maxStep = dfs(nx, ny, direction, turn, 2 - target);
            if (turn) {
                /* Clockwise rotate 90 degrees turn */
                maxStep = Math.max(
                        maxStep,
                        dfs(nx, ny, (direction + 1) % 4, false, 2 - target)
                );
            }
            memo[nx][ny][direction][turnInt] = maxStep + 1;
            return maxStep + 1;
        }



        // 3446. sort matrix by diagonals
    public int[][] sortMatrix(int[][] grid) {

            int n = grid.length;

            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; i + j < n; j++) {
                    temp.add(grid[i + j][j]);
                }
                temp.sort(Collections.reverseOrder());
                for (int j = 0; i + j < n; j++) {
                    grid[i + j][j] = temp.get(j);
                }
            }

            for (int j = 1; j < n; j++) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; j + i < n; i++) {
                    temp.add(grid[i][j + i]);
                }
                Collections.sort(temp);
                for (int i = 0; j + i < n; i++) {
                    grid[i][j + i] = temp.get(i);
                }
            }

            return grid;

    }




    // 3021. alice and bob playing flower game
    public long flowerGame(int n, int m) {

        return ((long) m * n) / 2;
    }





    // 36. valid sudoku
    public boolean isValidSudoku(char[][] board) {

            Set<String> seen = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        if (!seen.add(num + " in row " + i) || !seen.add(num + " in col " + j) || !seen.add(num + " in box " + i / 3 + "-" + j / 3)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }




















}
