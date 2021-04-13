package com.kevin.leetcode;

import com.kevin.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q783 {

    class Solution {
        int ans = Integer.MAX_VALUE;
        TreeNode prev = null;

        /**
         * 根据二叉搜索树，使用中序遍历保证数据有序性
         *
         * @param root
         * @return
         */
        public int minDiffInBST(TreeNode root) {
            Deque<TreeNode> d = new ArrayDeque<>();
            while (root != null || !d.isEmpty()) {

                while (root != null) {
                    d.addLast(root);
                    root = root.left;
                }
                root = d.pollLast();
                if (prev != null) {
                    ans = Math.min(ans, Math.abs(prev.val - root.val));
                }
                prev = root;
                root = root.right;
            }
            return ans;
        }
    }
}
