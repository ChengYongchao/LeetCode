package com.kevin.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1690
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q264 {
    class Solution {

        /**
         * 优先队列（小根堆）解法
         *
         * @param n
         * @return
         */
        private int[] nums = {2, 3, 5};

        public int nthUglyNumber1(int n) {
            Set<Long> set = new HashSet<>();
            Queue<Long> queue = new PriorityQueue<>();
            set.add(1L);
            queue.add(1L);
            for (int i = 1; i <= n; i++) {
                long min = queue.poll();
                if (i == n) {
                    return (int) min;
                }
                for (int num : nums) {
                    long r = min * num;
                    if (!set.contains(r)) {
                        set.add(r);
                        queue.add(r);
                    }
                }
            }
            return -1;
        }


        /**
         * 多路归并（多指针）解法
         *
         * @param n
         * @return
         */
        public int nthUglyNumber2(int n) {
            int[] arr = new int[n];
            arr[0] = 1;
            for (int a1 = 0, a2 = 0, a3 = 0, index = 1; index < n; index++) {
                int b1 = arr[a1] * 2, b2 = arr[a2] * 3, b3 = arr[a3] * 5;
                int min = Math.min(b1, Math.min(b2, b3));
                if (min == b1) {
                    a1++;
                }
                if (min == b2) {
                    a2++;
                }
                if (min == b3) {
                    a3++;
                }
                arr[index] = min;
            }
            return arr[n - 1];
        }
    }
}
