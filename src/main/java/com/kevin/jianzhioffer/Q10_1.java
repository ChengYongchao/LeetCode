package com.kevin.jianzhioffer;

public class Q10_1 {

    /**
     * 动态规划 求余运算
     * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/mian-shi-ti-10-i-fei-bo-na-qi-shu-lie-dong-tai-gui/
     */
    class Solution {
        public int fib(int n) {
            int a = 0, b = 1, sum;
            for (int i = 0; i < n; i++) {
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return a;
        }
    }
}
