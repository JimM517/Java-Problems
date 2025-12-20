package LeetCode.Dailys;

import java.util.*;

public class December {



    // 2141. maximum running time of N computers
    public long maxRunTime(int n, int[] batteries) {

        long sumPower = 0;
        for (int power : batteries) {
            sumPower += power;
        }

        long left = 1, right = sumPower / n;

        while (left < right){
            long target = right - (right - left) / 2;
            long extra = 0;

            for (int power : batteries)
                extra += Math.min(power, target);

            if (extra >= (long)(n * target))
                left = target;
            else
                right = target - 1;
        }
        return left;
    }






    // 3623. count number of trapezoids I
    public int countTrapezoids(int[][] points) {

        Map<Integer, Integer> pointNum = new HashMap<>();
        final int MOD = 1000000007;

        long answer = 0;
        long sum = 0;

        for (int[] point : points) {
            pointNum.put(point[1], pointNum.getOrDefault(point[1], 0) + 1);
        }
        for (int pNum : pointNum.values()) {
            long edge = ((long) pNum * (pNum - 1)) / 2;
            answer = (answer + edge * sum) % MOD;
            sum = (sum + edge) % MOD;
        }

        return (int) answer;

    }



    // 3625. count number of trapezoids II
    public int countTrapezoidsTwo(int[][] points) {

        int n = points.length;
        double inf = 1e9 + 7;

        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();
        Map<Integer, List<Double>> midToSlope = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x1 - x2;
                int dy = y1 - y2;
                double k;
                double b;

                if (x2 == x1) {
                    k = inf;
                    b = x1;
                } else {
                    k = (1.0 * (y2 - y1)) / (x2 - x1);
                    b = (1.0 * (y1 * dx - x1 * dy)) / dx;
                }
                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }
                int mid = (x1 + x2) * 10000 + (y1 + y2);
                slopeToIntercept
                        .computeIfAbsent(k, key -> new ArrayList<>())
                        .add(b);
                midToSlope
                        .computeIfAbsent(mid, key -> new ArrayList<>())
                        .add(k);
            }
        }

        for (List<Double> sti : slopeToIntercept.values()) {
            if (sti.size() == 1) {
                continue;
            }
            Map<Double, Integer> cnt = new TreeMap<>();
            for (double b : sti) {
                cnt.put(b, cnt.getOrDefault(b, 0) + 1);
            }
            int sum = 0;
            for (int count : cnt.values()) {
                ans += sum * count;
                sum += count;
            }
        }

        for (List<Double> mts : midToSlope.values()) {
            if (mts.size() == 1) {
                continue;
            }
            Map<Double, Integer> cnt = new TreeMap<>();
            for (double k : mts) {
                cnt.put(k, cnt.getOrDefault(k, 0) + 1);
            }
            int sum = 0;
            for (int count : cnt.values()) {
                ans -= sum * count;
                sum += count;
            }
        }

        return ans;


    }





    // 2211. count collisions on a road
    public int countCollisions(String directions) {


        int n = directions.length();
        int l = 0;
        int r = n - 1;

        while (l < n && directions.charAt(l) == 'L') {
            l++;
        }

        while (r >= l && directions.charAt(r) == 'R') {
            r--;
        }

        int res = 0;
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                res++;
            }
        }
        return res;


    }






    // 3432. count partitions with even sum difference
    public int countPartitions(int[] nums) {

        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total % 2 == 0 ? nums.length - 1 : 0;
    }







    // count partitions with man-min difference at most k
    public int countPartitions(int[] nums, int k) {

        int n = nums.length;
        long mod = (long) 1e9 + 7;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        dp[0] = 1;
        prefix[0] = 1;

        for (int i = 0, j = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);

            while (j <= i && cnt.lastKey() - cnt.firstKey() > k) {
                cnt.put(nums[j], cnt.get(nums[j]) - 1);
                if (cnt.get(nums[j]) == 0) {
                    cnt.remove(nums[j]);
                }
                j++;
            }
            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i]+ dp[i + 1]) % mod;
        }
        return (int) dp[n];
    }







    // 1523. count odd numbers in an interval range
    public int countOdds(int low, int high) {
        int n = high - low + 1;
        int totalOdds = 0;
        if (n % 2 == 0) {
            totalOdds = n / 2;
        }
        if (n % 2 == 1) {
            if (low % 2 == 1 || high % 2 == 1) {
                totalOdds = (n / 2) + 1;
            } else {
                totalOdds = n / 2;
            }
        }
        return totalOdds;
    }





// 1925. count square sum triples
    public int countTriples(int n) {
        int res = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c = (int) Math.sqrt(a * a + b * b + 1.0);
                if (c <= n && c * c == a * a + b * b) {
                    res++;
                }
            }
        }
        return res;
    }


// 3583. count special triplets
    public int specialTriplets(int[] nums) {

        final int MOD = 1000000007;
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numPartialCnt = new HashMap<>();

        for (int v : nums) {
            numCnt.put(v, numCnt.getOrDefault(v, 0) + 1);
        }

        long answer = 0;
        for (int v : nums) {
            int target = v * 2;
            int lCnt = numPartialCnt.getOrDefault(target, 0);
            numPartialCnt.put(v, numPartialCnt.getOrDefault(v, 0) + 1);
            int rCnt = numCnt.getOrDefault(target, 0) -
                    numPartialCnt.getOrDefault(target, 0);
            answer = (answer + (long) lCnt * rCnt) % MOD;
        }


        return (int) answer;

    }





    // 3577. count the number of computer unlocking permutations
    public int countPermutations(int[] complexity) {

        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }


        int answer = 1;
        int mod = 1000000007;
        for (int i = 2; i < n; i++) {
            answer = (int) (((long) answer * i) % mod);
        }
        return answer;
    }




    // 3531. count covered buildings
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];

        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);

        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];

            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);
            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }

        int res = 0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];

            if (
                    x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]
            ) {
                res++;
            }
        }

        return res;


    }




 // 3433. count the mentions per user
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });

        int[] count = new int[numberOfUsers];
        int[] nextOnlineTime = new int[numberOfUsers];

        for (List<String> event : events) {
            int curTime = Integer.parseInt(event.get(1));
            String type = event.get(0);

            if (type.equals("MESSAGE")) {
                String target = event.get(2);
                if (target.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        count[i]++;
                    }
                } else if (target.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (nextOnlineTime[i] <= curTime) {
                            count[i]++;
                        }
                    }
                } else {
                    String[] users = target.split(" ");
                    for (String user : users) {
                        int idx = Integer.parseInt(user.substring(2));
                        count[idx]++;
                    }
                }
            } else {
                int idx = Integer.parseInt(event.get(2));
                nextOnlineTime[idx] = curTime + 60;
            }
        }

        return count;



    }





// 3606. coupon code validator
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<int[]> validIndexes = new ArrayList<>();
        List<String> result = new ArrayList<>();

        String regex = "^[A-Za-z0-9_]+$";

        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);


        for (int i = 0; i < code.length; i++) {
            if (code[i] != null && code[i].matches(regex) && priority.containsKey(businessLine[i]) && isActive[i]) {
                validIndexes.add(new int[]{i});
            }
        }


        validIndexes.sort((a, b) -> {
            int p1 = priority.get(businessLine[a[0]]);
            int p2 = priority.get(businessLine[b[0]]);

            if (p1 != p2) {
                return Integer.compare(p1, p2);
            }
            return code[a[0]].compareTo(code[b[0]]);
        });

        for (int[] idx : validIndexes) {
            result.add(code[idx[0]]);
        }

        return result;
    }






    // 2147. number of ways to divide a long corridor
    public int numberOfWays(String corridor) {

        final int MOD = 1_000_000_007;

        // Initial values of three variables
        int zero = 0;
        int one = 0;
        int two = 1;

        // Compute using derived equations
        for (char thing : corridor.toCharArray()) {
            if (thing == 'S') {
                zero = one;
                int temp = one;
                one = two;
                two = temp;
            } else {
                two = (two + zero) % MOD;
            }
        }

        // Return the result
        return zero;


    }




    // 2110 number of smooth descent periods of a stock
    public long getDescentPeriods(int[] prices) {


        int n = prices.length;
        long res = 1; // total number of smooth descending periods, initial value is dp[0]
        int prev = 1; // total number of smooth descending periods ending with the previous element, initial value is dp[0]
        // traverse the array starting from 1, and update prev and the total res according to the recurrence relation
        for (int i = 1; i < n; ++i) {
            if (prices[i] == prices[i - 1] - 1) {
                ++prev;
            } else {
                prev = 1;
            }
            res += prev;
        }
        return res;




    }





// 3562. Maximum profit from trading stocks with discounts
class Result {

    int[] dp0;
    int[] dp1;
    int size;

    Result(int[] dp0, int[] dp1, int size) {
        this.dp0 = dp0;
        this.dp1 = dp1;
        this.size = size;
    }
}



        public int maxProfit(
                int n,
                int[] present,
                int[] future,
                int[][] hierarchy,
                int budget
        ) {
            List<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] e : hierarchy) {
                g[e[0] - 1].add(e[1] - 1);
            }

            return dfs(0, present, future, g, budget).dp0[budget];
        }

        private Result dfs(
                int u,
                int[] present,
                int[] future,
                List<Integer>[] g,
                int budget
        ) {
            int cost = present[u];
            int dCost = present[u] / 2;
            // dp[u][state][budget]
            // state = 0: Do not purchase parent node, state = 1: Must purchase parent node
            int[] dp0 = new int[budget + 1];
            int[] dp1 = new int[budget + 1];

            // subProfit[state][budget]
            // state = 0: discount not available, state = 1: discount available
            int[] subProfit0 = new int[budget + 1];
            int[] subProfit1 = new int[budget + 1];
            int uSize = cost;

            for (int v : g[u]) {
                Result childResult = dfs(v, present, future, g, budget);
                uSize += childResult.size;

                for (int i = budget; i >= 0; i--) {
                    for (int sub = 0; sub <= Math.min(childResult.size, i); sub++) {
                        if (i - sub >= 0) {
                            subProfit0[i] = Math.max(
                                    subProfit0[i],
                                    subProfit0[i - sub] + childResult.dp0[sub]
                            );
                            subProfit1[i] = Math.max(
                                    subProfit1[i],
                                    subProfit1[i - sub] + childResult.dp1[sub]
                            );
                        }
                    }
                }
            }

            for (int i = 0; i <= budget; i++) {
                dp0[i] = subProfit0[i];
                dp1[i] = subProfit0[i];
                if (i >= dCost) {
                    dp1[i] = Math.max(
                            subProfit0[i],
                            subProfit1[i - dCost] + future[u] - dCost
                    );
                }
                if (i >= cost) {
                    dp0[i] = Math.max(
                            subProfit0[i],
                            subProfit1[i - cost] + future[u] - cost
                    );
                }
            }

            return new Result(dp0, dp1, uSize);
        }




        // 3573. best time to buy and sell stock V
    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;
        long[][] dp = new long[k + 1][3];
        // initialize the state on day 0
        for (int j = 1; j <= k; j++) {
            dp[j][1] = -prices[0];
            dp[j][2] = prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(
                        dp[j][0],
                        Math.max(dp[j][1] + prices[i], dp[j][2] - prices[i])
                );
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                dp[j][2] = Math.max(dp[j][2], dp[j - 1][0] + prices[i]);
            }
        }

        return dp[k][0];

    }




    // 3652. best time to buy and sell stock using strategy
    public long maxProfit(int[] prices, int[] strategy, int k) {


        int n = prices.length;
        long[] profitSum = new long[n + 1];
        long[] priceSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            profitSum[i + 1] = profitSum[i] + (long) prices[i] * strategy[i];
            priceSum[i + 1] = priceSum[i] + prices[i];
        }
        long res = profitSum[n];
        for (int i = k - 1; i < n; i++) {
            long leftProfit = profitSum[i - k + 1];
            long rightProfit = profitSum[n] - profitSum[i + 1];
            long changeProfit = priceSum[i + 1] - priceSum[i - k / 2 + 1];
            res = Math.max(res, leftProfit + changeProfit + rightProfit);
        }
        return res;
    }




    // 2092. find all people with secret
    public List<Integer> findAllPeople(
                int n,
                int[][] meetings,
                int firstPerson
        ) {
            // For every person, we store the meeting time and label of the person met.
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] meeting : meetings) {
                int x = meeting[0], y = meeting[1], t = meeting[2];
                graph
                        .computeIfAbsent(x, k -> new ArrayList<>())
                        .add(new int[] { t, y });
                graph
                        .computeIfAbsent(y, k -> new ArrayList<>())
                        .add(new int[] { t, x });
            }

            // Priority Queue for BFS. It will store (time of knowing the secret, person)
            // We will pop the person with the minimum time of knowing the secret.
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.offer(new int[] { 0, 0 });
            pq.offer(new int[] { 0, firstPerson });

            // Visited array to mark if a person is visited or not.
            // We will mark a person as visited after it is dequeued
            // from the queue.
            boolean[] visited = new boolean[n];

            // Do BFS, but pop minimum.
            while (!pq.isEmpty()) {
                int[] timePerson = pq.poll();
                int time = timePerson[0], person = timePerson[1];
                if (visited[person]) {
                    continue;
                }
                visited[person] = true;
                for (int[] nextPersonTime : graph.getOrDefault(
                        person,
                        new ArrayList<>()
                )) {
                    int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                    if (!visited[nextPerson] && t >= time) {
                        pq.offer(new int[] { t, nextPerson });
                    }
                }
            }

            // Since we visited only those people who know the secret
            // we need to return indices of all visited people.
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (visited[i]) {
                    ans.add(i);
                }
            }
            return ans;
        }




        // delete columns to make sorted
    public int minDeletionSize(String[] strs) {

        int n = strs.length;
        int m = strs[0].length();

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;

    }



















































































































































}
