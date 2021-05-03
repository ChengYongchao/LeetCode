package com.kevin.leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q7 {
    static class Solution {
        public int reverse(int x) {
            long res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }
            return (int) res == res ? (int) res : 0;
        }

        /**
         * 溢出判断解法
         *
         * @param x
         * @return
         */
        public int reverse2(int x) {
            if (x > 0) {
                return positiveNum(x);
            } else {
                return negativeNum(x);
            }
        }

        private int negativeNum(int x) {
            long res = 0;
            while (x != 0) {
                // res * 10 + x % 10 < Integer.Mix
                if (res < (Integer.MIN_VALUE - x % 10) / 10) {
                    return 0;
                }
                res = res * 10 + x % 10;
                x = x / 10;
            }
            return (int) res == res ? (int) res : 0;
        }

        private int positiveNum(int x) {
            long res = 0;
            while (x != 0) {
                // res * 10 + x % 10 > Integer.Max
                if (res > (Integer.MAX_VALUE - x % 10) / 10) {
                    return 0;
                }
                res = res * 10 + x % 10;
                x = x / 10;
            }
            return (int) res == res ? (int) res : 0;
        }
    }
}
