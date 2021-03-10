package com.kevin.jianzhioffer.tree;

public class Q27 {
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            change(root);
            return root;
        }

        public void change(TreeNode head) {
            if (head == null) return;
            TreeNode node = head.left;
            head.left = head.right;
            head.right = node;
            change(head.right);
            change(head.left);

        }
    }
}
