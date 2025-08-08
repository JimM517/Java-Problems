package LeetCode.Dailys;

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











































}
