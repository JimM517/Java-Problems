package TreeProbs;

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
//    public TreeNode invertTree(TreeNode root) {
//
//        if (root == null) {
//            return null;
//        }
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while (q.size() > 0) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode temp = q.remove();
//                invert(temp);
//                if (temp.left != null) q.add(temp.left);
//                if (temp.right != null) q.add(temp.right);
//            }
//        }
//
//        return root;
//
//    }
//
//
//
//    private static void invert(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = temp;
//    }



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





}
