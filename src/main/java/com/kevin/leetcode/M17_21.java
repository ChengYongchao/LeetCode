package com.kevin.leetcode;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_21 {

    static class Solution {
        /**
         * 预处理最值解法
         * https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/gong-shui-san-xie-yi-ti-si-jie-po-su-yu-sqadp/
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int n = height.length;
            int ans = 0;
            if (n == 0) return ans;

            int[] lm = new int[n];
            lm[0] = height[0];
            for (int i = 1; i < n; i++) {
                lm[i] = Math.max(height[i], lm[i - 1]);
            }

            int[] rm = new int[n];
            rm[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rm[i] = Math.max(height[i], rm[i + 1]);
            }
            for (int i = 0; i < n; i++) {
                ans += Math.min(lm[i], rm[i]) - height[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
