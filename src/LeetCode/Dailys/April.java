package LeetCode.Dailys;


import java.util.*;

public class April {


    // 2140. solving questions with brainpower
    public long mostPoints(int[][] questions) {

        int n = questions.length;

        long[] result = new long[n];

        result[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            if (questions[i][1] + i + 1 >= n) {
                result[i] = Math.max(questions[i][0], result[i + 1]);
            } else {
                result[i] = Math.max(result[i + 1], questions[i][0] + result[i + 1 + questions[i][1]]);
            }
        }

        return result[0];

    }





    // 2873. maximum value of an ordered triplet
    public long maximumTripletValue(int[] nums) {

        int n = nums.length;
        long maximumVal = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long current = (long) (nums[i] - nums[j]) * nums[k];
                    maximumVal = Math.max(maximumVal, current);
                }
            }
        }
        return maximumVal;

    }



    // 2874. maximum value of an ordered triplet II
    public long maximumTripletValueTwo(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        long maximumVal = 0;


        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i - 1]);
            suffix[n - 1 - i] = Math.max(suffix[n - i], nums[n - i]);
        }

        for (int j = 1; j < n; j++) {
            maximumVal = Math.max(maximumVal, (long) (prefix[j] - nums[j]) * suffix[j]);
        }


        return maximumVal;

    }





    // 1123. lowest common ancestor of deepest leaves
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val) { this.val = val; };
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

//        public TreeNode lcaDeepestLeaves(TreeNode root) {
//            return dfs(root).getKey();
//        }
//
//
//
//        private Pair<TreeNode, Integer> dfs(TreeNode root)  {
//            if (root == null) {
//                return new Pair<> (null, 0);
//            }
//
//            Pair<TreeNode, Integer> left = dfs(root.left);
//            Pair<TreeNode, Integer> right = dfs(root.right);
//
//            if (left.getValue() > right.getValue()) {
//                return new Pair<>(left.getKey(), left.getValue() +1);
//            }
//            if (left.getValue() < right.getValue()) {
//                return new Pair<>(right.getKey(), right.getValue() + 1);
//            }
//            return new Pair<>(root, left.getValue() + 1);
//        }


    }




    // 1863. Sum of all subset XOR totals
    class Solution {
        public int subsetXORSum(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            // Generate all of the subsets
            generateSubsets(nums, 0, new ArrayList<>(), subsets);

            // Compute the XOR total for each subset and add to the result
            int result = 0;
            for (List<Integer> subset : subsets) {
                int subsetXORTotal = 0;
                for (int num : subset) {
                    subsetXORTotal ^= num;
                }
                result += subsetXORTotal;
            }
            return result;
        }

        private void generateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
            // Base case: index reached end of nums
            // Add the current subset to subsets
            if (index == nums.length) {
                subsets.add(new ArrayList<>(subset));
                return;
            }

            // Generate subsets with nums[i]
            subset.add(nums[index]);
            generateSubsets(nums, index + 1, subset, subsets);
            subset.remove(subset.size() - 1);

            // Generate subsets without nums[i]
            generateSubsets(nums, index + 1, subset, subsets);
        }
    }







    // 368. largest divisible subset
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxi = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxi]) maxi = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxi; i >= 0; i = prev[i]) {
            res.add(nums[i]);
        }
        return res;

    }






    // 300 longest increasing subsequence
    public int lengthOfLIS(int[] nums) {

            int[] dp = new int[nums.length];

            int size = 0;

            for (int x : nums) {
                int i = 0, j = size;

                while (i != j) {
                    int m = (i + j) / 2;
                    if (dp[m] < x) {
                        i = m + 1;
                    } else {
                        j = m;
                    }
                }
                dp[i] = x;
                if (i == size) {
                    size++;
                }
            }
            return size;
    }




    // 416. Partition equal subset sum
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int currSum = targetSum; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if (dp[targetSum]) return true;
            }
        }


        return dp[targetSum];


    }



    // 3396. Minimum number of operations to make elements in array distinct
    public int minimumOperations(int[] nums) {

        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        int minOps = 0;

        while (true) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int num : numList) {
                if (!seen.add(num)) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (!hasDuplicate) {
                break;
            }

            // Remove first 3 elements (or all remaining if less than 3)
            int removeCount = Math.min(3, numList.size());
            for (int i = 0; i < removeCount; i++) {
                numList.remove(0);
            }

            minOps++;
        }

        return minOps;
    }



    // 3375. minimum operations to make array values equal to k
    public int minOperations(int[] nums, int k) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                numSet.add(num);
            }
        }

        return numSet.size();


    }




        // 2999. count the number of powerful integers
        // TODO -> review this one!
        public long numberOfPowerfulInt(
                long start,
                long finish,
                int limit,
                String s
        ) {
            String low = Long.toString(start);
            String high = Long.toString(finish);
            int n = high.length();
            low = String.format("%" + n + "s", low).replace(' ', '0'); // align digits
            int pre_len = n - s.length(); // prefix length
            long[] memo = new long[n];
            Arrays.fill(memo, -1);

            return dfs(0, true, true, low, high, limit, s, pre_len, memo);
        }

        private long dfs(
                int i,
                boolean limit_low,
                boolean limit_high,
                String low,
                String high,
                int limit,
                String s,
                int pre_len,
                long[] memo
        ) {
            // recursive boundary
            if (i == low.length()) {
                return 1;
            }
            if (!limit_low && !limit_high && memo[i] != -1) {
                return memo[i];
            }

            int lo = limit_low ? low.charAt(i) - '0' : 0;
            int hi = limit_high ? high.charAt(i) - '0' : 9;
            long res = 0;
            if (i < pre_len) {
                for (int digit = lo; digit <= Math.min(hi, limit); digit++) {
                    res += dfs(
                            i + 1,
                            limit_low && digit == lo,
                            limit_high && digit == hi,
                            low,
                            high,
                            limit,
                            s,
                            pre_len,
                            memo
                    );
                }
            } else {
                int x = s.charAt(i - pre_len) - '0';
                if (lo <= x && x <= Math.min(hi, limit)) {
                    res = dfs(
                            i + 1,
                            limit_low && x == lo,
                            limit_high && x == hi,
                            low,
                            high,
                            limit,
                            s,
                            pre_len,
                            memo
                    );
                }
            }
            if (!limit_low && !limit_high) {
                memo[i] = res;
            }
            return res;
        }





        // 2843. count symmetric integers
        public int countSymmetricIntegers(int low, int high) {

            int res = 0;
            for (int a = low; a <= high; ++a) {
                if (a < 100 && a % 11 == 0) {
                    res++;
                } else if (1000 <= a && a < 10000) {
                    int left = a / 1000 + (a % 1000) / 100;
                    int right = (a % 100) / 10 + (a % 10);
                    if (left == right) {
                        res++;
                    }
                }
            }
            return res;
    }





    // 3272. find the count of good integers
    public long countGoodIntegers(int n, int k) {

        Set<String> dict = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n & 1;

        for (int i = base; i < base * 10; i++) {

            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);

            if (palindromicInteger % k == 0) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dict.add(new String(chars));
            }

        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        long answer = 0;
        for (String s : dict) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            long tot = (n - cnt[0]) * factorial[n - 1];
            for (int x : cnt) {
                tot /= factorial[x];
            }
            answer += tot;
        }
        return answer;
    }





    // 1922. count good numbers
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) ((quickmul(5, (n + 1) / 2) * quickmul(4, n / 2)) % mod);
    }

    // use fast exponentiation to calculate x^y % mod
    public long quickmul(int x, long y) {
        long ret = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                ret = (ret * mul) % mod;
            }
            mul = (mul * mul) % mod;
            y /= 2;
        }

        return ret;
    }




    // 1534. count good triplets
    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {

                    if (Math.abs(arr[i] - arr[j]) <= a) {
                        if (Math.abs(arr[j] - arr[k]) <= b) {
                            if (Math.abs(arr[i] - arr[k]) <= c) {
                                count++;
                            }
                        }
                    }


                }
            }
        }


        return count;




    }

    // class for FenwickTree
    class FenwickTree {

        private int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1];
        }

        public void update(int index, int delta) {
            index++;
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }

    }



    // 2179. Count good triplets in an array
    public long goodTriplets(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int[] pos2 = new int[n], reversedIndexMapping = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            reversedIndexMapping[pos2[nums1[i]]] = i;
        }
        FenwickTree tree = new FenwickTree(n);
        long res = 0;
        for (int value = 0; value < n; value++) {
            int pos = reversedIndexMapping[value];
            int left = tree.query(pos);
            tree.update(pos, 1);
            int right = (n - 1 - pos) - (value - left);
            res += (long) left * right;
        }

        return res;

    }



    // 2537. count the number of good subarrays
    public long countGood(int[] nums, int k) {

        int n = nums.length;
        int same = 0;
        int right = -1;

        Map<Integer, Integer> count = new HashMap<>();
        long answer = 0;

        for (int left = 0; left < n; left++) {
            while (same < k && right + 1 < n) {
                right++;
                same += count.getOrDefault(nums[right], 0);
                count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            }
            if (same >= k) {
                answer += n - right;
            }
            count.put(nums[left], count.get(nums[left]) - 1);
            same -= count.get(nums[left]);
        }
        return answer;
    }



    // 2176. count equal and divisible pairs in an array
    public int countPairs(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }

        return count;

    }





    // 38. count and say
    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);

        int c = 0;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            c++;
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                answer.append(c).append(s.charAt(i));
                c = 0;
            }
        }

        return answer.toString();

    }



    // 2563. count the number of fair pairs
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lowerBound(nums, upper + 1) - lowerBound(nums, lower);
    }

    private long lowerBound(int[] nums, int value) {

        int left = 0;
        int right = nums.length - 1;

        long result = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return result;
    }




    // 781. rabbits in forest
    public int numRabbits(int[] answers) {

        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int count = entry.getValue();
            int groupSize = k + 1;
            int groups = (count + k) / groupSize;
            total += groups * groupSize;
        }
        return total;
    }




    // 2145. count the hidden sequences
    public int numberOfArrays(int[] differences, int lower, int upper) {

        int x = 0;
        int y = 0;
        int curr = 0;

        for (int d : differences) {
            curr += d;

            x = Math.min(x, curr);
            y = Math.max(y, curr);
            if (y - x > upper - lower) {
                return 0;
            }
        }

        return (upper - lower) - (y - x) + 1;
    }




    // 2338. count the number of ideal arrays
    class IdealSolution {

        static int MOD = 1000000007;
        static int MAX_N = 10010;
        static int MAX_P = 15;
        static int[][] c = new int[MAX_N + MAX_P][MAX_P + 1];
        static int[] sieve = new int[MAX_N];
        static List<Integer>[] ps = new List[MAX_N];

        public IdealSolution() {

            if (c[0][0] == 1) {
                return;
            }

            for (int i = 0; i < MAX_N; i++) {
                ps[i] = new ArrayList<>();
            }

            for (int i = 2; i < MAX_N; i++) {
                if (sieve[i] == 0) {
                    for (int j = i; j < MAX_N; j += i) {
                        if (sieve[j] == 0) {
                            sieve[j] = i;
                        }
                    }
                }
            }

            for (int i = 2; i < MAX_N; i++) {
                int x = i;
                while (x > 1) {
                    int p = sieve[x], cnt = 0;
                    while (x % p == 0) {
                        x /= p;
                        cnt++;
                    }
                    ps[i].add(cnt);
                }
            }

            c[0][0] = 1;
            for (int i = 1; i < MAX_N + MAX_P; i++) {
                c[i][0] = 1;
                for (int j = 1; j <= Math.min(i, MAX_P); j++) {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
                }
            }


        }


        public int idealArrays(int n, int maxValue) {
            long answer = 0;
            for (int x = 1; x <= maxValue; x++) {
                long mul = 1;
                for (int p : ps[x]) {
                    mul = (mul * c[n + p - 1][p]) % MOD;
                }
                answer = (answer + mul) % MOD;
            }
            return (int) answer;
        }


    }



    // count largest group
    public int countLargestGroup(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            int key = 0;
            int x = i;
            while (x != 0) {
                key += x % 10;
                x /= 10;
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, map.get(key));
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> curr : map.entrySet()) {
            if (curr.getValue() == maxValue) {
                count++;
            }
        }


        return count;


    }




    // 2799. Count complete subarrays in an array
    public int countComplete(int[] nums) {

        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        int right = 0;
        int distinct = new HashSet<>(
                Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))
        ).size();

        for (int left = 0; left < n; left++) {
            if (left > 0) {
                int remove = nums[left - 1];
                count.put(remove, count.get(remove) - 1);
                if (count.get(remove) == 0) {
                    count.remove(remove);
                }
            }
            while (right < n && count.size() < distinct) {
                int add = nums[right];
                count.put(add, count.getOrDefault(add, 0) + 1);
                right++;
            }
            if (count.size() == distinct) {
                result += (n - right + 1);
            }
        }
        return result;
    }



    // 2845. count of interesting subarrays
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

        int n = nums.size();
        Map<Integer, Integer> count = new HashMap<>();
        long result = 0;
        int prefix = 0;
        count.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            result += count.getOrDefault((prefix - k + modulo) % modulo, 0);
            count.put(prefix % modulo, count.getOrDefault(prefix % modulo, 0) + 1);
        }
        return result;
    }







        // 2444. count subarrays with fixed bounds
        public long countSubarrays(int[] nums, int minK, int maxK) {

            long count = 0;
            int start = -1, mini = -1, maxi = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < minK || nums[i] > maxK) start = i;
                if (nums[i] == maxK) maxi = i;
                if (nums[i] == minK) mini = i;
                int valid = Math.max(0, Math.min(mini, maxi) - start);
                count += valid;
            }
            return count;
        }





        // 3392. count subarrays of length three with a condition
        public int countSubarrays(int[] nums) {
            int count = 0;

            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                    count++;
                }
            }
            return count;
        }




    // 2302. count subarrays with score less than k
    public long countSubarrays(int[] nums, long k) {

        int n = nums.length;
        long result = 0;
        long total = 0;

        for (int i = 0, j = 0; j < n; j++) {
            total += nums[j];
            while (i <= j && total * (j - i + 1) >= k) {
                total -= nums[i];
                i++;
            }
            result += j - i + 1;
        }
        return result;
    }




    // 2962. count subarrays where max element appears at least k times
    public long countSubarrraysKTimes(int[] nums, int k) {

        int maximum = Arrays.stream(nums).max().getAsInt();

        long answer = 0;
        long start = 0;

        int maxElementsInWindow = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maximum) {
                maxElementsInWindow++;
            }
            while (maxElementsInWindow == k) {
                if (nums[(int) start] == maximum) {
                    maxElementsInWindow--;
                }
                start++;
            }
            answer += start;
        }

        return answer;

    }




    // 1295. find numbers with even number of digits
    public int findNumbers(int[] nums) {

        int result = 0;

        for (int num : nums) {

            String digits = Integer.toString(num);

            if (digits.length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }















}
