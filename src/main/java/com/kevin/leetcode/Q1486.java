package com.kevin.leetcode;

/**
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * 示例 2：
 * <p>
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * 示例 3：
 * <p>
 * 输入：n = 1, start = 7
 * 输出：7
 * 示例 4：
 * <p>
 * 输入：n = 10, start = 5
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1486 {
    class Solution {
        /**
         * 模拟解法
         *
         * @param n
         * @param start
         * @return
         */
        public int xorOperation(int n, int start) {
            int ans = start;
            for (int i = 0; i < n; i++) {
                int x = start + i * 2;
                ans ^= x;
            }
            return ans;
        }

        /**
         * 数学解法
         *
         * @param n
         * @param start
         * @return
         */
        public int xorOperation2(int n, int start) {
            int s = start >> 1;
            int last = n & start & 1;
            int prefix = calc(s - 1) ^ calc(s + n - 1);
            return prefix << 1 | last;
        }

        private int calc(int x) {
            switch (x % 4) {
                case 0:
                    return x;
                case 1:
                    return 1;
                case 2:
                    return x + 1;
                default:
                    return 0;
            }
        }
    }
}
