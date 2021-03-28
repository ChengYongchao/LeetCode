package com.kevin.leetcode;

import com.kevin.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q173 {
    class BSTIterator {
        Deque<TreeNode> d = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            dfsLeft(root);
        }

        void dfsLeft(TreeNode node) {
            while (node != null) {
                d.add(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode root = d.pollLast();
            int res = root.val;
            root = root.right;
            dfsLeft(root);
            return res;
        }

        public boolean hasNext() {
            return !d.isEmpty();
        }
    }
}
