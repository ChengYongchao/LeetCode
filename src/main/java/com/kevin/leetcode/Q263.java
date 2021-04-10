package com.kevin.leetcode;

/**
 * @author chengyongchao
 */
public class Q263 {
    class Solution {
        /**
         * 解法1
         *
         * @param n
         * @return
         */
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }
            return p(n);
        }

        boolean p(int n) {
            if (n == 1 || n == 2 || n == 3 || n == 5) {
                return true;
            }
            boolean f1 = n % 2 == 0 ? true : false;
            boolean f2 = n % 3 == 0 ? true : false;
            boolean f3 = n % 5 == 0 ? true : false;
            return (f1 && p(n / 2)) || (f2 && p(n / 3)) || (f3 && p(n / 5));
        }

        /**
         * 解法2
         */
        public boolean isUgly2(int n) {
            if (n <= 0) {
                return false;
            }
            while (n % 2 == 0) {
                n /= 2;
            }
            while (n % 3 == 0) {
                n /= 3;

            }
            while (n % 5 == 0) {
                n /= 5;
            }
            return n == 1;
        }

    }
}
