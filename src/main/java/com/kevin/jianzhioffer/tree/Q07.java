package com.kevin.jianzhioffer.tree;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q07 {
    /**
     * Definition for a binary tree node.
     */

    /**
     * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
     */
    class Solution {
        int[] preorder;
        HashMap<Integer, Integer> dic = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                dic.put(inorder[i], i);
            }
            return recur(0, 0, inorder.length - 1);
        }

        TreeNode recur(int root, int left, int right) {
            if (left > right) {
                return null;
            }
            TreeNode node = new TreeNode(preorder[root]);
            //获取中序遍历中root的位置
            int i = dic.get(preorder[root]);
            node.left = recur(root + 1, left, i - 1);
            node.right = recur(root + (i - left) + 1, i + 1, right);
            return node;
        }
    }
}
