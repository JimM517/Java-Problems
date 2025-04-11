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













































































}
