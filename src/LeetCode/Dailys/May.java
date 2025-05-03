package LeetCode.Dailys;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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











}
