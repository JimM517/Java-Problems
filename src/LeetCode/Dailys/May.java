package LeetCode.Dailys;

import java.util.*;

public class May {

    // 2071. maximum number of tasks you can assign


        public int maxTaskAssign(
                int[] tasks,
                int[] workers,
                int pills,
                int strength
        ) {
            int n = tasks.length, m = workers.length;
            Arrays.sort(tasks);
            Arrays.sort(workers);
            int left = 1, right = Math.min(m, n), ans = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (check(tasks, workers, pills, strength, mid)) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        // Check if pills and strength can be used in mid tasks
        private boolean check(
                int[] tasks,
                int[] workers,
                int pills,
                int strength,
                int mid
        ) {
            int p = pills;
            int m = workers.length;
            Deque<Integer> ws = new ArrayDeque<>();
            int ptr = m - 1;
            // Enumerate each task from largest to smallest
            for (int i = mid - 1; i >= 0; --i) {
                while (ptr >= m - mid && workers[ptr] + strength >= tasks[i]) {
                    ws.addFirst(workers[ptr]);
                    --ptr;
                }
                if (ws.isEmpty()) {
                    return false;
                } else if (ws.getLast() >= tasks[i]) {
                    // If the largest element in the deque is greater than or equal to tasks[i]
                    ws.pollLast();
                } else {
                    if (p == 0) {
                        return false;
                    }
                    --p;
                    ws.pollFirst();
                }
            }
            return true;
        }






        // 838. push dominoes
        public String pushDominoes(String dominoes) {
                int N = dominoes.length();
                int[] indexes = new int[N+2];
                char[] symbols = new char[N+2];
                int len = 1;
                indexes[0] = -1;
                symbols[0] = 'L';

                for (int i = 0; i < N; ++i)
                    if (dominoes.charAt(i) != '.') {
                        indexes[len] = i;
                        symbols[len++] = dominoes.charAt(i);
                    }

                indexes[len] = N;
                symbols[len++] = 'R';

                char[] ans = dominoes.toCharArray();
                for (int index = 0; index < len - 1; ++index) {
                    int i = indexes[index], j = indexes[index+1];
                    char x = symbols[index], y = symbols[index+1];
                    char write;
                    if (x == y) {
                        for (int k = i+1; k < j; ++k)
                            ans[k] = x;
                    } else if (x > y) { // RL
                        for (int k = i+1; k < j; ++k)
                            ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
                    }
                }

                return String.valueOf(ans);
        }





        // 1007. Minimum domino rotations for equal row
        public int minDominoRotations(int[] tops, int[] bottoms) {

            int res = getRotations(tops, bottoms, tops[0]);
            if (bottoms[0] != tops[0]) {
                res = Math.min(res, getRotations(tops, bottoms, bottoms[0]));
            }

            return res == Integer.MAX_VALUE ? -1 : res;


        }


        private int getRotations(int[] tops, int[] bottoms, int target) {

            int rotateTop = 0, rotateBottom = 0;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != target && bottoms[i] != target) {
                    return Integer.MAX_VALUE;
                }
                if (tops[i] != target) rotateTop++;
                if (bottoms[i] != target) rotateBottom++;
            }
            return Math.min(rotateTop, rotateBottom);

        }






        // 1128. number of equivalent domino pairs
    public int numEquivDominoPairs(int[][] dominoes) {

            int[] store = new int[100];

            int count = 0;

            for (int[] i : dominoes) {
                int a = Math.min(i[0], i[1]);
                int b = Math.max(i[0], i[1]);
                int key = a * 10 + b;
                count = count + store[key];
                store[key]++;
            }

            return count;
    }





    // 790. Domino and Tromino Tiling
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        long[] dp = new long[n + 1];
        dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }




    // 1920. build an array from permutation
    public int[] buildArray(int[] nums) {


            int[] myArr = new int[nums.length];


            for (int i = 0; i < nums.length; i++) {
                myArr[i] = nums[nums[i]];
            }

            return myArr;
    }




    // 3341. find minimum time to reach last room I
    public int minTimeToReach(int[][] A) {
        int n = A.length, m = A[0].length, inf = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], inf);
        }
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        h.offer(new int[]{0, 0, 0}); // arrive time, i, j
        A[0][0] = -1;

        while (!h.isEmpty()) {
            int[] cur = h.poll();
            int t = cur[0], i = cur[1], j = cur[2];
            if (t >= dp[i][j]) continue;
            if (i == n - 1 && j == m - 1) return t;
            dp[i][j] = t;

            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (0 <= x && x < n && 0 <= y && y < m && dp[x][y] == inf) {
                    h.offer(new int[]{Math.max(A[x][y], t) + 1, x, y});
                }
            }
        }
        return -1;
    }




    private static final int INF = 0x3f3f3f3f;
    class State implements Comparable<State> {

        int x, y, dis;

        State(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(State other) {
            return Integer.compare(this.dis, other.dis);
        }
    }



    public int minTimeToReachTwo(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] d = new int[n][m];
        boolean[][] v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        d[0][0] = 0;
        PriorityQueue<State> q = new PriorityQueue<>();
        q.offer(new State(0, 0, 0));
        while (!q.isEmpty()) {
            State s = q.poll();
            if (v[s.x][s.y]) continue;
            if (s.x == n - 1 && s.y == m - 1) break;
            v[s.x][s.y] = true;

            for (int[] dir : dirs) {
                int nx = s.x + dir[0];
                int ny = s.y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int dist =
                        Math.max(d[s.x][s.y], moveTime[nx][ny]) +
                                ((s.x + s.y) % 2) +
                                1;
                if (d[nx][ny] > dist) {
                    d[nx][ny] = dist;
                    q.offer(new State(nx, ny, dist));
                }
            }
        }
        return d[n - 1][m - 1];
    }







        private static final long MOD = 1_000_000_007;
        private long[][][] memo;
        private int[] cnt;
        private int[] psum;
        private int target;
        private long[][] comb;

        public int countBalancedPermutations(String num) {
            int tot = 0, n = num.length();
            cnt = new int[10];
            for (char ch : num.toCharArray()) {
                int d = ch - '0';
                cnt[d]++;
                tot += d;
            }
            if (tot % 2 != 0) {
                return 0;
            }

            target = tot / 2;
            int maxOdd = (n + 1) / 2;

            /* Pre-calculate combinations */
            comb = new long[maxOdd + 1][maxOdd + 1];
            for (int i = 0; i <= maxOdd; i++) {
                comb[i][i] = comb[i][0] = 1;
                for (int j = 1; j < i; j++) {
                    comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
                }
            }

            psum = new int[11];
            for (int i = 9; i >= 0; i--) {
                psum[i] = psum[i + 1] + cnt[i];
            }

            memo = new long[10][target + 1][maxOdd + 1];
            for (long[][] arr2 : memo) {
                for (long[] arr1 : arr2) {
                    Arrays.fill(arr1, -1);
                }
            }

            return (int) dfs(0, 0, maxOdd);
        }

        private long dfs(int pos, int curr, int oddCnt) {
            /* If the remaining positions cannot be legally filled, or if the sum of the elements at the current odd positions is greater than the target value */
            if (oddCnt < 0 || psum[pos] < oddCnt || curr > target) {
                return 0;
            }
            if (pos > 9) {
                return curr == target && oddCnt == 0 ? 1 : 0;
            }
            if (memo[pos][curr][oddCnt] != -1) {
                return memo[pos][curr][oddCnt];
            }
            /* Even-numbered positions remaining to be filled */
            int evenCnt = psum[pos] - oddCnt;
            long res = 0;
            for (
                    int i = Math.max(0, cnt[pos] - evenCnt);
                    i <= Math.min(cnt[pos], oddCnt);
                    i++
            ) {
                /* The current digit is filled with i positions at odd positions, and cnt[pos] - i positions at even positions */
                long ways = (comb[oddCnt][i] * comb[evenCnt][cnt[pos] - i]) % MOD;
                res =
                        (res +
                                ((ways * dfs(pos + 1, curr + i * pos, oddCnt - i)) % MOD)) %
                                MOD;
            }
            memo[pos][curr][oddCnt] = res;
            return res;
        }





        // 2918. minimum equal sum of two arrays after replacing zeros
        public long minSum(int[] nums1, int[] nums2) {

          long sum1 = 0;
          long sum2 = 0;
          int numZeros1 = 0;
          int numZeroes2 = 0;

            for (int i = 0; i < nums1.length; i++) {

                sum1 += nums1[i];

                if (nums1[i] == 0) {
                    sum1++;
                    numZeros1++;
                }

            }

            for (int k = 0; k < nums2.length; k++) {


                sum2 += nums2[k];

                if (nums2[k] == 0) {
                    sum2++;
                    numZeroes2++;
                }

            }

            if ((numZeros1 == 0 && sum2 > sum1) || (numZeroes2 == 0 && sum1 > sum2)) {
                return -1;
            }


            return Math.max(sum1, sum2);
        }







        // 1550. three consecutive odds
        public boolean threeConsecutiveOdds(int[] arr) {

            for (int i = 0; i < arr.length - 2; i++) {

                if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                    return true;
                }
            }

            return false;

        }





        // 2094. finding 3-digit even numbers
        public int[] findEvenNumbers(int[] digits) {

            Set<Integer> nums = new HashSet<>();
            int n = digits.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    for (int k = 0; k < n; k++) {
                        if (i == j || j == k || i == k) {
                            continue;
                        }
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if (num >= 100 && num % 2 == 0) {
                            nums.add(num);
                        }
                    }

                }
            }

        List<Integer> result = new ArrayList<>(nums);
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }


        return answer;

        }





    private static final int newMOD = 1000000007;

    // 3335. total characters in string after transformations I
    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a'];
        }
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (int) ((cnt[25] + cnt[0]) % MOD);
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (int) ((ans + cnt[i]) % MOD);
        }
        return ans;
    }




    // 3337. Total characters in a string after transformations II
    // TODO review this one!!
        private static final int twoMOD = (int) 1e9 + 7;
        private static final int L = 26;

        private static class Mat {

            int[][] a = new int[L][L];

            Mat() {}

            Mat(Mat copyFrom) {
                for (int i = 0; i < L; i++) {
                    System.arraycopy(copyFrom.a[i], 0, this.a[i], 0, L);
                }
            }

            Mat mul(Mat other) {
                Mat result = new Mat();
                for (int i = 0; i < L; i++) {
                    for (int j = 0; j < L; j++) {
                        for (int k = 0; k < L; k++) {
                            result.a[i][j] = (int) ((result.a[i][j] +
                                    (long) this.a[i][k] * other.a[k][j]) %
                                    MOD);
                        }
                    }
                }
                return result;
            }
        }

        /* identity matrix */
        private Mat I() {
            Mat m = new Mat();
            for (int i = 0; i < L; i++) {
                m.a[i][i] = 1;
            }
            return m;
        }

        /* matrix exponentiation by squaring */
        private Mat quickmul(Mat x, int y) {
            Mat ans = I();
            Mat cur = new Mat(x);
            while (y > 0) {
                if ((y & 1) == 1) {
                    ans = ans.mul(cur);
                }
                cur = cur.mul(cur);
                y >>= 1;
            }
            return ans;
        }

        public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
            Mat T = new Mat();
            for (int i = 0; i < L; i++) {
                for (int j = 1; j <= nums.get(i); j++) {
                    T.a[(i + j) % L][i] = 1;
                }
            }

            Mat res = quickmul(T, t);
            int[] f = new int[L];
            for (char ch : s.toCharArray()) {
                f[ch - 'a']++;
            }
            int ans = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    ans = (int) ((ans + (long) res.a[i][j] * f[j]) % MOD);
                }
            }
            return ans;
        }






        // 2900. longest unequal adjacent groups subsequence I
    public List<String> getLongestSubsequence(String[] words, int[] groups) {

        List<String> answer = new ArrayList<>();

        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                answer.add(words[i]);
            }
        }
            return answer;
        }




        // 2901. longest unequal adjacent groups subsequence II
        public List<String> getWordsInLongestSubsequence(
                String[] words,
                int[] groups
        ) {
            int n = groups.length;
            int[] dp = new int[n];
            int[] prev = new int[n];
            Arrays.fill(dp, 1);
            Arrays.fill(prev, -1);
            int maxIndex = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (
                            check(words[i], words[j]) &&
                                    dp[j] + 1 > dp[i] &&
                                    groups[i] != groups[j]
                    ) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
                if (dp[i] > dp[maxIndex]) {
                    maxIndex = i;
                }
            }
            List<String> ans = new ArrayList<>();
            for (int i = maxIndex; i >= 0; i = prev[i]) {
                ans.add(words[i]);
            }
            Collections.reverse(ans);
            return ans;
        }

        private boolean check(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (++diff > 1) {
                        return false;
                    }
                }
            }
            return diff == 1;
        }





        // 75. sort colors
    public void sortColors(int[] nums) {

            int zero = 0, one = 0, two = 0;
            for (int n : nums) {
                if (n == 0) zero++;
                else if (n == 1) one++;
                else two++;
            }

            for (int i = 0; i < nums.length; i++) {
                if (zero > 0) {
                    nums[i] = 0;
                    zero--;
                } else if (one > 0) {
                    nums[i] = 1;
                    one--;
                } else {
                    nums[i] = 2;
                    two--;
                }
            }



    }





    // 1931. painting a grid with three different colors
    static final int mod = 1000000007;

        public int colorTheGrid(int m, int n) {
            // Hash mapping stores all valid coloration schemes for a single row that meet the requirements
            Map<Integer, List<Integer>> valid = new HashMap<>();
            // Enumerate masks that meet the requirements within the range [0, 3^m)
            int maskEnd = (int) Math.pow(3, m);
            for (int mask = 0; mask < maskEnd; ++mask) {
                List<Integer> color = new ArrayList<>();
                int mm = mask;
                for (int i = 0; i < m; ++i) {
                    color.add(mm % 3);
                    mm /= 3;
                }
                boolean check = true;
                for (int i = 0; i < m - 1; ++i) {
                    if (color.get(i).equals(color.get(i + 1))) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    valid.put(mask, color);
                }
            }

            // Preprocess all (mask1, mask2) binary tuples, satisfying mask1 and mask2 When adjacent rows, the colors of the two cells in the same column are different
            Map<Integer, List<Integer>> adjacent = new HashMap<>();
            for (int mask1 : valid.keySet()) {
                for (int mask2 : valid.keySet()) {
                    boolean check = true;
                    for (int i = 0; i < m; ++i) {
                        if (
                                valid.get(mask1).get(i).equals(valid.get(mask2).get(i))
                        ) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        adjacent
                                .computeIfAbsent(mask1, k -> new ArrayList<>())
                                .add(mask2);
                    }
                }
            }

            Map<Integer, Integer> f = new HashMap<>();
            for (int mask : valid.keySet()) {
                f.put(mask, 1);
            }
            for (int i = 1; i < n; ++i) {
                Map<Integer, Integer> g = new HashMap<>();
                for (int mask2 : valid.keySet()) {
                    for (int mask1 : adjacent.getOrDefault(
                            mask2,
                            new ArrayList<>()
                    )) {
                        g.put(
                                mask2,
                                (g.getOrDefault(mask2, 0) + f.getOrDefault(mask1, 0)) %
                                        mod
                        );
                    }
                }
                f = g;
            }

            int ans = 0;
            for (int num : f.values()) {
                ans = (ans + num) % mod;
            }
            return ans;
        }





    // 3024. type of triangle
    public String triangleType(int[] nums) {

        Arrays.sort(nums);

        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        } else if (nums[0] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }


    }



    // 3355. Zero Array Transformation I
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] deltaArray = new int[nums.length + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            deltaArray[left] += 1;
            deltaArray[right + 1] -= 1;
        }
        int[] operationCounts = new int[deltaArray.length];
        int currentOperations = 0;
        for (int i = 0; i < deltaArray.length; i++) {
            currentOperations += deltaArray[i];
            operationCounts[i] = currentOperations;
        }
        for (int i = 0; i < nums.length; i++) {
            if (operationCounts[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }



    // 73. set matrix zeros
    public void setZeroes(int[][] matrix) {

         Set<Integer> rows = new HashSet<>();
         Set<Integer> columns = new HashSet<>();

         for (int i = 0; i < matrix.length; i++) {
             for (int j = 0; j < matrix[0].length; j++) {

                 int currentValue = matrix[i][j];

                 if (currentValue == 0) {
                     rows.add(i);
                     columns.add(j);
                 }


             }
         }


        for (int i : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }


        for (int j : columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }


    }

























}
