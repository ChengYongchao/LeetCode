package com.kevin.jianzhioffer.tree;

public class Q28 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return next(root.left, root.right);
        }

        public boolean next(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null || left.val != right.val) return false;
            return next(left.left, right.right) && next(left.right, right.left);
        }
    }
}
