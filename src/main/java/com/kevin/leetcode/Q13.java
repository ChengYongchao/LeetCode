package com.kevin.leetcode;

public class Q13 {
    class Solution {

        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public int romanToInt(String s) {
            int ans = 0;
            int n = s.length();
            for (int i = 0, j = 0; i < str.length && j < n; i++) {
                int a = val[i];
                String b = str[i];
                int size = b.length();
                while (j + size <= n && s.substring(j, j + size).equals(b)) {
                    ans += a;
                    j += b.length();
                }
            }
            return ans;
        }
    }
}
