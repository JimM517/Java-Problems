package TreeProbs;

import java.util.LinkedList;
import java.util.Queue;

public class Trees {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {};

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }







    // 226 Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();
                invert(temp);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }

        return root;

    }



    private static void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }



    // 98 Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {

            return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long min, long max) {
        // if root is null then its valid
        if (root == null) {
            return true;
        }

        // if root is less than min value or greater than max value return false
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // check on both sides if both are true then only its valid
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);


    }






    // 108. Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }


        int n = nums.length;
        int mid = n / 2;

        TreeNode root = new TreeNode(nums[mid]);


        Queue<Object[]> q = new LinkedList<>();

        q.add(new Object[]{ root, new int[]{0, mid - 1} });

        q.add(new Object[]{ root, new int[]{mid + 1, n - 1} });


        while(!q.isEmpty()) {

            Object[] curr = q.poll();


            TreeNode parent = (TreeNode)curr[0];
            int[] indices = (int[])curr[1];
            int left = indices[0];
            int right = indices[1];



            if (left <= right && parent != null) {
                mid = (left + right) / 2;
                TreeNode child = new TreeNode(nums[mid]);

                if (nums[mid] < parent.val) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }


                q.add(new Object[]{child, new int[]{left, mid - 1}});
                q.add(new Object[]{child, new int[]{mid + 1, right}});



            }



        }

        return root;

    }






    // 988 Smallest string starting from leaf
    public String smallestFromLeaf(TreeNode root) {

        dfs(root, new StringBuilder());

        return answer;
    }


    private String answer = null;

    public void dfs(TreeNode root, StringBuilder sb) {


        if (root == null) {
            return;
        }


        sb.append((char) (root.val + 'a'));

        if (root.left == null && root.right == null) {

            String path = sb.reverse().toString();
            sb.reverse();

            if (answer == null || answer.compareTo(path) > 0) {
                answer = path;
            }

        }

        dfs(root.left, sb);
        dfs(root.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }









}
