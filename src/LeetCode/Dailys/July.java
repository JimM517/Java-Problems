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



        // 3440 reschedule meetings for maximum free time II
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
                int n = startTime.length;
                boolean[] q = new boolean[n];
                for (int i = 0, t1 = 0, t2 = 0; i < n; i++) {
                    if (endTime[i] - startTime[i] <= t1) {
                        q[i] = true;
                    }
                    t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));

                    if (endTime[n - i - 1] - startTime[n - i - 1] <= t2) {
                        q[n - i - 1] = true;
                    }
                    t2 = Math.max(
                            t2,
                            (i == 0 ? eventTime : startTime[n - i]) - endTime[n - i - 1]
                    );
                }

                int res = 0;
                for (int i = 0; i < n; i++) {
                    int left = i == 0 ? 0 : endTime[i - 1];
                    int right = i == n - 1 ? eventTime : startTime[i + 1];
                    if (q[i]) {
                        res = Math.max(res, right - left);
                    } else {
                        res = Math.max(res, right - left - (endTime[i] - startTime[i]));
                    }
                }
                return res;
            }





         // 2402. meeting rooms II
        public int mostBooked(int n, int[][] meetings) {
            long[] roomAvailabilityTime = new long[n];
            int[] meetingCount = new int[n];
            Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

            for (int[] meeting : meetings) {
                int start = meeting[0], end = meeting[1];
                long minRoomAvailabilityTime = Long.MAX_VALUE;
                int minAvailableTimeRoom = 0;
                boolean foundUnusedRoom = false;

                for (int i = 0; i < n; i++) {
                    if (roomAvailabilityTime[i] <= start) {
                        foundUnusedRoom = true;
                        meetingCount[i]++;
                        roomAvailabilityTime[i] = end;
                        break;
                    }

                    if (minRoomAvailabilityTime > roomAvailabilityTime[i]) {
                        minRoomAvailabilityTime = roomAvailabilityTime[i];
                        minAvailableTimeRoom = i;
                    }
                }

                if (!foundUnusedRoom) {
                    roomAvailabilityTime[minAvailableTimeRoom] += end - start;
                    meetingCount[minAvailableTimeRoom]++;
                }
            }

            int maxMeetingCount = 0, maxMeetingCountRoom = 0;
            for (int i = 0; i < n; i++) {
                if (meetingCount[i] > maxMeetingCount) {
                    maxMeetingCount = meetingCount[i];
                    maxMeetingCountRoom = i;
                }
            }

            return maxMeetingCountRoom;
        }





    // 1900. the earliest and latest rounds where players compete

        private int[][][] F = new int[30][30][30];
        private int[][][] G = new int[30][30][30];

        private int[] dp(int n, int f, int s) {
            if (F[n][f][s] != 0) {
                return new int[] { F[n][f][s], G[n][f][s] };
            }
            if (f + s == n + 1) {
                return new int[] { 1, 1 };
            }
            // F(n,f,s) = F(n, n + 1 - s, n + 1 - f)
            if (f + s > n + 1) {
                int[] res = dp(n, n + 1 - s, n + 1 - f);
                F[n][f][s] = res[0];
                G[n][f][s] = res[1];
                return new int[] { F[n][f][s], G[n][f][s] };
            }

            int earliest = Integer.MAX_VALUE;
            int latest = Integer.MIN_VALUE;
            int n_half = (n + 1) / 2;
            if (s <= n_half) {
                // On the left or in the middle
                for (int i = 0; i < f; ++i) {
                    for (int j = 0; j < s - f; ++j) {
                        int[] res = dp(n_half, i + 1, i + j + 2);
                        earliest = Math.min(earliest, res[0]);
                        latest = Math.max(latest, res[1]);
                    }
                }
            } else {
                // s on the right
                int s_prime = n + 1 - s;
                int mid = (n - 2 * s_prime + 1) / 2;
                for (int i = 0; i < f; ++i) {
                    for (int j = 0; j < s_prime - f; ++j) {
                        int[] res = dp(n_half, i + 1, i + j + mid + 2);
                        earliest = Math.min(earliest, res[0]);
                        latest = Math.max(latest, res[1]);
                    }
                }
            }

            F[n][f][s] = earliest + 1;
            G[n][f][s] = latest + 1;
            return new int[] { F[n][f][s], G[n][f][s] };
        }

        public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            // F(n,f,s) = F(n,s,f)
            if (firstPlayer > secondPlayer) {
                int temp = firstPlayer;
                firstPlayer = secondPlayer;
                secondPlayer = temp;
            }

            int[] res = dp(n, firstPlayer, secondPlayer);
            return new int[] { res[0], res[1] };
        }






        // 2410. maximum matching players with trainers
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {


        Arrays.sort(players);
        Arrays.sort(trainers);

        int m = players.length;
        int n = trainers.length;

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
            return count;

        }


        public class ListNode {
            int val;
            ListNode next;
            ListNode() {};
            ListNode(int val) {
                this.val = val;
            }
            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }



        // 1290. convert binary number in a linked list to integer
    public int getDecimalValue(ListNode head) {


        ListNode dummy = head;
        int result = 0;

        while (dummy != null) {


           result = result * 2 + dummy.val;
           dummy = dummy.next;


        }

        return result;

    }




    // 3136. valid word
    public boolean isValid(String word) {

        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (
                        ch == 'a' ||
                                ch == 'e' ||
                                ch == 'i' ||
                                ch == 'o' ||
                                ch == 'u'
                ) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return hasVowel && hasConsonant;


    }





    // 3201. find the maximum length of valid subsequence I
    public int maximumLength(int[] nums) {

            int result = 0;
            int[][] patterns = { {0, 0}, {0, 1}, {1, 0}, {1, 1}};
            for (int[] pattern : patterns) {
                int count = 0;
                for (int num : nums) {
                    if (num % 2 == pattern[count % 2]) {
                        count++;
                    }
                }
                result = Math.max(result, count);
            }


            return result;

    }




    // 3202. find the maximum length of a valid subsequence II
    public int maximumLengthTwo(int[] nums, int k) {

        int[][] dp = new int[k][k];
        int result = 0;

        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                result = Math.max(result, dp[prev][num]);
            }
        }


            return result;


    }



    // 2163. minimum difference in sums after removal of element
    public long minimumDifference(int[] nums) {
            int n3 = nums.length;
            int n = n3 / 3;
            long[] part1 = new long[n + 1];
            long sum = 0;
            // max heap (simulate with opposite numbers)
            PriorityQueue<Integer> ql = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < n; ++i) {
                sum += nums[i];
                ql.add(nums[i]);
            }
            part1[0] = sum;
            for (int i = n; i < n * 2; ++i) {
                sum += nums[i];
                ql.add(nums[i]);
                sum -= ql.poll();
                part1[i - (n - 1)] = sum;
            }

            long part2 = 0;
            // min heap
            PriorityQueue<Integer> qr = new PriorityQueue<>();
            for (int i = n * 3 - 1; i >= n * 2; --i) {
                part2 += nums[i];
                qr.add(nums[i]);
            }
            long ans = part1[n] - part2;
            for (int i = n * 2 - 1; i >= n; --i) {
                part2 += nums[i];
                qr.add(nums[i]);
                part2 -= qr.poll();
                ans = Math.min(ans, part1[i - n] - part2);
            }
            return ans;
        }





















}
