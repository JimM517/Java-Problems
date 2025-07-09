package LeetCode.Dailys;

import java.util.*;

public class July {



    // 3330. find the original typed string I
    public int possibleStringCount(String word) {


        int result = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                result++;
            }
        }

        return result;
    }










    // 3333. find the original typed string II
    private static final int mod = 1000000007;
    public int possibleStringCount(String word, int k) {
            int n = word.length();
            int cnt = 1;
            List<Integer> freq = new ArrayList<>();
            for (int i = 1; i < n; ++i) {
                if (word.charAt(i) == word.charAt(i - 1)) {
                    ++cnt;
                } else {
                    freq.add(cnt);
                    cnt = 1;
                }
            }
            freq.add(cnt);

            long ans = 1;
            for (int o : freq) {
                ans = (ans * o) % mod;
            }
            if (freq.size() >= k) {
                return (int) ans;
            }

            int[] f = new int[k];
            int[] g = new int[k];
            f[0] = 1;
            Arrays.fill(g, 1);
            for (int i = 0; i < freq.size(); ++i) {
                int[] f_new = new int[k];
                for (int j = 1; j < k; ++j) {
                    f_new[j] = g[j - 1];
                    if (j - freq.get(i) - 1 >= 0) {
                        f_new[j] = (f_new[j] - g[j - freq.get(i) - 1] + mod) % mod;
                    }
                }
                int[] g_new = new int[k];
                g_new[0] = f_new[0];
                for (int j = 1; j < k; ++j) {
                    g_new[j] = (g_new[j - 1] + f_new[j]) % mod;
                }
                f = f_new;
                g = g_new;
            }

            return (int) ((ans - g[k - 1] + mod) % mod);
        }






    // 3304. find the kth character in string game I
    public char kthCharacter(int k) {

        int answer = 0;
        int t;

        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            answer++;
        }


        return (char) ('a' + answer);
    }




    // 3307. find the kth character in string game II
    public char kthCharacter(long k, int[] operations) {

        int answer = 0;
        int t;

        while (k != 1) {
            t = 63 - Long.numberOfLeadingZeros(k);
            if ((1L << t) == k) {
                t--;
            }
            k = k - (1L << t);
            if (operations[t] != 0) {
                answer++;
            }

        }

        return (char) ('a' + (answer % 26));
    }




    // 1394. find the lucky integer in an array
    public int findLucky(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        int max = -1;

        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                max = Math.max(max, key);
            }
        }
        return max;
    }





    // 1865. finding pairs with a certain sum
    class FindSumPairs {

        private int[] nums1;
        private int[] nums2;
        private Map<Integer, Integer> count;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.count = new HashMap<>();
            for (int num : nums2) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int oldVal = nums2[index];
            count.put(oldVal, count.get(oldVal) - 1);
            nums2[index] += val;
            count.put(nums2[index], count.getOrDefault(nums2[index], 0) + 1);
        }

        public int count(int tot) {

            int answer = 0;
            for (int num : nums1) {
                int rest = tot - num;
                answer += count.getOrDefault(rest, 0);
            }
            return answer;
        }



    }




    // 1353. maximum number of events that can be attended
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, i = 0, res = 0;
        int n = events.length;

        // Find the maximum end day
        int maxDay = 0;
        for (int[] e : events) {
            maxDay = Math.max(maxDay, e[1]);
        }

        for (day = 1; day <= maxDay; day++) {
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }

        return res;
    }



    // maximum number of events that can be attended II
        public int maxValue(int[][] events, int k) {
            Arrays.sort(events, (a, b) -> a[0] - b[0]);
            int n = events.length;

            dp = new int[k + 1][n];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return dfs(0, k, events);
        }

        private int[][] dp;
        private int dfs(int curIndex, int count, int[][] events) {
            if (count == 0 || curIndex == events.length) {
                return 0;
            }
            if (dp[count][curIndex] != -1) {
                return dp[count][curIndex];
            }
            int nextIndex = bisectRight(events, events[curIndex][1]);
            dp[count][curIndex] = Math.max(dfs(curIndex + 1, count, events), events[curIndex][2] + dfs(nextIndex, count - 1, events));
            return dp[count][curIndex];
        }

        public static int bisectRight(int[][] events, int target) {
            int left = 0, right = events.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (events[mid][0] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }




    // 3439. reschedule meetings for maximum free time I
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

            int n = startTime.length;
            int res = 0;
            int t = 0;

            for (int i = 0; i < n; i++) {
                t += endTime[i] - startTime[i];
                int left = i <= k - 1 ? 0 : endTime[i - k];
                int right = i == n - 1 ? eventTime : startTime[i + 1];
                res = Math.max(res, right - left - t);
                if (i >= k - 1) {
                    t -= endTime[i - k + 1] - startTime[i - k + 1];
                }

            }
            return res;
        }




















































}
