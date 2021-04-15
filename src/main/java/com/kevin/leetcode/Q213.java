package com.kevin.leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q213 {
    class Solution {
        /**
         * 动态规划
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return nums[0];
            }
            //第一间房间不选
            int[][] f = new int[n][2];
            for (int i = 1; i < n - 1; i++) {
                //第i间不选，最大值为第i-1间选或者不选
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                //第i间选，最大值为第i-1间不选，第i间选
                f[i][1] = f[i - 1][0] + nums[i];
            }
            int a = Math.max(f[n - 2][1], f[n - 2][0] + nums[n - 1]);
            //第一间房间选,最后一间不选
            f[0][0] = 0;
            f[0][1] = nums[0];
            for (int i = 1; i < n - 1; i++) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                f[i][1] = f[i - 1][0] + nums[i];
            }
            int b = Math.max(f[n - 2][1], f[n - 2][0]);
            return Math.max(a, b);
        }
    }
}
