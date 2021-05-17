package com.kevin.leetcode;

import com.kevin.util.TreeNode;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q993 {
    static class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root.val == x || root.val == y) {
                return false;
            }
            int[] resX = dfs(root, null, 0, x);
            int[] resY = dfs(root, null, 0, y);
            return resX[1] == resY[1] && resX[0] != resY[0];
        }

        int[] dfs(TreeNode root, TreeNode fa, int depth, int t) {
            if (root == null) return new int[]{-1, -1};
            if (root.val == t) {
                return new int[]{fa != null ? fa.val : 1, depth};
            }
            int[] l = dfs(root.left, root, depth + 1, t);
            if (l[0] != -1) return l;
            return dfs(root.right, root, depth + 1, t);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = null;
        treeNode.left.right = new TreeNode(4);
        solution.isCousins(treeNode, 2, 3);
    }
}
