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

















}
