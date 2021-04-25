package com.kevin.leetcode;

import com.kevin.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q897 {
    class Solution {
        List<TreeNode> list = new ArrayList<>();

        public TreeNode increasingBST(TreeNode root) {
            dfs(root);
            TreeNode treeNode = new TreeNode(-1);
            TreeNode cur = treeNode;
            for (TreeNode node : list) {
                cur.right = node;
                node.left = null;
                cur = node;
            }
            return treeNode.right;
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            list.add(node);
            dfs(node.right);
        }
    }
}
