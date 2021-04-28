package com.kevin.leetcode;

public class Q633 {
    class Solution {
        /**
         * 枚举
         *
         * @param c
         * @return
         */
        public boolean judgeSquareSum(int c) {
            int max = (int) Math.sqrt(c);
            for (int i = 0; i < max; i++) {
                int b = (int) Math.sqrt(c - i * i);
                if (b * b + i * i == c) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 双指针
         *
         * @param c
         * @return
         */
        public boolean judgeSquareSum1(int c) {
            int a = 0, b = (int) Math.sqrt(c);
            while (a <= b) {
                int ans = a * a + b * b;
                if (c == ans) {
                    return true;
                } else if (c > ans) {
                    a++;
                } else {
                    b--;
                }
            }
            return false;
        }
    }
}
