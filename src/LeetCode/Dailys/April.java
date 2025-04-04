package LeetCode.Dailys;


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





































































































}
