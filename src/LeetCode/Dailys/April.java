package LeetCode.Dailys;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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































































































}
