package LeetCode.Dailys.TwoSix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class January {


    // plus one
    public int[] plusOne(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;


    }






    // 961. N-repeated element in size 2N array
    public int repeatedNTimes(int[] nums) {

        int len = nums.length;

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int key = 0;
        for (Map.Entry<Integer, Integer> map : count.entrySet()) {

            int val = map.getValue();
            if (len == (2 * val) && count.size() == val + 1) {
                key = map.getKey();
            }


        }
        return key;


    }






    // 1411. number of ways to paint a N X 3 grid
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long A = 6, B = 6;

        for (int i = 2; i <= n; i++) {
            long newA = (2 * A + 2 * B) % MOD;
            long newB = (2 * A + 3 * B) % MOD;
            A = newA;
            B = newB;
        }

        return (int) ((A + B) % MOD);
    }






    // 1390. four divisors
    public int sumFourDivisors(int[] nums) {

        int totalSum = 0;

        for (int n : nums) {
            int sum = 0;
            int count = 0;

            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    int other = n / d;

                    sum += d;
                    count++;

                    if (other != d) {
                        sum += other;
                        count++;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }




    // 1975. maximum matrix sum
    public long maxMatrixSum(int[][] matrix) {

        long totalSum = 0;
        int minAbsVal = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += Math.abs(val);
                if (val < 0) {
                    negativeCount--;
                }
                minAbsVal = Math.min(minAbsVal, Math.abs(val));
            }
        }

        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsVal;
        }

        return totalSum;
    }




// 1161. maximum level sum of a binary tree
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
}

public int maxLevelSum(TreeNode root) {

    int maxSum = Integer.MIN_VALUE;
    int answer = 0;
    int level = 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        level++;
        int sumAtCurrentLevel = 0;

        for (int sz = q.size(); sz > 0; sz--) {
            TreeNode node = q.poll();
            sumAtCurrentLevel += node.val;

            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        if (maxSum < sumAtCurrentLevel) {
            maxSum = sumAtCurrentLevel;
            answer = level;
        }
    }

        return answer;


}




// 1339. maximum product of splitted binary tree
    private long total = 0;
    private long best = 0;
    private static final int MOD = 1_000_000_007;

    public long sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    public long dfs(TreeNode node) {
        if (node == null) return 0;
        long s = node.val + dfs(node.left) + dfs(node.right);
        best = Math.max(best, s * (total - s));
        return s;
    }

    public int maxProduct(TreeNode root) {

        total = sum(root);
        dfs(root);

        return (int) (best % MOD);



    }







    // 1458. max dot product of two subsequences
    public int maxDotProduct(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int NEG = (int)-1e9;

        int[][] dp = new int[n + 1][m + 1];

        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
                dp[i][j] = NEG;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take = nums1[i-1]*nums2[j-1] + Math.max(0, dp[i-1][j-1]);
                dp[i][j] = Math.max(take, Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }

        return dp[n][m];


    }


    // 865 smallest subtree with all deepest nodes
        Map<TreeNode, Integer> depth;
        int max_depth;
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            depth = new HashMap();
            depth.put(null, -1);
            dfs(root, null);
            max_depth = -1;
            for (Integer d: depth.values())
                max_depth = Math.max(max_depth, d);

            return answer(root);
        }

        public void dfs(TreeNode node, TreeNode parent) {
            if (node != null) {
                depth.put(node, depth.get(parent) + 1);
                dfs(node.left, node);
                dfs(node.right, node);
            }
        }

        public TreeNode answer(TreeNode node) {
            if (node == null || depth.get(node) == max_depth)
                return node;
            TreeNode L = answer(node.left),
                    R = answer(node.right);
            if (L != null && R != null) return node;
            if (L != null) return L;
            if (R != null) return R;
            return null;
        }























































































}
